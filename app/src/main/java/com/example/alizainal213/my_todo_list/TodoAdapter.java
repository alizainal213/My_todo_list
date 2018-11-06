package com.example.alizainal213.my_todo_list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alizainal213.my_todo_list.model.Todo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

class TodoAdapter  extends RecyclerView.Adapter<TodoAdapter.MyTodoViewHolder>{

    private Context context;
    private List<Todo> todos;

    public TodoAdapter(FragmentActivity activity, List<Todo> todolist) {
        context = activity;
        todos = todolist;
    }

    @NonNull
    @Override
    public MyTodoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.todo_row, viewGroup,
                false);
        return new MyTodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTodoViewHolder myTodoViewHolder, int i) {
        Todo todo = todos.get(i);

        myTodoViewHolder.txtNamaTodo.setText(todo.getNama());
        myTodoViewHolder.waktuTodo.setText(formatTanggal(Todo.getWaktu()));
    }

    private String formatTanggal(String waktu) {
        try {
            //membuat format default tanggal
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //mengubah waktu tipe date dengan format yang disisipkan tadi
            Date date = simpleDateFormat.parse(waktu);
            //buat format baru
            SimpleDateFormat formatAkhir = new SimpleDateFormat("MM d");
            //terapkan format baru ke tanggal yang sudah dibuat
            return formatAkhir.format(date);
        }catch (ParseException e) {

        }

        return "";
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    public class MyTodoViewHolder extends RecyclerView.ViewHolder {

        TextView txtNamaTodo, waktuTodo;

        public MyTodoViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNamaTodo = itemView.findViewById(R.id.txtNamaTodo);
            waktuTodo = itemView.findViewById(R.id.waktuTodo);
        }
    }
}
