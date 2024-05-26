package com.example.otomasyon;

import javax.swing.*;
import java.awt.*;

public class CustomerMainPage extends JFrame {
    public CustomerMainPage() {
        setTitle("Müşteri Ana Ekranı");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Hesap işlemleri menüsü
        JMenu customerMenu = new JMenu("Hesap İşlemleri");
        JMenuItem accountInfoItem = new JMenuItem("Hesap Bilgilerim");
        JMenuItem transferItem = new JMenuItem("Para Transferi");

        customerMenu.add(accountInfoItem);
        customerMenu.add(transferItem);

        // Menü çubuğuna hesap işlemleri menüsü ekleniyor
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(customerMenu);
        setJMenuBar(menuBar);

        // Hesap Bilgilerim ve Para Transferi için olay dinleyicileri ekleme
        accountInfoItem.addActionListener(e -> showAccountInfo());
        transferItem.addActionListener(e -> showTransferDialog());

        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Hesap bilgilerini gösteren diyalogu aç
    private void showAccountInfo() {
        // Burada AccountInfoDialog penceresi açılacak
        new AccountInfoDialog(this);
    }

    // Para transferi diyalogunu aç
    private void showTransferDialog() {
        // Burada TransferDialog penceresi açılacak
        new TransferDialog(this);
    }
}

// AccountInfoDialog ve TransferDialog sınıflarınızın tanımları burada olacak.
