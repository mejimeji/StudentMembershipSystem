package com.mycompany.studentmembershipmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.border.LineBorder;


public class MembershipForm extends JFrame implements ActionListener {

    private JLabel hdrMembership, lblFirstName, lblLastName, lblMiddleName, lblStudentNo, lblCourse, lblYear, lblAddress, lblcontact, lblbday, lblpos, lblaffil;
    private JButton btnSignUp, btnReturn, btnClear;
    private JTextField txtFirstName, txtLastName, txtMiddleName, txtStudentNo, txtCourse, txtYear, txtAddress, txtcontact, txtbday, txtpos, txtaffil;
    private JPanel headerPanel;
    Color tableBorderColor;
    
    MembershipForm() {

        setTitle("Membership Form");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new java.awt.Color(8, 143, 143));

        
        headerPanel = new JPanel();
        headerPanel.setBackground(new Color(255, 222, 89));
        headerPanel.setBounds(0, 0, 800, 100);
        headerPanel.setLayout(null);

        hdrMembership = new JLabel("Membership Form", SwingConstants.CENTER);
        hdrMembership.setBounds(0, 30, 800, 50);
        hdrMembership.setFont(new Font("Serif", Font.PLAIN, 40));
        headerPanel.add(hdrMembership);  // Add header label to header panel
        add(headerPanel);  // Add header panel to frame

        lblStudentNo = new JLabel("Student No:");
        lblStudentNo.setBounds(70, 150, 100, 15);
        add(lblStudentNo);

        txtStudentNo = new JTextField();
        txtStudentNo.setBounds(30, 170, 150, 30);
        add(txtStudentNo);

        lblFirstName = new JLabel("First Name:");
        lblFirstName.setBounds(260, 150, 100, 15);
        add(lblFirstName);

        txtFirstName = new JTextField();
        txtFirstName.setBounds(220, 170, 150, 30);
        add(txtFirstName);

        lblLastName = new JLabel("Last Name:");
        lblLastName.setBounds(450, 150, 100, 15);
        add(lblLastName);

        txtLastName = new JTextField();
        txtLastName.setBounds(410, 170, 150, 30);
        add(txtLastName);

        lblMiddleName = new JLabel("Middle Name:");
        lblMiddleName.setBounds(640, 150, 100, 15);
        add(lblMiddleName);

        txtMiddleName = new JTextField();
        txtMiddleName.setBounds(600, 170, 150, 30);
        add(txtMiddleName);

        lblCourse = new JLabel("Course:");
        lblCourse.setBounds(70, 250, 100, 15);
        add(lblCourse);

        txtCourse = new JTextField();
        txtCourse.setBounds(30, 270, 150, 30);
        add(txtCourse);

        lblYear = new JLabel("Year:");
        lblYear.setBounds(270, 250, 100, 15);
        add(lblYear);

        txtYear = new JTextField();
        txtYear.setBounds(220, 270, 150, 30);
        add(txtYear);

        lblAddress = new JLabel("Address:");
        lblAddress.setBounds(450, 250, 100, 15);
        add(lblAddress);

        txtAddress = new JTextField();
        txtAddress.setBounds(410, 270, 150, 30);
        add(txtAddress);

        lblcontact = new JLabel("Contact:");
        lblcontact.setBounds(640, 250, 100, 15);
        add(lblcontact);

        txtcontact = new JTextField();
        txtcontact.setBounds(600, 270, 150, 30);
        add(txtcontact);

        lblbday = new JLabel("Birthday:");
        lblbday.setBounds(160, 350, 100, 15);
        add(lblbday);

        txtbday = new JTextField();
        txtbday.setBounds(115, 370, 150, 30);
        add(txtbday);

        lblpos = new JLabel("Position:");
        lblpos.setBounds(360, 350, 100, 15);
        add(lblpos);

        txtpos = new JTextField();
        txtpos.setBounds(315, 370, 150, 30);
        add(txtpos);

        lblaffil = new JLabel("Affiliation:");
        lblaffil.setBounds(560, 350, 100, 15);
        add(lblaffil);

        txtaffil = new JTextField();
        txtaffil.setBounds(510, 370, 150, 30);
        add(txtaffil);

        btnSignUp = new JButton("Sign up");
        btnSignUp.setBounds(270, 450, 100, 30);
        add(btnSignUp);
        btnSignUp.addActionListener(this);
        btnSignUp.setBorder(new LineBorder(tableBorderColor, 2));
        btnSignUp.setBackground(new Color(255, 222, 89));

        btnReturn = new JButton("Return");
        btnReturn.setBounds(35, 450, 100, 30);
        add(btnReturn);
        btnReturn.addActionListener(this);
        btnReturn.setBorder(new LineBorder(tableBorderColor, 2));
        btnReturn.setBackground(new Color(255, 222, 89));

        btnClear = new JButton("Clear");
        btnClear.setBounds(380, 450, 100, 30);
        add(btnClear);
        btnClear.addActionListener(this);
        btnClear.setBorder(new LineBorder(tableBorderColor, 2));
        btnClear.setBackground(new Color(255, 222, 89));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSignUp) {
            if (txtStudentNo.getText().isEmpty() || txtLastName.getText().isEmpty() || txtFirstName.getText().isEmpty() ||
                txtCourse.getText().isEmpty() || txtYear.getText().isEmpty() ||
                txtAddress.getText().isEmpty() || txtcontact.getText().isEmpty() || txtbday.getText().isEmpty() || txtpos.getText().isEmpty() ||
                txtaffil.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all required fields (except Middle Name).", "Incomplete Form", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                String[] data = new String[11];
                data[0] = txtStudentNo.getText();
                data[1] = txtLastName.getText();
                data[2] = txtFirstName.getText();
                data[3] = txtMiddleName.getText();
                data[4] = txtCourse.getText();
                data[5] = txtYear.getText();
                data[6] = txtAddress.getText();
                data[7] = txtcontact.getText();
                data[8] = txtbday.getText();
                data[9] = txtpos.getText();
                data[10] = txtaffil.getText();

                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_pupcite", "root", "");
                String query = "INSERT INTO tbl_pupcite (stud_ID, LName, FName, MName, course, year, address, contact_no, bday, position, affiliation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(query);
                for (int i = 0; i < data.length; i++) {
                    ps.setString(i + 1, data[i]);
                }
                ps.executeUpdate();
                ps.close();
                conn.close();

                JOptionPane.showMessageDialog(null, "Sign up successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException a) {
                a.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database error: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnReturn) {
            dispose();
            WelcomePage welcomePage = new WelcomePage();
            welcomePage.setVisible(true);
        } else if (e.getSource() == btnClear) {
            clearFields();
        }
    }

    private void clearFields() {
        txtStudentNo.setText("");
        txtLastName.setText("");
        txtFirstName.setText("");
        txtMiddleName.setText("");
        txtCourse.setText("");
        txtYear.setText("");
        txtAddress.setText("");
        txtcontact.setText("");
        txtbday.setText("");
        txtpos.setText("");
        txtaffil.setText("");
    }
}