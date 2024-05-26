package com.example.otomasyon;

import javax.swing.*;

public class mainApp extends JFrame {

    public mainApp() {
        // Pencere başlığı
        setTitle("Banka Yönetim Sistemi Ana Ekran");

        // Pencere boyutu ve konumunu ayarlama
        setBounds(100, 100, 800, 600);  // Daha büyük bir boyut ve başlangıç konumu

        // Uygulamanın kapatılma operasyonu
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Ekranın ortasında aç
        setLocationRelativeTo(null);

        // Pencereyi görünür yap
        setVisible(true);
    }

    public static void main(String[] args) {
        // Uygulama başladığında LoginScreen'i aç
        new LoginScreen();
    }
}
