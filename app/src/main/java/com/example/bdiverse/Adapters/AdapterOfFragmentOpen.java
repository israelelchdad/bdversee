package com.example.bdiverse.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bdiverse.Objects.Task;
import com.example.bdiverse.R;

import java.util.ArrayList;

public class AdapterOfFragmentOpen extends RecyclerView.Adapter<AdapterOfFragmentOpen.ViewHolder> {
    private ArrayList<Task> myListTask;

    public AdapterOfFragmentOpen(ArrayList<Task> myListTask) {
       this.myListTask = myListTask;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setHolder(myListTask.get(position));


    }

    @Override
    public int getItemCount() {
        return myListTask.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView ifDraft;
        TextView id;
        TextView dateAndTime;
        TextView nameCompany;
        TextView locationCompany;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            ifDraft =itemView.findViewById(R.id.item_isdraft);
            id =itemView.findViewById(R.id.item_id);
            dateAndTime =itemView.findViewById(R.id.item_dateAndTime);
            nameCompany =itemView.findViewById(R.id.item_nameCompany);
            locationCompany =itemView.findViewById(R.id.item_locationCompany);
        }

        public void setHolder(Task task) {
            title.setText(task.getTitle());
            boolean ifdraft = task.isDraft();
            if(ifdraft){
                ifDraft.setText("Draft");
            }
            else {
                ifDraft.setText("");

            }

            id.setText(String.valueOf(task.getId()));
            dateAndTime.setText(task.getDate()+task.getTimeStart()+task.getTimeEnd());
            nameCompany.setText(task.getNameCmpany());
            locationCompany.setText(task.getLocationCompany());
        }
    }
}
