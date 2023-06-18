package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MyConfig {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_superhero";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    private Connection connect;
    private Statement statement;
    private ResultSet resultSet;

    public MyConfig() {
        connect = null;
        statement = null;
        resultSet = null;
    }

    public void connection() {
        try {
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Database Connected Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (connect != null)
                connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getDatabase() {
        connection();
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT NAMA, POWER, DEFENSE FROM `tb_hero` ORDER BY ID DESC");

            while (resultSet.next()) {
                System.out.println(
                    resultSet.getString("NAMA")+ ": Rp."+
                    resultSet.getInt("POWER")+ " (" +
                    resultSet.getInt("DEFENSE") + ")"
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void insertData() {
        int idBaru;
        String namaBaru;
        long powerBaru;
        int defenseBaru;

        Scanner input = new Scanner(System.in);

        System.out.print("ID : ");
        idBaru = input.nextInt();
        input.nextLine();

        System.out.print("NAMA : ");
        namaBaru = input.nextLine();

        System.out.print("POWER : ");
        powerBaru = input.nextLong();

        System.out.print("DEFENSE : ");
        defenseBaru = input.nextInt();

        connection();
        try {
            statement = connect.createStatement();
            statement.executeUpdate("INSERT INTO `tb_hero` (`ID`, `NAMA`, `POWER`, `DEFENSE`) VALUES ('"+idBaru+"', '"+namaBaru+"', '"+powerBaru+"', '"+defenseBaru+"') ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        input.close();
    }


    public void editData(int id, String nama, double power, int defense) {
        connection();
        try {
            statement = connect.createStatement();
            String sql = "UPDATE `tb_hero` SET `NAMA` = '" + nama + "', `POWER` = " + power + ", `DEFENSE` = " + defense + " WHERE `tb_hero`.`ID` = " + id;
            statement.executeUpdate(sql);
            System.out.println("Data successfully updated");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void deleteData() {
        int id;
        Scanner sc = new Scanner(System.in);
        System.out.print("masukkan id yang ingin dihapus: ");
        id = sc.nextInt();
        connection();
        try {
            statement = connect.createStatement();
            statement.executeUpdate("DELETE FROM `tb_hero` WHERE `ID` = " + id);
            System.out.println("Data successfully deleted");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        sc.close();
    }

}