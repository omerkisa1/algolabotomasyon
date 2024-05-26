package com.example.otomasyon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AccountInfoDialog extends JDialog {
    public AccountInfoDialog(Frame owner) {
        super(owner, "Hesap Bilgilerim", true);
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        // Örnek hesap bilgileri
        add(new JLabel("Hesap Numarası:"));
        add(new JLabel("123456789"));
        add(new JLabel("Bakiye:"));
        add(new JLabel("10,000 TL"));
        add(new JLabel("Hesap Türü:"));
        add(new JLabel("Tasarruf"));
        add(new JLabel("Şube:"));
        add(new JLabel("Ankara Merkez"));

        setLocationRelativeTo(owner);
        setVisible(true);
    }
}
