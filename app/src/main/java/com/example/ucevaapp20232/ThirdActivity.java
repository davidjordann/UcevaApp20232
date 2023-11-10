package com.example.ucevaapp20232;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThirdActivity extends AppCompatActivity {

        private EditText spanishInput;
    private EditText englishOutput;

    @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

          spanishInput = findViewById(R.id.spanishInput);
        Button translateButton = findViewById(R.id.translateButton);
         englishOutput = findViewById(R.id.englishOutput);

        translateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = spanishInput.getText().toString();
                    if (!inputText.isEmpty()) {
                      translateToEnglish(inputText);
                 } else {
                     englishOutput.setText("Ingresa Texto a traducir. :3");
                    }
             }
        });

            Button backToSecondButton = findViewById(R.id.backToSecondButton);
         backToSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
                    startActivity(intent);
                 finish();
            }
        });
    }

    private void translateToEnglish(String spanishText) {
           String apiKey = "AIzaSyAS5DnKAo1sfwq4m4cR3uXgo3HyXIPfZnc";
        TranslationApi translationApi = ApiClient.getApiService();
          Call<TranslationResponse> call = translationApi.translate(apiKey, spanishText, "es", "en");

        call.enqueue(new Callback<TranslationResponse>() {
            @Override
               public void onResponse(Call<TranslationResponse> call, Response<TranslationResponse> response) {
                   if (response.isSuccessful() && response.body() != null) {
                    String translatedText = response.body().getData().getTranslations().get(0).getTranslatedText();
                      englishOutput.setText(translatedText);
                } else {
                    englishOutput.setText("Ey pequeño no digas eso");
                }
            }

            @Override
               public void onFailure(Call<TranslationResponse> call, Throwable t) {
                 englishOutput.setText("Ey pequeño, hay un error en la traduccion");
            }
        });
    }
}
