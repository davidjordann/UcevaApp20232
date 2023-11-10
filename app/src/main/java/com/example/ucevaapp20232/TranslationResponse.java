package com.example.ucevaapp20232;

import java.util.List;

public class TranslationResponse {
    private Data data;

    public Data getData() {
        return data;
    }

    public class Data {
        private List<Translation> translations;

        public List<Translation> getTranslations() {
            return translations;
        }
    }

    public class Translation {
           private String translatedText;

            public String getTranslatedText() {
              return translatedText;
        }
    }
}


