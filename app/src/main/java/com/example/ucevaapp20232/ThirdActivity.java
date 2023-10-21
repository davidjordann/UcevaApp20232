package com.example.ucevaapp20232;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_third);

        final EditText spanishInput = findViewById(R.id.spanishInput);
         Button translateButton = findViewById(R.id.translateButton);
        final EditText englishOutput = findViewById(R.id.englishOutput);

           translateButton.setOnClickListener(new View.OnClickListener() {
            @Override
              public void onClick(View view) {
                String translatedText = translateToEnglish(spanishInput.getText().toString());
                englishOutput.setText(translatedText);
            }
        });


          final Button backToSecondButton = findViewById(R.id.backToSecondButton);
         backToSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View view) {
                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

     private String translateToEnglish(String spanishText) {
             HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("hola", "hello");
         dictionary.put("adios", "goodbye");
        dictionary.put("gracias", "thank you");
        dictionary.put("por favor", "please");
        dictionary.put("amigo", "friend");
        dictionary.put("agua", "water");
        dictionary.put("comida", "food");
        dictionary.put("sí", "yes");
        dictionary.put("no", "no");
        dictionary.put("dia", "day");
        dictionary.put("noche", "night");
        dictionary.put("sol", "sun");
        dictionary.put("luna", "moon");
         dictionary.put("estrella", "star");
        dictionary.put("cielo", "sky");
        dictionary.put("tierra", "earth");
        dictionary.put("hombre", "man");
        dictionary.put("mujer", "woman");
        dictionary.put("niño", "child");
        dictionary.put("feliz", "happy");
        dictionary.put("triste", "sad");
        dictionary.put("amor", "love");
         dictionary.put("odio", "hate");

        String translatedText = dictionary.get(spanishText.toLowerCase());

        if (translatedText == null) {
            return "uy mi rey! intenta con otra palabra :3";
        } else {
            return translatedText;
        }
    }
    }


