package com.example.alizainal213.my_todo_list;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.alizainal213.my_todo_list.Database.MyDatabaseHelper;
import com.example.alizainal213.my_todo_list.model.Todo;
import com.example.alizainal213.my_todo_list.utils.ClickListener;
import com.example.alizainal213.my_todo_list.utils.RecyclerClickListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TodoFragment extends Fragment {

    private RecyclerView lvTodo;
    private List<Todo> todoList = new ArrayList<>();
    private LinearLayout todokosong;
    private TodoAdapter todoAdapter;

    private MyDatabaseHelper myDatabaseHelper;


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
        View view = inflater.inflate(R.layout.fragment_todo, container, false);

        lvTodo = view.findViewById(R.id.lvtodo);
        todokosong = view.findViewById(R.id.todokosong);

        myDatabaseHelper = new MyDatabaseHelper(getActivity());

        //melatakkan semua data ke dalam  list
        todoList.addAll(myDatabaseHelper.ambilSemuaData());

        todoAdapter = new TodoAdapter (getActivity(), todoList);

        lvTodo.setLayoutManager(new LinearLayoutManager(getActivity()));
        lvTodo.setAdapter(todoAdapter);

        lvTodo.addOnItemTouchListener(new RecyclerClickListener(getActivity(), lvTodo, new ClickListener() {
            @Override
            public void OnClick(View view, int posisi) {

            }

            @Override
            public void onLongClick(View view, int posisi) {
            tampilDialogAksi(posisi);
            }
        }));
        aturTodoKosong();


        return view;
    }



    private void tampilDialogAksi(final int posisi) {
        CharSequence teksTombol[] = new CharSequence[] {"Edit", "Delete"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Pilihan");
        builder.setItems(teksTombol, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    tampilEditDialog(todoList.get(posisi), posisi);
                }else {
                    hapusTodo (posisi);
                }
            }
        });
        builder.show();

    }

    private void hapusTodo(int posisi) {
        //hapus data
        myDatabaseHelper.hapusData(todoList.get(posisi));
        //hapus data dari model
        todoList.remove(posisi);
        //hapus data dari adapter
        todoAdapter.notifyItemRemoved(posisi);
        //tampilkan pesan data kosong ketika menghapus data terakhir
        aturTodoKosong();

    }

    private  void tampilEditDialog(final Todo todo, final int posisi) {
        //tampilkan layout ke dalam view
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View view = layoutInflater.inflate(R.layout.dialog_edit, null);
        //pasang view ke dalam alertdialog
        android.support.v7.app.AlertDialog.Builder alertDialogInput = new android.support.v7.app.AlertDialog.Builder(getActivity());
        alertDialogInput.setView(view);
        //inisialisasi komponen dalam dialog
        final EditText edEnama = view.findViewById(R.id.edENama);
        final EditText edEDesk = view.findViewById(R.id.edEDesk);
        TextView txtEnTitle = view.findViewById(R.id.txtEnTitle);
        Spinner spkategori = view.findViewById(R.id.spedit);
        final String[] kategori = {null};
        spkategori.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                kategori[0] = getResources().getStringArray(R.array.itemkategori)[i];

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //mengatur judul dialog
        txtEnTitle.setText("New Todo");
        //membuat tombol dialog
        alertDialogInput
                .setCancelable(false)
                .setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        //memasang tombol ke alert dialog
        final android.support.v7.app.AlertDialog alertDialog = alertDialogInput.create();
        alertDialog.show();

        alertDialog.getButton(android.support.v7.app.AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cek apakah kode kosong
                if (TextUtils.isEmpty(edEnama.getText().toString())){
                    edEnama.setError("Nama tidak boleh kosong");
                    edEnama.requestFocus();
                }else if (TextUtils.isEmpty(edEDesk.getText().toString())) {
                    edEDesk.setError("Deksripsi tidak boleh kosong");
                    edEDesk.requestFocus();
                } else {
                    //simpan data ke database
                    //simpan ke database dan dapatkan id data yng baru saja disimpan
                    todo.setNama(edEnama.getText().toString());
                    todo.setDeskripsi(edEDesk.getText().toString());
                    todo.setCategory(kategori[0]);
                    // proses database
                    myDatabaseHelper.updateTodo(todo);
                    // mengatur posisi yang diubah
                    todoList.set(posisi, todo);

                    aturTodoKosong();

                    alertDialog.dismiss();



                }

            }
        });
    }


    private void aturTodoKosong() {
        //cek apakah daata kosong
        // jika kosong maka tampilkan pesan kosong
        if (myDatabaseHelper.ambilJumlahData()>0) {
            todokosong.setVisibility(View.GONE);
        }else {
            todokosong.setVisibility(View.VISIBLE);
        }
    }

}
