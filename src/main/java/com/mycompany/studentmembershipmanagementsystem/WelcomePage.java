/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentmembershipmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Harvey
 */
public class WelcomePage extends JFrame implements ActionListener {
    
   private JLabel hdrWelcomePage, hdrDescription, hdrInstruction, lblStudentNo, lblPassword;
   private JButton btnSignup, btnLogin;
   private JTextField txtStudentNo, txtPassword;
    WelcomePage(){
        
        setName("Welcome Page");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        
        hdrWelcomePage = new JLabel("Welcome To BUB!", SwingConstants.CENTER);
        hdrWelcomePage.setBounds(WIDTH, 50, 800, 40);
        hdrWelcomePage.setFont(new Font("Serif", Font.PLAIN,40));
        add(hdrWelcomePage);
        hdrWelcomePage.setVisible(true);
        
        hdrDescription = new JLabel ("Please log in to continue.", SwingConstants.CENTER);
        hdrDescription.setBounds(WIDTH, 100, 800, 30);
        add(hdrDescription);
        
        hdrInstruction = new JLabel("Don't have an account yet? Go to Sign up", SwingConstants.CENTER);
        hdrInstruction.setBounds(WIDTH, 270, 800, 30);
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
       
        txtPassword = new JTextField();
        txtPassword.setBounds(350, 390, 200, 30);
        add(txtPassword);      
        
        btnSignup = new JButton("Sign up");
        btnSignup.setBounds(390, 445, 90, 30);
        add(btnSignup);
        btnSignup.addActionListener(this);
                
        btnLogin = new JButton("Log in");
        btnLogin.setBounds(290, 445, 90, 30);
        add(btnLogin);
        btnLogin.addActionListener(this);
       
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnSignup){
            dispose();
            MembershipForm MF = new MembershipForm();
            MF.setVisible(true);
        } else if(e.getSource() == btnLogin){
            dispose();
            MembershipViewing mv = new MembershipViewing();
            
       }
    }
    
}
 