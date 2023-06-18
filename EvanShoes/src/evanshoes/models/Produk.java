/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evanshoes.models;

/**
 *
 * @author Orii
 */
public class Produk {
    private int id;
    private String nama;
    private long harga;
    private int stock;

    public Produk(String nama, long harga, int stock) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stock = stock;
    }

    public Produk(String produkNama, int produkHarga, int produkStock) {
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public long getHarga() {
        return harga;
    }

    public int getStock() {
        return stock;
    }
}
