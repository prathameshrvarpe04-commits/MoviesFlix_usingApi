package com.example.moviesflix.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesflix.DataClass.moviesCategory;
import com.example.moviesflix.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    Context context ;
    List<moviesCategory> moviesCategories ;

    private final MovieAdapter.OnMovieClickListener movieClickListener ;


    public CategoryAdapter(Context context, List<moviesCategory> moviesCategories, MovieAdapter.OnMovieClickListener movieClickListener) {
        this.context = context;
        this.moviesCategories = moviesCategories;
        this.movieClickListener = movieClickListener;
    }

    @NonNull
    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_layout , parent , false);

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {

        moviesCategory category = moviesCategories.get(position);
        holder.categoryTitle.setText(category.getCategory());

        // now inner recycle view

        MovieAdapter movieAdapter = new MovieAdapter(context , category.getMovies() , movieClickListener);
        holder.childRecycleView.setAdapter(movieAdapter);
        holder.childRecycleView.setLayoutManager(new LinearLayoutManager(context , RecyclerView.HORIZONTAL , false));
    }

    @Override
    public int getItemCount() {
        return moviesCategories.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView categoryTitle ;

        RecyclerView childRecycleView ;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryTitle = itemView.findViewById(R.id.category_title_text_view);
            childRecycleView = itemView.findViewById(R.id.child_recycler_view);

        }
    }

}
