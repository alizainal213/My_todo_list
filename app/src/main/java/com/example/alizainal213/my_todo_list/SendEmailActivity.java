package com.example.alizainal213.my_todo_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SendEmailActivity extends AppCompatActivity {

    @BindView(R.id.PesanEmail)
    EditText PesanEmail;
    @BindView(R.id.btnSendEmail)
    Button btnSendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSendEmail)
    public void onViewClicked() {
        // subject dan email tujuan tidak boleh kosong

            // kirim email menggunakan intent untuk membuka aplikasi email
            Intent intent = new Intent(Intent.ACTION_SEND);
            // buat intent meembawa data pada aplikasi
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"setyaaji07@gmail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback My TodoList App");
            intent.putExtra(Intent.EXTRA_TEXT,PesanEmail.getText().toString());
            // mengubah tipe dari email
            intent.setType("message/rfc822");
            // mulai mengirim email ke aplikasi gmail
            startActivity(Intent.createChooser(intent, "Pilih Aplikasi"));


        }
    }


