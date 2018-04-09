package com.example.android.upr9;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.android.upr9.R;

import java.util.ArrayList;

public class ListFragment extends Fragment {


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        initUI(rootView);
        return rootView;
    }

    private void initUI(View rootView) {
        final ListView listView = rootView.findViewById(R.id.listView);
        final ArrayList<Course> arr = generateData();
        ListViewAdapter adapter = new ListViewAdapter(arr, getActivity());
        listView.setAdapter(adapter);
    }



    private ArrayList<Course> generateData() {
        ArrayList<Course> list = new ArrayList<>();
        list.add(new Course("English", 5, true,"#66cd00"));
        list.add(new Course("Maths", 5, false,"#eaa2c8"));
        list.add(new Course("History", 4, true,"#ff0000"));
        list.add(new Course("Music", -1, true,"#66cd00"));
        list.add(new Course("Geography", -1, false,"#ff0000"));
        list.add(new Course("Chemistry", -1, false,"#c7c700"));
        list.add(new Course("Psychology", -1, true,"#cd96cd"));
        list.add(new Course("Biology", -1, false,"#008000"));
        list.add(new Course("Dutch", -1, true,"#60be98"));
        list.add(new Course("French", -1, true,"#5a7443"));
        list.add(new Course("Sport", -1, true,"#d4e1d5"));
        return list;
    }
}
