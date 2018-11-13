package elias.lind.recipeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class NewIngredientActivity extends MainActivity {


    public static final String Reply = "Reply";
    private EditText mMessageEditText;
    private ArrayList<String> lines;
    private Button addIng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_ingredient);

        mMessageEditText = findViewById(R.id.newIngredientEdit);
        addIng = findViewById(R.id.addIng);



        lines = new ArrayList<>();

        addIng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message2 = mMessageEditText.getText().toString();


                Intent replyIntent = new Intent();
                replyIntent.putExtra(Reply, message2);
                setResult(RESULT_OK, replyIntent);
                finish();

            }
        });


    }


}
