package com.example.moviesflix.DataClass;

import static java.lang.System.in;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Movie implements Parcelable {
    @SerializedName("title")
    private String title;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("overview")
    private String overView;

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        // The API gives a partial path, so we build the full URL here.
        if (posterPath != null && !posterPath.startsWith("http")) {
            return "https://image.tmdb.org/t/p/w500" + posterPath;
        }
        return posterPath;
    }

    public String getOverView() {
        return overView;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {

        dest.writeString(title);
        dest.writeString(posterPath);
        dest.writeString(overView);
    }

    protected Movie(Parcel in) {

        title = in.readString();
        posterPath = in.readString();
        overView = in.readString();

    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

}
