package com.example.ucevaapp20232;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TranslationApi {
    @FormUrlEncoded
     @POST("language/translate/v2")
    Call<TranslationResponse> translate(
             @Field("key") String apiKey,
            @Field("q") String text,
             @Field("source") String sourceLanguage,
            @Field("target") String targetLanguage
    );
}
