package com.example.otomasyon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Arrays;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddCustomerDialog extends JDialog {
    private JTextField tfTC, tfName, tfSurname;
    private JPasswordField tfPassword;
    private JButton btnRegister, btnCancel;

    public AddCustomerDialog(Frame parent) {
        super(parent, "Müşteri Kayıt", true);
        setSize(300, 200);
        setLayout(new GridLayout(5, 2));
        addComponents();
        setupListeners();
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    private void addComponents() {
        add(new JLabel("TC Kimlik No:"));
        tfTC = new JTextField(20);
        add(tfTC);

        add(new JLabel("Ad:"));
        tfName = new JTextField(20);
        add(tfName);

        add(new JLabel("Soyad:"));
        tfSurname = new JTextField(20);
        add(tfSurname);

        add(new JLabel("Şifre:"));
        tfPassword = new JPasswordField(20);
        add(tfPassword);

        btnRegister = new JButton("Kayıt Ol");
        btnCancel = new JButton("İptal");
        add(btnRegister);
        add(btnCancel);
    }

    private void setupListeners() {
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tc = tfTC.getText();
                String name = tfName.getText();
                String surname = tfSurname.getText();
                char[] passwordArray = tfPassword.getPassword();
                String password = new String(passwordArray);
                registerCustomer(tc, name, surname, password);
                Arrays.fill(passwordArray, '0');
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void registerCustomer(String tc, String name, String surname, String password) {
        String sql = "INSERT INTO kayit_table (tc, name, surname, password, type) VALUES (?, ?, ?, ?, 0)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(tc));
            pstmt.setString(2, name);
            pstmt.setString(3, surname);
            pstmt.setString(4, password);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(this, "Müşteri kaydı başarıyla tamamlandı!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Müşteri kaydedilemedi.", "Kayıt Hatası", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Veritabanı hatası: " + ex.getMessage(), "Kayıt Hatası", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "TC kimlik numarası sayısal bir değer olmalıdır.", "Giriş Hatası", JOptionPane.WARNING_MESSAGE);
        }
    }
}
