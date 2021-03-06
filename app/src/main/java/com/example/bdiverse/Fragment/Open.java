package com.example.bdiverse.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.bdiverse.Adapters.AdapterOfFragmentOpen;
import com.example.bdiverse.Objects.Task;
import com.example.bdiverse.R;

import java.util.ArrayList;


public class Open extends Fragment {
    private OnFragmentOpenListener mListener;
    ArrayList<Task> myListTask;
    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager mylayoutManager;
    private AdapterOfFragmentOpen myAdapter;
    EditText myEditTextSerch;

    public Open() {


    }

    public static Open newInstance() {
        Open fragment = new Open();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initListTasks();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_open, container, false);

        initRecaclerView(view);

        return view;
    }

    private void initRecaclerView(View view) {
        myRecyclerView = view.findViewById(R.id.fo_myrecyercleview);
        mylayoutManager = new LinearLayoutManager(getContext());
        myRecyclerView.setLayoutManager(mylayoutManager);
        myAdapter = new AdapterOfFragmentOpen(initListTasks());
        myRecyclerView.setAdapter(myAdapter);
        initSerchTask(view);
    }
    private void initSerchTask(View view) {
        myEditTextSerch= view.findViewById(R.id.fopen_editserch_ET);
        myEditTextSerch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                myAdapter.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentOpenListener) {
            mListener = (OnFragmentOpenListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentOpenListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    private ArrayList<Task> initListTasks() {
        myListTask = new ArrayList<>();
        myListTask.add(new Task("Garden cleaning test",false,189,"oct 06 |","14:00 -","15:00","Catering israel LTD.","Employees feeding, south"));
        myListTask.add(new Task("Smoke detector test",true,193,"oct 06 |","14:00 -","15:00","Fire deteaction Systems LTD.","Maintenance of Fire detection System,center"));
        myListTask.add(new Task("Garden cleaning test",false,189,"oct 06 |","14:00 -","15:00","Catering israel LTD.","Employees feeding, south"));
        myListTask.add(new Task("Smoke detector test",true,193,"oct 06 |","14:00 -","15:00","Fire deteaction Systems LTD.","Maintenance of Fire detection System,center"));
        myListTask.add(new Task("Garden cleaning test",false,189,"oct 06 |","14:00 -","15:00","Catering israel LTD.","Employees feeding, south"));
        myListTask.add(new Task("Smoke detector test",true,193,"oct 06 |","14:00 -","15:00","Fire deteaction Systems LTD.","Maintenance of Fire detection System,center"));
        myListTask.add(new Task("Garden cleaning test",false,189,"oct 06 |","14:00 -","15:00","Catering israel LTD.","Employees feeding, south"));
        myListTask.add(new Task("Smoke detector test",true,193,"oct 06 |","14:00 -","15:00","Fire deteaction Systems LTD.","Maintenance of Fire detection System,center"));
        return myListTask;
    }


    public interface OnFragmentOpenListener {
        void FragmentOpen ();

    }
}
