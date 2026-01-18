package com.example.moviesflix.DataClass;

import java.util.List;

public class moviesCategory {

    String category ;
    List<Movie> movies ;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public moviesCategory(String category, List<Movie> movies) {
        this.category = category;
        this.movies = movies;
    }
}
