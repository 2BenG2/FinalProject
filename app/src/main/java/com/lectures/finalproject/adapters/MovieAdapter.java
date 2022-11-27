package com.lectures.finalproject.adapters;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lectures.finalproject.R;
import com.lectures.finalproject.models.movies.*;
import com.lectures.finalproject.tools.DownloadImageTask;
import com.lectures.finalproject.tools.RecycleViewService;


import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {


    private List<Movie> movies;


    public MovieAdapter(List<Movie> movies) {
        this.movies = movies;

    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_cube,parent,false);
        return new MovieViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        new DownloadImageTask(holder.movieImg).execute("https://image.tmdb.org/t/p/w300_and_h450_bestv2" + movie.getPosterPath());
        holder.movieTitle.setText(movie.getTitle());
        holder.movieReleaseDate.setText(movie.getReleaseDate());
        holder.movieVotes.setText(String.valueOf(movie.getVote_average())+"/10");
        holder.movieSummary.setText(movie.getOverview());
        holder.movie = movie;
        if(getItemCount() - 1 == position){

        }

    }

    @Override
    public int getItemCount() {
        if (movies == null) {
            return 0;
        }

        return movies.size();
    }


    static class MovieViewHolder extends RecyclerView.ViewHolder {
        final ImageView movieImg ;
        final TextView movieTitle ;
        final TextView movieVotes;
        final TextView movieReleaseDate ;
        final TextView movieSummary ;
        private Movie movie;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImg = itemView.findViewById(R.id.iv_movie_image);
            movieTitle = itemView.findViewById(R.id.tv_movie_title);
            movieReleaseDate = itemView.findViewById(R.id.tv_release_date);
            movieSummary = itemView.findViewById(R.id.tv_sum);
            movieVotes = itemView.findViewById(R.id.tv_avg_votes);
            itemView.setOnClickListener(v->{
                RecycleViewService.setOnClickToDetails(movie, v.getContext());
            });
        }

    }

}

