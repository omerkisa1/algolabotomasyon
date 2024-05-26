package com.example.otomasyon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeMainPage extends JFrame {
    public EmployeeMainPage() {
        setTitle("Çalışan Ana Ekranı");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JMenu customerMenu = new JMenu("Müşteri Yönetimi");
        JMenuItem addItem = new JMenuItem("Müşteri Ekle");
        JMenuItem updateItem = new JMenuItem("Müşteri Güncelle");
        customerMenu.add(addItem);
        customerMenu.add(updateItem);

        JMenu loanMenu = new JMenu("Kredi İşlemleri");
        JMenuItem loanApplicationItem = new JMenuItem("Kredi Başvuruları");
        loanMenu.add(loanApplicationItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(customerMenu);
        menuBar.add(loanMenu);
        setJMenuBar(menuBar);

        addItem.addActionListener(this::onAddCustomer);
        updateItem.addActionListener(this::onUpdateCustomer);
        loanApplicationItem.addActionListener(this::onLoanApplications);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void onAddCustomer(ActionEvent e) {
        // Her çağrıldığında yeni bir AddCustomerDialog açılır ve bu diyalog kendi bağlantısını yönetir
        AddCustomerDialog addCustomerDialog = new AddCustomerDialog(this);
        addCustomerDialog.setVisible(true);
    }

    private void onUpdateCustomer(ActionEvent e) {
        UpdateCustomerDialog updateCustomerDialog = new UpdateCustomerDialog(this);
        updateCustomerDialog.setVisible(true);
    }

    private void onLoanApplications(ActionEvent e) {
        LoanApplicationsDialog loanApplicationsDialog = new LoanApplicationsDialog(this);
        loanApplicationsDialog.setVisible(true);
    }
}

