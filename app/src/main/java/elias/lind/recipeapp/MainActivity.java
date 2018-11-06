package elias.lind.recipeapp;

import android.icu.util.Output;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

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

    private ArrayList<Recipe> mRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View();

        mRecipe = new ArrayList<>();
        mRecipe.add(new Recipe("Tortillas de Patata", 60, Arrays.asList("Patatas", "Huevos"), "Cook and enjoy"));

        nameDish.setText(mRecipe.get(0).getName());
        time.setText(Integer.toString(mRecipe.get(0).getMinutes())+" minutos");
        String mRecipeString = TextUtils.join("\n\n", mRecipe.get(0).getIngredients());
        ingredientesText.setText(mRecipeString);
        recepie.setText(mRecipe.get(0).getDescription());
        }


    private void View(){

        nameDish = findViewById(R.id.nameDish);
        time = findViewById(R.id.time);
        preparasion = findViewById(R.id.preparacion);
        recepie = findViewById(R.id.recepie);
        ingredientes = findViewById(R.id.ingredientes);
        ingredientesText = findViewById(R.id.ingredientesText);

        anadir = findViewById(R.id.button);
    }
}
