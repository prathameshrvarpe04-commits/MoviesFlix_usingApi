package com.example.moviesflix;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesflix.Adapter.CategoryAdapter;
import com.example.moviesflix.DataClass.Movie;
import com.example.moviesflix.DataClass.moviesCategory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.main_recycler_view);

        List<moviesCategory> allCategories = createDummyData();
        CategoryAdapter categoryAdapter = new CategoryAdapter(this, allCategories);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(categoryAdapter);
    }

    private List<moviesCategory> createDummyData() {
        List<moviesCategory> allCategories = new ArrayList<>();

        // --- Category 1: Action Movies ---
        List<Movie> actionMovies = new ArrayList<>();
        actionMovies.add(new Movie("Action Movie 1", R.drawable.movie1));
        actionMovies.add(new Movie("Action Movie 2", R.drawable.m2));
        actionMovies.add(new Movie("Action Movie 3", R.drawable.m3));
        actionMovies.add(new Movie("Action Movie 4", R.drawable.m5));
        allCategories.add(new moviesCategory("Action", actionMovies));

        // --- Category 2: Comedy Movies ---
        List<Movie> comedyMovies = new ArrayList<>();
        comedyMovies.add(new Movie("Comedy 1", R.drawable.cm1));
        comedyMovies.add(new Movie("Comedy 2", R.drawable.cm2));
        comedyMovies.add(new Movie("Comedy 3", R.drawable.cm3));
        allCategories.add(new moviesCategory("Comedy", comedyMovies));

        // --- Category 3: Trending ---
        List<Movie> trendingMovies = new ArrayList<>();
        trendingMovies.add(new Movie("Trending 1", R.drawable.tm1));
        trendingMovies.add(new Movie("Trending 2", R.drawable.tm2));
        trendingMovies.add(new Movie("Trending 3", R.drawable.tm3));
        trendingMovies.add(new Movie("Trending 4", R.drawable.tm4));
        trendingMovies.add(new Movie("Trending 5", R.drawable.tm5  ));
        allCategories.add(new moviesCategory("Trending Now", trendingMovies));

        List<Movie> series = new ArrayList<>();
        series.add(new Movie("Lost" , R.drawable.s3));
        series.add(new Movie("Lost" , R.drawable.s1));
        series.add(new Movie("Lost" , R.drawable.s2));
        series.add(new Movie("Lost" , R.drawable.s4));
        series.add(new Movie("Lost" , R.drawable.s5));
        allCategories.add(new moviesCategory("Series" , series));

        List<Movie> recentlyWatched = new ArrayList<>();
        recentlyWatched.add(new Movie("Recent 1", R.drawable.cm3));
        recentlyWatched.add(new Movie("Recent 2", R.drawable.m5));
        recentlyWatched.add(new Movie("Recent 3", R.drawable.tm3));
        recentlyWatched.add(new Movie("Recent 4", R.drawable.movie1));
        recentlyWatched.add(new Movie("Recent 4", R.drawable.s3  ));
        recentlyWatched.add(new Movie("Recent 4", R.drawable.s2  ));
        recentlyWatched.add(new Movie("Recent 4", R.drawable.tm4  ));
        recentlyWatched.add(new Movie("Recent 4", R.drawable.s4  ));
        allCategories.add(new moviesCategory("Recently Watched", recentlyWatched));


        return allCategories;
    }
}
