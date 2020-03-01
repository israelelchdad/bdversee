package com.example.bdiverse.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bdiverse.Objects.Task;
import com.example.bdiverse.R;

import java.util.ArrayList;

public class AdapterOfFragmentOpen extends RecyclerView.Adapter<AdapterOfFragmentOpen.ViewHolder> implements Filterable {
    private ArrayList<Task> myListTask;
    private ArrayList<Task> myFilterListTask = new ArrayList<>();
    private TaskFilter myTaskFilter = new TaskFilter();

    public AdapterOfFragmentOpen(ArrayList<Task> myListTask) {
       this.myListTask = myListTask;
       myFilterListTask.addAll(myListTask);


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setHolder(myFilterListTask.get(position));


    }

    @Override
    public int getItemCount() {
        return myFilterListTask.size();
    }

    @Override
    public Filter getFilter() {

        return myTaskFilter;
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
    private class  TaskFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            ArrayList<Task> myListAlltemFilter = new ArrayList<>();
            myFilterListTask.clear();
            for (Task myTask : myListTask) {
                if (myTask.getTitle().toLowerCase().contains(constraint.toString().toLowerCase())){
                    myListAlltemFilter.add(myTask);
                }

            }
            results.values = myListAlltemFilter;
            results.count = myListAlltemFilter.size();
            return results ;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            myFilterListTask = (ArrayList<Task>) results.values;
            notifyDataSetChanged();

        }
    }
}
