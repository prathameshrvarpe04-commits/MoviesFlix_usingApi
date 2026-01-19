package com.example.moviesflix.Activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.moviesflix.DataClass.Movie;
import com.example.moviesflix.R;

public class DetailActivity extends AppCompatActivity {

    private ImageView moviePoster ;
    private TextView movieTitle ;
    private TextView movieOverview;
    private Movie movie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        moviePoster = findViewById(R.id.detail_movie_poster);
        movieTitle = findViewById(R.id.detail_movie_title);
        movieOverview = findViewById(R.id.detail_movie_overview);

        movie = getIntent().getParcelableExtra("Movie_Detail");

        if (movie != null){
            movieTitle.setText(movie.getTitle());
            movieOverview.setText(movie.getOverView());

            Glide.with(this)
                    .load(movie.getPosterPath())
                    .into(moviePoster);

        }



    }
}