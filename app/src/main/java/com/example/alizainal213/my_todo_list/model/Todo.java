package com.example.alizainal213.my_todo_list.model;

public class Todo {
    public static final String NAMA_TABEL = "tb_todo";
    //varieble constan digunakan untuk pernamaan field aja
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAMA = "nama";
    public static final String COLUMN_DESKRIPSI = "deskripsi";
    public static final String COLUMN_WAKTU = "waktu";
    public static final String COLUMN_CATEGORY = "category";

    //varieble biasa untuk menampung data yang berubah ubah
    private int id;
    private String nama;
    private  String deskripsi;
    private String waktu;
    private String category;

    //membuat TABLE SQlite
    public static final String BUAT_TABEL = "CREATE TABLE" + NAMA_TABEL + "("
            + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_NAMA + "Text,"
            + COLUMN_DESKRIPSI + "Text,"
            + COLUMN_WAKTU + "DATETIME DEFAULT CURRENT_TIMESTAMP,"
            + COLUMN_CATEGORY + "Text," + "(";

    // constructor untuk memasukkan data ke dalam class model ini
    public Todo(int id, String nama, String deskripsi, String waktu, String category) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.waktu = waktu;
        this.category = category;
    }

    public Todo(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public static String getWaktu() {
        return getWaktu();
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
