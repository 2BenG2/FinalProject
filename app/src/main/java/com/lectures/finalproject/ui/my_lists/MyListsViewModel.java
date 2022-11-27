package com.lectures.finalproject.ui.my_lists;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lectures.finalproject.models.lists.MyList;

import java.util.List;

public class MyListsViewModel extends ViewModel {


    private MutableLiveData<List<MyList>> myListsLiveData;



    public LiveData<List<MyList>> getLists() {

        if (myListsLiveData == null) {
            myListsLiveData = new MutableLiveData<>();
        }

        return myListsLiveData;
    }
}