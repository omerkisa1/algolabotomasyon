package com.example.otomasyon;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoanApplicationsDialog extends JDialog {
    private JTable loanTable;
    private JButton approveButton, rejectButton;

    public LoanApplicationsDialog(Frame owner) {
        super(owner, "Kredi Başvuruları", true);
        setSize(500, 400);
        setLayout(new BorderLayout());

        // Kredi başvuruları tablosu
        String[] columnNames = {"Başvuru ID", "Müşteri Adı", "Kredi Tutarı", "Durum"};
        Object[][] data = {
                {"1", "Ahmet Yılmaz", "5000 TL", "Beklemede"},
                {"2", "Ayşe Kara", "15000 TL", "Beklemede"},
                {"3", "Mehmet Solak", "25000 TL", "Beklemede"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        loanTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(loanTable);
        loanTable.setFillsViewportHeight(true);

        approveButton = new JButton("Onayla");
        rejectButton = new JButton("Reddet");

        // Butonları alt kısımda yerleştirme
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(approveButton);
        buttonPanel.add(rejectButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Buton aksiyonları
        approveButton.addActionListener(this::approveLoan);
        rejectButton.addActionListener(this::rejectLoan);

        setLocationRelativeTo(owner);
        setVisible(true);
    }

    private void approveLoan(ActionEvent e) {
        int selectedRow = loanTable.getSelectedRow();
        if (selectedRow >= 0) {
            ((DefaultTableModel) loanTable.getModel()).setValueAt("Onaylandı", selectedRow, 3);
            JOptionPane.showMessageDialog(this, "Kredi başvurusu onaylandı.");
        } else {
            JOptionPane.showMessageDialog(this, "Lütfen bir başvuru seçiniz.");
        }
    }

    private void rejectLoan(ActionEvent e) {
        int selectedRow = loanTable.getSelectedRow();
        if (selectedRow >= 0) {
            ((DefaultTableModel) loanTable.getModel()).setValueAt("Reddedildi", selectedRow, 3);
            JOptionPane.showMessageDialog(this, "Kredi başvurusu reddedildi.");
        } else {
            JOptionPane.showMessageDialog(this, "Lütfen bir başvuru seçiniz.");
        }
    }
}
