package com.example.alizainal213.my_todo_list;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//memasukkan komponen layout ke adapter
class MyMenuViewHolder extends RecyclerView.ViewHolder {
    TextView txtmenuitem;
    ImageView imgmenuitem;
    public MyMenuViewHolder(@NonNull View itemView) {
        super(itemView);
        txtmenuitem = (TextView) itemView.findViewById(R.id.txtmenuitem);
        imgmenuitem = (ImageView) itemView.findViewById(R.id.imageView);
    }
}
