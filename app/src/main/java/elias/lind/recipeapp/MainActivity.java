package elias.lind.recipeapp;

import android.content.Intent;
import android.icu.util.Output;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private TextView nameDish;
    private TextView time;
    private TextView preparasion;
    private TextView recepie;
    private TextView ingredientes;
    private TextView ingredientesText;
    private Button anadir;
    public static final int TEXT_REQUEST = 1;
    private Boolean mStart = true;

    public ArrayList<Recipe> mRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecipe = new ArrayList<>();
        mRecipe.add(new Recipe("Omelette", 30, null, "Season beaten eggs with salt and pepper.\nHeat oil and butter in a frying pan over a medium-low heat\n" +
                "\n" + "Pour the eggs into the pan. Let the mixture cook for about 20 seconds then scrape a line through the middle with a spatula, turn and cook for another 5 minutes. "));
        if (mStart) {
            mRecipe.get(0).setIngredients(Arrays.asList("3 eggs", "1 tsp oil/butter", "salt & pepper"));
        }
        mStart = false;
        View();

        final Intent intent = new Intent(this, NewIngredientActivity.class);


        anadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(intent, TEXT_REQUEST);

            }
        });
    }

    private void View() {

        nameDish = findViewById(R.id.nameDish);
        time = findViewById(R.id.time);
        preparasion = findViewById(R.id.preparacion);
        recepie = findViewById(R.id.recepie);
        ingredientes = findViewById(R.id.ingredientes);
        ingredientesText = findViewById(R.id.ingredientesText);

        anadir = findViewById(R.id.button);

        nameDish.setText(mRecipe.get(0).getName());
        time.setText(Integer.toString(mRecipe.get(0).getMinutes()) + " minutes");
        String mRecipeString = TextUtils.join("\n\n", mRecipe.get(0).getIngredients());
        ingredientesText.setText(mRecipeString);
        recepie.setText(mRecipe.get(0).getDescription());
    }

    public void onActivityResult(int requestCode, int resultCode,
                                 Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                ArrayList<String> lines;
                lines = new ArrayList<>();
                final List<String> message = mRecipe.get(0).getIngredients();
                lines.addAll(message);
                String reply = data.getStringExtra(NewIngredientActivity.Reply);
                lines.add(reply);
                mRecipe.get(0).setIngredients(lines);
                String mRecipeString = TextUtils.join("\n\n", mRecipe.get(0).getIngredients());
                ingredientesText.setText(mRecipeString);

            }
        }
    }
}
