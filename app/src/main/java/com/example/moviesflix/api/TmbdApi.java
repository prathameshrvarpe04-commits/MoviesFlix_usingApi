package com.example.moviesflix.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TmbdApi {

    @GET("movie/popular")
    Call<MovieResponse> getPopularMovies(@Query("api_key")String apiKey);

}
