package elias.lind.recipeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class NewIngredientActivity extends MainActivity {

    public static final String EXTRA_MESSAGE = "elias.lind.recipeapp.extra.MESSAGE";
    private EditText mMessageEditText;
    private ArrayList<String> ingredients;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_ingredient);

        mMessageEditText = findViewById(R.id.newIngredientEdit);
        String message = mMessageEditText.getText().toString();

    }


}
