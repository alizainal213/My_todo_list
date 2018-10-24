package com.example.alizainal213.my_todo_list;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MENUFragment extends Fragment {

    private RecyclerView lvmenu;
    private String[] menuApp = {"Todo", "Progress", "Done"};
    private int[]menuGambar = {
            R.drawable.todo,
            R.drawable.progress,
            R.drawable.done
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        lvmenu = (RecyclerView) view.findViewById(R.id.lvmenu);
        //pengaturan tampilan susunan data
        lvmenu.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        //masukkan data ke adapter
        MyMenuAdapter myMenuAdapter = new MyMenuAdapter(getActivity(), menuApp, menuGambar);
        //pasang adapter dengan recycleview
        lvmenu.setAdapter(myMenuAdapter);
        return view;
    }

}
