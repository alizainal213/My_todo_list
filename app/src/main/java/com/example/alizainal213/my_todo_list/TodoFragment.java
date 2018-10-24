package com.example.alizainal213.my_todo_list;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alizainal213.my_todo_list.model.Todo;


/**
 * A simple {@link Fragment} subclass.
 */
public class TodoFragment extends Fragment {


    public TodoFragment() {
        // Required empty public constructor
    }

    String nama;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Toodo toodo = new Toodo(1, "makan malam", "makan malam bersama teman", "besok", "todo");
        //tampilkan nama
        //Log.d("NAMA", toodo.getNama());
        // ubah nama
        //toodo.setNama("bermain bola");
        //tampilkan namannya
        //Log.d("NAMA", toodo.getNama());
        return inflater.inflate(R.layout.fragment_todo, container, false);
    }

}
