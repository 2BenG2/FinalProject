package com.lectures.finalproject.ui.my_lists;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.lectures.finalproject.R;
import com.lectures.finalproject.adapters.ListAdapter;
import com.lectures.finalproject.databinding.FragmentMyListsBinding;
import com.lectures.finalproject.enums.MovieListType;
import com.lectures.finalproject.tools.AuthCheckTool;

import java.util.Objects;

public class MyListsFragment extends Fragment {

    private FragmentMyListsBinding binding;
    private MyListsViewModel myListsViewModel;
    private FloatingActionButton btnAddNewList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myListsViewModel = new ViewModelProvider(this).get(MyListsViewModel.class);
        binding = FragmentMyListsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.rv_my_lists);

        myListsViewModel.getLists().observe(getViewLifecycleOwner(),lists->{
            recyclerView.setAdapter(new ListAdapter(lists));
            recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 1));
        });


        btnAddNewList = view.findViewById(R.id.btn_add_new_list);
        btnAddNewList.setOnClickListener(view1 -> {

        });


    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}