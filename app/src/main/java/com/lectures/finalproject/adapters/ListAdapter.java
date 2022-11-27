package com.lectures.finalproject.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lectures.finalproject.R;
import com.lectures.finalproject.models.lists.MyList;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private List<MyList> myLists;

    public ListAdapter(List<MyList> myLists){
        this.myLists = myLists;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cube,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        MyList myList = myLists.get(position);
        holder.listName.setText(myList.getName());
        holder.numOfItems.setText(String.valueOf(myList.getContentList().size()));
        holder.dateCreated.setText(String.valueOf(myList.getDateCreated()));
        holder.imageView.setImageResource(R.drawable.yellow_concrate);

        if(getItemCount() - 1 == position){

        }
    }

    @Override
    public int getItemCount() {
        if (myLists == null) {
            return 0;
        }

        return myLists.size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder {
        final TextView listName ;
        final TextView numOfItems ;
        final TextView dateCreated ;
        final ImageView imageView;


        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            listName = itemView.findViewById(R.id.list_name);
            numOfItems = itemView.findViewById(R.id.tv_my_list_num_of_items);
            dateCreated = itemView.findViewById(R.id.tv_create_date);
            imageView = itemView.findViewById(R.id.im_my_list_img);
            itemView.setOnClickListener(v->{

            });
        }
    }
}

