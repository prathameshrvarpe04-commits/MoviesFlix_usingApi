package com.example.moviesflix.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

   public static final String Base_Url = "https://api.themoviedb.org/3/";

    public static Retrofit retrofit = null ;

    public static TmbdApi getClient(){

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Base_Url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(TmbdApi.class);

    }

}
