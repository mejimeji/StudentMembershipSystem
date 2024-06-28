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
public class MembershipForm extends JFrame implements ActionListener {
    
   private JLabel hdrMembership, lblFirstName, lblLastName, lblMiddleName, lblStudentNo, lblCourseYear, lblEmail, lblPassword;
   private JButton btnSignUp;
   private JTextField txtFirstName, txtLastName,txtMiddleName, txtStudentNo, txtCourseYear, txtEmail, txtPassword;
    
    MembershipForm(){
        
        setName("Membership Form");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        
        
        hdrMembership = new JLabel("Membership Form", SwingConstants.CENTER);
        hdrMembership.setBounds(WIDTH, 40, 800, 50);
        hdrMembership.setFont(new Font("Serif",Font.PLAIN, 40));
        add(hdrMembership);
        
        lblFirstName = new JLabel ("First Name:");
        lblFirstName.setBounds(150, 150, 100, 15);
        add(lblFirstName);
        lblFirstName.setVisible(true);
        
        txtFirstName = new JTextField();
        txtFirstName.setBounds(110, 170, 150, 30);
        add(txtFirstName);
        txtFirstName.setVisible(true);
        
        lblLastName = new JLabel("Last Name:");
        lblLastName.setBounds(350, 150, 100, 15);
        add(lblLastName);
        lblLastName.setVisible(true);
        
        txtLastName = new JTextField();
        txtLastName.setBounds(310, 170, 150, 30);
        add(txtLastName);
        txtLastName.setVisible(true);
        
        lblMiddleName = new JLabel("Middle Name:");
        lblMiddleName.setBounds(550, 150, 100, 15);
        add(lblMiddleName);
        lblLastName.setVisible(true);
        
        txtMiddleName = new JTextField();
        txtMiddleName.setBounds(510, 170, 150, 30);
        add(txtMiddleName);
        txtMiddleName.setVisible(true);
        
        lblStudentNo = new JLabel("Student No:");
        lblStudentNo.setBounds(250, 250, 100, 15);
        add(lblStudentNo);
        lblStudentNo.setVisible(true);
        
        txtStudentNo = new JTextField();
        txtStudentNo.setBounds(210, 270, 150, 30);
        add(txtStudentNo);
        txtStudentNo.setVisible(true);
                
        lblCourseYear = new JLabel("Course&Year:");
        lblCourseYear.setBounds(450, 250, 100, 15);
        add(lblCourseYear);
        lblCourseYear.setVisible(true);
        
        txtCourseYear = new JTextField();
        txtCourseYear.setBounds(410, 270, 150, 30);
        add(txtCourseYear);
        txtCourseYear.setVisible(true);
        
        lblEmail = new JLabel("E-mail:");
        lblEmail.setBounds(250, 350, 100, 15);
        add(lblEmail);
        lblEmail.setVisible(true);
        
        txtEmail = new JTextField();
        txtEmail.setBounds(210, 370, 150, 30);
        add(txtEmail);
        txtEmail.setVisible(true);
        
        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(450, 350, 100, 15);
        add(lblPassword);
        lblPassword.setVisible(true);
        
        txtPassword = new JTextField();
        txtPassword.setBounds(410, 370, 150, 30);
        add(txtPassword);
        txtPassword.setVisible(true);
        
        btnSignUp = new JButton("Sign up");
        btnSignUp.setBounds(335, 450, 100, 30);
        add(btnSignUp);
        btnSignUp.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
 