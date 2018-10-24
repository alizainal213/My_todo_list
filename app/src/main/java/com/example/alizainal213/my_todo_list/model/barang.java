package com.example.alizainal213.my_todo_list.model;

public class barang {
    public static final String NAMA_TABLE = "tb_barang";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_BARANG = "barang";
    public static final String COLUMN_HARGA = "harga";
    public static final String COLUMN_KATEGORI = "categori";
    public static final String COLUMN_STOK = "stok";
    public static final String COLUMN_TOTALHARGA = "totalharga";
    public static final String COLUMN_UNTUNG = "untung";
    public static final String COLUMN_RUGI = "rugi";




    private int id;
    private String barang;
    private String harga;
    private String categori;
    private String stok;
    private String totalharga;
    private String untung;
    private String rugi;

    public static final String BUAT_TABLE = "CREATE TABLE" + NAMA_TABLE + "(" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_BARANG + "Text,"
            + COLUMN_HARGA + "text,"
            + COLUMN_KATEGORI + "text,"
            + COLUMN_STOK + "text,"
            + COLUMN_TOTALHARGA + "text,"
            + COLUMN_UNTUNG + "text,"
            + COLUMN_RUGI + "text," + "(";

    public barang(int id, String barang, String harga, String categori, String stok, String totalharga, String untung, String rugi) {
        this.id = id;
        this.barang = barang;
        this.harga = harga;
        this.categori = categori;
        this.stok = stok;
        this.totalharga = totalharga;
        this.untung = untung;
        this.rugi = rugi;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarang() {
        return barang;
    }

    public void setBarang(String barang) {
        this.barang = barang;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getCategori() {
        return categori;
    }

    public void setCategori(String categori) {
        this.categori = categori;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public String getTotalharga() {
        return totalharga;
    }

    public void setTotalharga(String totalharga) {
        this.totalharga = totalharga;
    }

    public String getUntung() {
        return untung;
    }

    public void setUntung(String untung) {
        this.untung = untung;
    }

    public String getRugi() {
        return rugi;
    }

    public void setRugi(String rugi) {
        this.rugi = rugi;
    }
}
