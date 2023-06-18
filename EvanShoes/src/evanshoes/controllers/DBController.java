/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evanshoes.controllers;

/**
 *
 * @author Orii
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import evanshoes.models.Produk;

public class DBController {
    private Connection connection;

    public DBController() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tb_produk", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertProduct(Produk product) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO tb_tabel (nama, harga, stock) VALUES (?, ?, ?)");
            statement.setString(1, product.getNama());
            statement.setLong(2, product.getHarga());
            statement.setInt(3, product.getStock());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM tb_tabel WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Produk> getProdukList() {
        List<Produk> produkList = new ArrayList<>();

        try {
            String query = "SELECT * FROM tb_tabel";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String nama = resultSet.getString("nama");
                int harga = resultSet.getInt("harga");
                int stock = resultSet.getInt("stock");

                Produk produk = new Produk(nama, harga, stock);
                produkList.add(produk);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produkList;
    }

    public ResultSet getAllProducts() {
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM tb_tabel");
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}

