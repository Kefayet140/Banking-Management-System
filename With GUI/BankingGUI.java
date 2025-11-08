package com.mycompany.banking_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankingGUI extends JFrame {

    private UserInformation user;
    private BankAccount account;
    private JTextArea transactionArea;

    public BankingGUI() {

        setTitle("User Login");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5));

        JLabel idLabel = new JLabel("User ID:");
        JLabel nameLabel = new JLabel("User Name:");
        JLabel passLabel = new JLabel("Password:");

        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JPasswordField passField = new JPasswordField();

        JButton loginBtn = new JButton("Start Banking");

        add(idLabel);
        add(idField);
        add(nameLabel);
        add(nameField);
        add(passLabel);
        add(passField);
        add(new JLabel(""));
        add(loginBtn);

        loginBtn.addActionListener(e -> {
            String userId = idField.getText();
            String userName = nameField.getText();
            String password = new String(passField.getPassword());

            if(userId.isEmpty() || userName.isEmpty() || password.isEmpty()){
                JOptionPane.showMessageDialog(null, "All fields must be filled!");
                return;
            }

            user = new UserInformation(userId, userName, password);
            account = new BankAccount("AC1001", 1000.0);

            openMainWindow();
        });
    }
private void openMainWindow() {

    JFrame main = new JFrame("Banking System - " + user.getUserName());
    main.setSize(600, 450);
    main.setLocationRelativeTo(null);
    main.setDefaultCloseOperation(EXIT_ON_CLOSE);
    main.setLayout(new BorderLayout());

    // Balance Show Label
    JLabel balanceLabel = new JLabel("Current Balance: " + account.getBalance());
    balanceLabel.setFont(new Font("Arial", Font.BOLD, 18));
    balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
    main.add(balanceLabel, BorderLayout.NORTH);

    JPanel buttons = new JPanel(new GridLayout(5,1,10,10));

    JButton depositBtn = new JButton("Deposit Money");
    JButton withdrawBtn = new JButton("Withdraw Money");
    JButton balanceBtn = new JButton("Refresh Balance");
    JButton transBtn = new JButton("View Transactions");
    JButton userBtn = new JButton("User Info");

    buttons.add(depositBtn);
    buttons.add(withdrawBtn);
    buttons.add(balanceBtn);
    buttons.add(transBtn);
    buttons.add(userBtn);

    main.add(buttons, BorderLayout.WEST);

    transactionArea = new JTextArea();
    transactionArea.setEditable(false);
    main.add(new JScrollPane(transactionArea), BorderLayout.CENTER);

    depositBtn.addActionListener(e -> {
        String amt = JOptionPane.showInputDialog("Enter amount to deposit:");
        if(amt != null){
            account.deposit(Double.parseDouble(amt));
            balanceLabel.setText("Current Balance: " + account.getBalance());
        }
    });

    withdrawBtn.addActionListener(e -> {
        String amt = JOptionPane.showInputDialog("Enter amount to withdraw:");
        if(amt != null){
            account.withdraw(Double.parseDouble(amt));
            balanceLabel.setText("Current Balance: " + account.getBalance());
        }
    });

    balanceBtn.addActionListener(e -> balanceLabel.setText("Current Balance: " + account.getBalance()));

    transBtn.addActionListener(e -> {
        transactionArea.setText("");
        transactionArea.append("=== Transaction History ===\n\n");
        for(Transaction t : account.getTransactions()){
           transactionArea.append(t.getType() + " - Amount: " + t.getAmount() + "\n");
        }
    });

    userBtn.addActionListener(e -> JOptionPane.showMessageDialog(main,
            "User ID: " + user.getUserId() + "\nUser Name: " + user.getUserName()));

    this.dispose();
    main.setVisible(true);
}


    public static void main(String[] args) {
        new BankingGUI().setVisible(true);
    }
}
