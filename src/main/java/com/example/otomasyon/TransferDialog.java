package com.example.otomasyon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TransferDialog extends JDialog {
    private JTextField toAccountField, amountField;
    private JButton transferButton;

    public TransferDialog(Frame owner) {
        super(owner, "Para Transferi", true);
        setSize(300, 200);
        setLayout(new GridLayout(0, 2));

        toAccountField = new JTextField();
        amountField = new JTextField();
        transferButton = new JButton("Transfer Yap");

        add(new JLabel("Alıcı Hesap No:"));
        add(toAccountField);
        add(new JLabel("Tutar:"));
        add(amountField);
        add(new JLabel()); // Grid layout spacer
        add(transferButton);

        transferButton.addActionListener(this::performTransfer);

        setLocationRelativeTo(owner);
        setVisible(true);
    }

    private void performTransfer(ActionEvent e) {
        // Transfer işlemi burada gerçekleştirilir.
        JOptionPane.showMessageDialog(this, "Transfer başarıyla gerçekleştirildi.");
    }
}
