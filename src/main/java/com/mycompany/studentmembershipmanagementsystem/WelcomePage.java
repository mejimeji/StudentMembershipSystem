/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentmembershipmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

public class WelcomePage extends JFrame implements ActionListener {

    private JLabel hdrWelcomePage, hdrDescription, hdrInstruction, lblStudentNo, lblPassword;
    private JButton btnSignup, btnLogin;
    private JTextField txtStudentNo;
    private JPasswordField txtPassword;
    private JPanel headerPanel;
    private JProgressBar progressBar;
    private JCheckBox chkShowPassword;
    Color tableBorderColor;

    WelcomePage() {
        setName("Welcome Page");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Using null layout for absolute positioning, consider using layout managers for better scalability
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(255, 222, 89));

        // Create and configure header panel
        headerPanel = new JPanel();
        headerPanel.setBackground(new Color(8, 143, 143));
        headerPanel.setBounds(0, 0, 800, 100); // Position at the top covering full width
        headerPanel.setLayout(new BorderLayout());

        hdrWelcomePage = new JLabel("Welcome To BUB!", SwingConstants.CENTER);
        hdrWelcomePage.setFont(new Font("Serif", Font.PLAIN, 40));
        headerPanel.add(hdrWelcomePage, BorderLayout.CENTER);

        // Add header panel to content pane
        getContentPane().add(headerPanel);

        hdrDescription = new JLabel("Please log in to continue.", SwingConstants.CENTER);
        hdrDescription.setBounds(0, 100, 800, 30);
        add(hdrDescription);

        hdrInstruction = new JLabel("Don't have an account yet? Go to Sign up", SwingConstants.CENTER);
        hdrInstruction.setBounds(0, 270, 800, 30);
        add(hdrInstruction);

        lblStudentNo = new JLabel("Student No:");
        lblStudentNo.setBounds(250, 330, 100, 30);
        add(lblStudentNo);

        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(250, 390, 100, 30);
        add(lblPassword);

        txtStudentNo = new JTextField();
        txtStudentNo.setBounds(350, 330, 200, 30);
        add(txtStudentNo);

        txtPassword = new JPasswordField(); // Use JPasswordField for password input
        txtPassword.setBounds(350, 390, 200, 30);
        add(txtPassword);

        btnSignup = new JButton("Sign up");
        btnSignup.setBounds(390, 445, 90, 30);
        btnSignup.setBackground(new Color(8, 143, 143));
        btnSignup.setBorder(new LineBorder(tableBorderColor, 2));
        add(btnSignup);
        btnSignup.addActionListener(this);

        btnLogin = new JButton("Log in");
        btnLogin.setBounds(290, 445, 90, 30);
        btnLogin.setBackground(new Color(8, 143, 143));
        btnLogin.setBorder(new LineBorder(tableBorderColor, 2));
        add(btnLogin);
        btnLogin.addActionListener(this);

        // Progress Bar
        progressBar = new JProgressBar(SwingConstants.CENTER);
        add(progressBar);
        progressBar.setBounds(320,500,150,30);
        progressBar.setVisible(false);
        progressBar.setStringPainted(true);

        // Show Password Checkbox
        chkShowPassword = new JCheckBox("Show Password");
        chkShowPassword.setBounds(560, 390, 150, 30);
        chkShowPassword.setBackground(new Color(255, 222, 89));
        
        chkShowPassword.addActionListener(this);
        add(chkShowPassword);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSignup) {
            dispose();
            MembershipForm MF = new MembershipForm();
            MF.setVisible(true);
        } else if (e.getSource() == btnLogin) {
            String username = txtStudentNo.getText().trim();
            String password = String.valueOf(txtPassword.getPassword()).trim();

            if(username.equals("USER") && password.equals("PASSWORD")) {
                JOptionPane.showMessageDialog(null, "Login Successful!", "", JOptionPane.INFORMATION_MESSAGE);
                progressBar.setVisible(true);

                SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        for (int i = 0; i <= 100; i++) {
                            Thread.sleep(10);
                            publish(i);
                        }
                        return null;
                    }

                    @Override
                    protected void process(java.util.List<Integer> chunks) {
                        progressBar.setValue(chunks.get(chunks.size() - 1));
                    }

                    @Override
                    protected void done() {
                        progressBar.setVisible(false);
                        dispose();
                        new MembershipViewing().setVisible(true);
                    }
                };
                worker.execute();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == chkShowPassword) {
            
            if (chkShowPassword.isSelected()) {
                txtPassword.setEchoChar((char) 0); 
            } else {
                txtPassword.setEchoChar('*'); 
            }
        }
    }
}
 