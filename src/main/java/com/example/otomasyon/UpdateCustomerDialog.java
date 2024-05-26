package com.example.otomasyon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UpdateCustomerDialog extends JDialog {
    private JTextField nameField, addressField, emailField;
    private JButton updateButton;

    public UpdateCustomerDialog(Frame owner) {
        super(owner, "Müşteri Güncelle", true);
        setSize(300, 200);
        setLayout(new GridLayout(0, 1));  // Satırları dinamik olarak eklemek için GridLayout kullanıyoruz.

        // Form alanlarını oluştur
        nameField = new JTextField(20);
        addressField = new JTextField(20);
        emailField = new JTextField(20);
        updateButton = new JButton("Güncelle");

        // Örnek veri varsayılan olarak yüklenebilir
        nameField.setText("Örnek Ad");
        addressField.setText("Örnek Adres");
        emailField.setText("örnek@email.com");

        add(new JLabel("Ad Soyad:"));
        add(nameField);
        add(new JLabel("Adres:"));
        add(addressField);
        add(new JLabel("E-mail:"));
        add(emailField);
        add(updateButton);

        updateButton.addActionListener(this::updateCustomer);

        setLocationRelativeTo(owner);
        setVisible(true);
    }

    private void updateCustomer(ActionEvent e) {
        String name = nameField.getText();
        String address = addressField.getText();
        String email = emailField.getText();

        // Burada müşteri güncelleme işlemlerini gerçekleştirebilirsiniz.
        // Şu an için basit bir onay mesajı gösteriyoruz.
        JOptionPane.showMessageDialog(this, "Müşteri güncellendi:\n" + name);
    }
}
