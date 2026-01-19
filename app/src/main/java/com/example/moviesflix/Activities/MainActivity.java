package com.example.moviesflix.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesflix.Adapter.CategoryAdapter;
import com.example.moviesflix.Adapter.MovieAdapter;
import com.example.moviesflix.DataClass.Movie;
import com.example.moviesflix.DataClass.moviesCategory;
import com.example.moviesflix.R;
import com.example.moviesflix.api.MovieResponse;
import com.example.moviesflix.api.RetrofitClient;
import com.example.moviesflix.api.TmbdApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MovieAdapter.OnMovieClickListener {

    RecyclerView mainrecyclerView;
    CategoryAdapter categoryAdapter;
    List<moviesCategory> allCategories = new ArrayList<>();

    ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressBar = findViewById(R.id.progress);
        mainrecyclerView = findViewById(R.id.main_recycler_view);
        mainrecyclerView.setLayoutManager(new LinearLayoutManager(this));

        categoryAdapter = new CategoryAdapter(this, allCategories ,this);
        mainrecyclerView.setAdapter(categoryAdapter);

        fetchPopularMovies();

    }

    private void fetchPopularMovies(){

        progressBar.setVisibility(View.VISIBLE);


        TmbdApi apiService = RetrofitClient.getClient();

        String apiKey = "2e5dd989693ca773e22513f0f5d1ad44" ;

        apiService.getPopularMovies(apiKey).enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {

                if (response.isSuccessful() && response.body() != null){
                    List<Movie> popularMovies = response.body().getMovies();

                    allCategories.add(new moviesCategory("Popular Movies" , popularMovies));
                    categoryAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);

                } else {
                    Log.e("MainActivity" , "Api Error : " + response.code()+" " + response.message());
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

                Log.e("MainActivity", "Api Failure: " + t.getMessage());
                progressBar.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public void onMovieClick(Movie movie) {

        Intent intent = new Intent(this , DetailActivity.class);
        intent.putExtra("Movie_Detail" , movie);
        startActivity(intent);

    }
}
