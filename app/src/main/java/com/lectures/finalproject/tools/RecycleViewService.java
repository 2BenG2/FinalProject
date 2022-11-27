package com.lectures.finalproject.tools;

import android.content.Context;
import android.content.Intent;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lectures.finalproject.InfoPageActivity;
import com.lectures.finalproject.adapters.MovieAdapter;
import com.lectures.finalproject.adapters.SeriesAdapter;
import com.lectures.finalproject.models.lists.MyList;
import com.lectures.finalproject.models.series.*;
import com.lectures.finalproject.models.movies.*;


import java.util.List;

public interface RecycleViewService {
    String CONTENT = "CONTENT";

    static void setRecycleView(RecyclerView recyclerView, List<Movie> movieList){
        recyclerView.setAdapter(new MovieAdapter(movieList));
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 1));
    }
    static void setRecycleView( List<Series> seriesList,RecyclerView recyclerView){
        recyclerView.setAdapter(new SeriesAdapter(seriesList));
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 1));
    }
    static void setOnClickToDetails(Movie movie, Context context){
        Intent intent = new Intent(context, InfoPageActivity.class);
        intent.putExtra(CONTENT,movie);
        context.startActivity(intent);
    }
    static void setOnClickToDetails(Series series, Context context){
        Intent intent = new Intent(context, InfoPageActivity.class);
        intent.putExtra(CONTENT,series);
        context.startActivity(intent);
    }



}
