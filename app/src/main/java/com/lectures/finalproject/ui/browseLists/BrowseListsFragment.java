package com.lectures.finalproject.ui.browseLists;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.lectures.finalproject.databinding.FragmentBrowseListsBinding;


public class BrowseListsFragment extends Fragment {

    private FragmentBrowseListsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BrowseListsViewModel dashboardViewModel =
                new ViewModelProvider(this).get(BrowseListsViewModel.class);

        binding = FragmentBrowseListsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textBrowseLists;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}