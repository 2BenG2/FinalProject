package com.lectures.finalproject.ui.browseLists;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BrowseListsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public BrowseListsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is browseLists fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}