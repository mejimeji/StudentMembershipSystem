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
    
    private ImageIcon ibitslg;
    private JLabel hdrWelcomePage, hdrDescription, hdrInstruction, lblStudentNo, lblPassword;
    private JButton btnClear, btnLogin;
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
        setLayout(null); 
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(255, 222, 89));

        ibitslg = new ImageIcon("ibitslg.png");
        setIconImage(ibitslg.getImage());
        
        headerPanel = new JPanel();
        headerPanel.setBackground(new Color(8, 143, 143));
        headerPanel.setBounds(0, 0, 800, 170); 
        headerPanel.setLayout(new BorderLayout());

        
        JPanel welcomePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        welcomePanel.setOpaque(false); 

        
        Image scaledImage = ibitslg.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        JLabel lblImage = new JLabel(new ImageIcon(scaledImage));
        welcomePanel.add(lblImage);

        
        
        
        hdrWelcomePage = new JLabel("Welcome To", SwingConstants.CENTER);
        hdrWelcomePage.setFont(new Font("Serif", Font.BOLD, 50));
        welcomePanel.add(hdrWelcomePage);

        headerPanel.add(welcomePanel, BorderLayout.CENTER);

        hdrInstruction = new JLabel("IBITS ORGANIZATION", SwingConstants.CENTER);
        hdrInstruction.setBounds(900, 100, 600, 50);
        hdrInstruction.setFont(new Font("Serif", Font.BOLD, 50));
        welcomePanel.add(hdrInstruction);
        
        getContentPane().add(headerPanel);

        hdrDescription = new JLabel("Please log in to continue.", SwingConstants.CENTER);
        hdrDescription.setBounds(0, 290, 800, 30);
        add(hdrDescription);

        lblStudentNo = new JLabel("Username:");
        lblStudentNo.setBounds(250, 330, 100, 30);
        add(lblStudentNo);

        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(250, 390, 100, 30);
        add(lblPassword);

        txtStudentNo = new JTextField();
        txtStudentNo.setBounds(340, 330, 200, 30);
        txtStudentNo.setBorder(new LineBorder(tableBorderColor, 2));
        add(txtStudentNo);

        txtPassword = new JPasswordField(); // Use JPasswordField for password input
        txtPassword.setBounds(340, 390, 200, 30);
        txtPassword.setBorder(new LineBorder(tableBorderColor, 2));
        add(txtPassword);

        btnClear = new JButton("Clear");
        btnClear.setBounds(390, 445, 90, 30);
        btnClear.setBackground(new Color(8, 143, 143));
        btnClear.setBorder(new LineBorder(tableBorderColor, 2));
        add(btnClear);
        btnClear.addActionListener(this);

        btnLogin = new JButton("Log in");
        btnLogin.setBounds(290, 445, 90, 30);
        btnLogin.setBackground(new Color(8, 143, 143));
        btnLogin.setBorder(new LineBorder(tableBorderColor, 2));
        add(btnLogin);
        btnLogin.addActionListener(this);

        progressBar = new JProgressBar(SwingConstants.CENTER);
        add(progressBar);
        progressBar.setBounds(320,500,150,30);
        progressBar.setVisible(false);
        progressBar.setStringPainted(true);

        chkShowPassword = new JCheckBox("Show Password");
        chkShowPassword.setBounds(550, 390, 150, 30);
        chkShowPassword.setBackground(new Color(255, 222, 89));
        chkShowPassword.addActionListener(this);
        add(chkShowPassword);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnClear) {
            txtStudentNo.setText("");
            txtPassword.setText("");
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WelcomePage().setVisible(true));
    }
}