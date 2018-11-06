package com.example.alizainal213.my_todo_list;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alizainal213.my_todo_list.Database.MyDatabaseHelper;
import com.example.alizainal213.my_todo_list.model.Todo;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tampilDialogTodo();
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        myDatabaseHelper = new MyDatabaseHelper(this);
    }

    private void tampilDialogTodo() {
        //tampilkan layout ke dalam view
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View view = layoutInflater.inflate(R.layout.dialog_todo, null);
        //pasang view ke dalam alertdialog
        AlertDialog.Builder alertDialogInput = new AlertDialog.Builder(this);
        alertDialogInput.setView(view);
        //inisialisasi komponen dalam dialog
        final EditText edInnama = view.findViewById(R.id.edInNama);
        final EditText edInDesk = view.findViewById(R.id.edInDesk);
        TextView txtInTitle = view.findViewById(R.id.txtInTitle);
        //mengatur judul dialog
        txtInTitle.setText("New Todo");
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
        final AlertDialog alertDialog = alertDialogInput.create();
        alertDialog.show();

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cek apakah kode kosong
                if (TextUtils.isEmpty(edInnama.getText().toString())){
                    edInnama.setError("Nama tidak boleh kosong");
                    edInnama.requestFocus();
                }else if (TextUtils.isEmpty(edInDesk.getText().toString())) {
                    edInDesk.setError("Deksripsi tidak boleh kosong");
                    edInDesk.requestFocus();
                } else {
                    alertDialog.dismiss();
                    myDatabaseHelper.simpandata(edInnama.getText().toString(),
                            edInDesk.getText().toString(), "todo");
                }

                //simpan data ke database
                myDatabaseHelper.simpandata(edInnama.getText().toString(),edInDesk.getText().toString(), "todo");
            }
        });
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Fragment fragment = null;

        int id = item.getItemId();

        if (id == R.id.nav_home) {
            MENUFragment menuFragment = new MENUFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.screen_area, menuFragment).commit();

        } else if (id == R.id.nav_Todo) {
            TodoFragment todoFragment = new TodoFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.screen_area, todoFragment).commit();
        } else if (id == R.id.nav_Done) {
            DoneFragment doneFragment = new DoneFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.screen_area, doneFragment).commit();
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_Feedback) {
           startActivity(new Intent(MainActivity.this, SendEmailActivity.class));

        }

        if (fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
