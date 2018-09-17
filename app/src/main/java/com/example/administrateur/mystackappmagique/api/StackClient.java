package com.example.administrateur.mystackappmagique.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StackClient {
    private static String URL_BASE = "https://api.stackexchange.com/2.2/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
