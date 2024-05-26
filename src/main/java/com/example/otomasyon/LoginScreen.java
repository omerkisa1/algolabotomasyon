package com.example.otomasyon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginScreen extends JFrame {
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton, registerButton;
    private JToggleButton userTypeToggle;

    public LoginScreen() {
        setTitle("Banka Yönetim Sistemi Giriş");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 20, 10, 20);
        constraints.anchor = GridBagConstraints.CENTER;

        // Kullanıcı adı ve şifre için varsayılan değerler atama
        userField = new JTextField("admin", 15);
        passField = new JPasswordField("admin", 15);
        loginButton = new JButton("Giriş Yap");
        registerButton = new JButton("Kayıt Ol");

        // Kullanıcı tipi için toggle button
        userTypeToggle = new JToggleButton("Müşteri");
        userTypeToggle.addActionListener(e -> {
            userTypeToggle.setText(userTypeToggle.isSelected() ? "Çalışan" : "Müşteri");
        });

        addComponents(constraints);

        loginButton.addActionListener(this::login);
        registerButton.addActionListener(this::register);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addComponents(GridBagConstraints constraints) {
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(new JLabel("T.C. NO:"), constraints);

        constraints.gridy++;
        add(userField, constraints);

        constraints.gridy++;
        add(new JLabel("Şifre:"), constraints);

        constraints.gridy++;
        add(passField, constraints);

        constraints.gridy++;
        add(new JLabel("Kullanıcı Tipi:"), constraints);

        constraints.gridy++;
        add(userTypeToggle, constraints);

        constraints.gridy++;
        add(loginButton, constraints);

        constraints.gridy++;
        add(registerButton, constraints);
    }

    private void login(ActionEvent e) {
        String username = userField.getText();
        String password = new String(passField.getPassword());
        boolean isEmployee = userTypeToggle.isSelected();

        if (validateLogin(username, password, isEmployee)) {
            dispose(); // Login penceresini kapat
            if (isEmployee) {
                new EmployeeMainPage().setVisible(true); // Çalışan için ana sayfa
            } else {
                new CustomerMainPage().setVisible(true); // Müşteri için ana sayfa
            }
        } else {
            JOptionPane.showMessageDialog(this, "Hatalı TC kimlik numarası veya parola, veya yanlış kullanıcı tipi!");
        }
    }


    private void register(ActionEvent e) {
        if (userTypeToggle.isSelected()) {
            JOptionPane.showMessageDialog(this, "Çalışan olarak kayıt oluşturulamaz.");
        } else {
            AddCustomerDialog dialog = new AddCustomerDialog(this);
            dialog.setVisible(true);
        }
    }

    private boolean validateLogin(String username, String password, boolean isEmployee) {
        int expectedType = isEmployee ? 1 : 0;  // Çalışanlar için type 1, müşteriler için type 0
        String sql = "SELECT * FROM kayit_table WHERE tc = ? AND password = ? AND type = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(username));
            pstmt.setString(2, password);
            pstmt.setInt(3, expectedType);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();  // Eğer kayıt bulunursa true, bulunamazsa false döner
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Veritabanı hatası: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "TC Kimlik No sayısal olmalıdır.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
