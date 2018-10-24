package com.example.alizainal213.my_todo_list;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

class MyMenuAdapter extends RecyclerView.Adapter<MyMenuViewHolder> {
    String[] menu;
    int[]gambar;
    Activity activity;
    public MyMenuAdapter(FragmentActivity activity, String[] menuApp, int[] menuGambar) {
        //memasukkan data dari parameter ke variable di dalam class
        menu = menuApp;
        gambar = menuGambar;
       this.activity = activity;
    }

    @NonNull
    @Override
    public MyMenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //memasang layout dan menghubungkan ke viewholder
        View view = LayoutInflater.from(activity).inflate(R.layout.menu_row, viewGroup, false);
        return new MyMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyMenuViewHolder myMenuViewHolder, int i) {
        //memasang data ke layout view holder
        myMenuViewHolder.txtmenuitem.setText(menu[i]);
        myMenuViewHolder.imgmenuitem.setImageResource(gambar[i]);
    }

    @Override
    public int getItemCount() {
        //menentukan total data yang tampil
        return menu.length;
    }
}
