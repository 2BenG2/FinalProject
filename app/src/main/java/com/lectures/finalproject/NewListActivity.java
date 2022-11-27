package com.lectures.finalproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.ui.AppBarConfiguration;


import com.lectures.finalproject.databinding.ActivityNewListBinding;
import com.lectures.finalproject.enums.ContentType;
import com.lectures.finalproject.models.lists.MyList;

public class NewListActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityNewListBinding binding;
    private MyList newList;
    private ToggleButton tbtnMovies;
    private ToggleButton tbtnSeries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNewListBinding.inflate(getLayoutInflater());



        TextView name = binding.etNewListName;
         tbtnMovies = binding.tbtnMovies;
         tbtnSeries = binding.tbtnSeries;
        tbtnMovies.setOnClickListener(v->{
            if(v.isActivated()){
                tbtnSeries.setActivated(false);
                newList.setListType(ContentType.MOVIE);
            }else{
                tbtnSeries.setActivated(true);
                newList.setListType(ContentType.SERIES);
            }
        });
        tbtnSeries.setOnClickListener(v->{
            if(v.isActivated()){
                tbtnMovies.setActivated(false);
                newList.setListType(ContentType.SERIES);
            }else{
                tbtnMovies.setActivated(true);
                newList.setListType(ContentType.MOVIE);
            }
        });



        Button newListBtn = binding.btnCreateNewList;
        newListBtn.setOnClickListener(v->{

        });

    }
    public void setNewList(){
        TextView tvName = binding.etNewListName;


    }

}