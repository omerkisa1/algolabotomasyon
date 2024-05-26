package com.example.otomasyon;

import java.sql.*;

public class TestDatabaseConnection {
    public static void main(String[] args) {
        Connection con = DatabaseConnection.getConnection();
        if (con != null) {
            try {
                // Basit bir SELECT sorgusu çalıştırarak bağlantıyı test edelim.
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT 1"); // MySQL için bu sorgu yeterlidir.
                if (rs.next()) {
                    System.out.println("Veritabanı bağlantısı başarılı ve sorgu başarılı!");
                } else {
                    System.out.println("Sorgu başarısız, ancak bağlantı kuruldu.");
                }
            } catch (SQLException e) {
                System.out.println("SQL Hatası:");
                e.printStackTrace();
            }
        } else {
            System.out.println("Veritabanı bağlantısı başarısız!");
        }
    }
}
