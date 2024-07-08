/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentmembershipmanagementsystem;

import java.awt.*;
import static java.awt.Color.black;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;

public class MembershipViewing extends JFrame implements ActionListener {
    
    private ImageIcon ibitslg;
    JPanel headerPanel;
    JLabel headerLabel, subheaderLabel, searchlbl;
    JTable table;
    Color tableBorderColor;
    JTableHeader tableHeader;
    JScrollPane scrollPane, showScrollPane;
    CustomTableModel model;
    JButton  returnButton, delButton, updateButton, searchButton, addButton;
    ImageIcon schoollogoyellow;
    JTextField searcharea;
    JTextArea showsearch;

    MembershipViewing() {

        setTitle("Viewing of Student Record");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 800));
        getContentPane().setBackground(new Color(8, 143, 143));
        setLayout(null);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        
        
        headerPanel = new JPanel();
        headerPanel.setBackground(new Color(255, 222, 89));
        headerPanel.setBounds(0, 0, 1000, 100);
        headerPanel.setLayout(new BorderLayout());

        ibitslg = new ImageIcon("ibitslg.png");
        Image resizedlogoyellow = ibitslg.getImage().getScaledInstance(80,80, Image.SCALE_SMOOTH);
        ImageIcon finallogoyellow = new ImageIcon(resizedlogoyellow);
        JLabel logoyellow = new JLabel(finallogoyellow);
        logoyellow.setBounds(270,0,130,100);
        headerPanel.add(logoyellow);

        headerLabel = new JLabel("STUDENT RECORD", SwingConstants.CENTER);
        headerLabel.setForeground(Color.BLACK);
        headerLabel.setFont(new Font("Trajan Pro", Font.BOLD, 24));
        headerLabel.setBounds(0, 15, 1000, 50);
        headerPanel.add(headerLabel);

        subheaderLabel = new JLabel("IBITS ORGANIZATION", SwingConstants.CENTER);
        subheaderLabel.setBounds(0, 50, 1000, 40);
        subheaderLabel.setFont(new Font("Trajan Pro", Font.BOLD, 16));
        subheaderLabel.setForeground(black);
        add(subheaderLabel);

        searchlbl = new JLabel("Student No.");
        searchlbl.setForeground(Color.BLACK);
        searchlbl.setFont(new Font("Trajan Pro", Font.BOLD, 16));
        searchlbl.setBounds(35, 115, 100, 30);

        model = new CustomTableModel(new Object[]{"Student No", "Last Name", "First Name", "Middle Name", "Course", "Year", "Address", "Contact No", "Birthday", "Position", "Affiliation"}, 0);
        table = new JTable(model);
        table.setOpaque(false);
        table.setBackground(new Color(245, 245, 220));

        tableHeader = table.getTableHeader();
        table.getTableHeader().setBackground(new Color(255, 222, 89));
        table.getTableHeader().setForeground(black);
        table.getTableHeader().setFont(new Font("Trajan Pro", Font.BOLD, 13));

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(12, 205, 960, 500);
        tableBorderColor = new Color(0, 0, 0);
        scrollPane.setBorder(new LineBorder(tableBorderColor, 4));

        searcharea = new JTextField();
        searcharea.setBounds(145, 115, 200, 30);
        searcharea.setBorder(new LineBorder(tableBorderColor, 2));

        showsearch = new JTextArea();
        showsearch.setBorder(new LineBorder(tableBorderColor, 2));
        showsearch.setEditable(true);

        showScrollPane = new JScrollPane(showsearch);
        showScrollPane.setBounds(507, 115, 240, 80);
        showScrollPane.setBorder(new LineBorder(tableBorderColor, 1));

        searchButton = new JButton("Search");
        searchButton.setFont(new Font("Serif", Font.BOLD, 16));
        searchButton.setForeground(black);
        searchButton.setBackground(new Color(255, 222, 89));
        searchButton.setOpaque(true);
        searchButton.setBorder(null);
        searchButton.setBounds(365, 115, 120, 30);
        searchButton.addActionListener(this);
        searchButton.setBorder(new LineBorder(tableBorderColor, 2));

        

        delButton = new JButton("Delete");
        delButton.setFont(new Font("Serif", Font.BOLD, 16));
        delButton.setForeground(black);
        delButton.setBackground(new Color(255, 222, 89));
        delButton.setOpaque(true);
        delButton.setBorder(null);
        delButton.setBounds(210, 715, 150, 30);
        delButton.addActionListener(this);
        delButton.setBorder(new LineBorder(tableBorderColor, 2));

        addButton = new JButton("Add Student");
        addButton.setFont(new Font("Serif", Font.BOLD, 16));
        addButton.setForeground(black);
        addButton.setBackground(new Color(255, 222, 89));
        addButton.setOpaque(true);
        addButton.setBorder(null);
        addButton.setBounds(40, 715, 150, 30);
        addButton.addActionListener(this);
        addButton.setBorder(new LineBorder(tableBorderColor, 2));
        
        updateButton = new JButton("Update");
        updateButton.setFont(new Font("Serif", Font.BOLD, 16));
        updateButton.setForeground(black);
        updateButton.setBackground(new Color(255, 222, 89));
        updateButton.setOpaque(true);
        updateButton.setBorder(null);
        updateButton.setBounds(765, 115, 150, 30);
        updateButton.addActionListener(this);
        updateButton.setBorder(new LineBorder(tableBorderColor, 2));
        

        returnButton = new JButton("Return");
        returnButton.setFont(new Font("Serif", Font.BOLD, 16));
        returnButton.setForeground(black);
        returnButton.setBackground(new Color(255, 222, 89));
        returnButton.setOpaque(true);
        returnButton.setBorder(null);
        returnButton.setBounds(780, 715, 150, 30);
        returnButton.addActionListener(this);
        returnButton.setBorder(new LineBorder(tableBorderColor, 2));

        add(scrollPane);
        add(headerPanel);
        add(addButton);   
        add(delButton);
        add(returnButton);
        add(updateButton);
        add(searcharea);
        add(searchlbl);
        add(showScrollPane);
        add(searchButton);
        pack();
        setVisible(true);

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_pupcite", "root", "");
            Statement st = conn.createStatement();
            String query = "SELECT * FROM tbl_pupcite";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String stud_ID = rs.getString("stud_ID");
                String LName = rs.getString("LName");
                String FName = rs.getString("FName");
                String MName = rs.getString("MName");
                String course = rs.getString("course");
                String year = rs.getString("year");
                String address = rs.getString("address");
                String contact_no = rs.getString("contact_no");
                String Bday = rs.getString("Bday");
                String Position = rs.getString("Position");
                String Affiliation = rs.getString("Affiliation");

                String tblInfo[] = {stud_ID, LName, FName, MName, course, year, address, contact_no, Bday, Position, Affiliation};
                DefaultTableModel tbl = (DefaultTableModel) table.getModel();
                tbl.addRow(tblInfo);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == returnButton) {
            dispose();
            WelcomePage wp = new WelcomePage();
            wp.setVisible(true);
        } else if (e.getSource() == delButton) {
            deleteStudentRecord();
        } else if (e.getSource() == searchButton) {
            searchStudentRecord();
        } else if (e.getSource() == updateButton) {
            updateStudentRecord();
        } else if(e.getSource() == addButton){
        dispose();
        MembershipForm mf = new MembershipForm();
        mf.setVisible(true);
        }
    }

    private void deleteStudentRecord() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            
            String studentNo = (String) model.getValueAt(selectedRow, 0);

           
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete student number: " + studentNo + "?", "Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_pupcite", "root", "");
                    String query = "DELETE FROM tbl_pupcite WHERE stud_ID = ?";
                    PreparedStatement pst = conn.prepareStatement(query);
                    pst.setString(1, studentNo);
                    pst.executeUpdate();
                    conn.close();

                   
                    model.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(this, "Student record deleted successfully.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student record to delete.");
        }
    }

    private void searchStudentRecord() {
        String studentNo = searcharea.getText().trim();
        if (studentNo.isEmpty()) {
            showsearch.setText("Please enter a student number to search.");
            return;
        }

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_pupcite", "root", "");
            String query = "SELECT * FROM tbl_pupcite WHERE stud_ID = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, studentNo);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String stud_ID = rs.getString("stud_ID");
                String LName = rs.getString("LName");
                String FName = rs.getString("FName");
                String MName = rs.getString("MName");
                String course = rs.getString("course");
                String year = rs.getString("year");
                String address = rs.getString("address");
                String contact_no = rs.getString("contact_no");
                String Bday = rs.getString("Bday");
                String Position = rs.getString("Position");
                String Affiliation = rs.getString("Affiliation");

                showsearch.setText("Student No: " + stud_ID + "\nLast Name: " + LName + "\nFirst Name: " + FName +
                        "\nMiddle Name: " + MName + "\nCourse: " + course + "\nYear: " + year + "\nAddress: " + address +
                        "\nContact No: " + contact_no + "\nBirthday: " + Bday + "\nPosition: " + Position +
                        "\nAffiliation: " + Affiliation);
            } else {
                showsearch.setText("No record found for student number: " + studentNo);
            }
            conn.close();
        } catch (Exception ex) {
            showsearch.setText("Error: " + ex.getMessage());
        }
    }

    private void updateStudentRecord() {
        String text = showsearch.getText().trim();
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No student record selected for update.");
            return;
        }

        String[] lines = text.split("\n");
        String[] data = new String[11];
        for (String line : lines) {
            String[] keyValue = line.split(": ");
            switch (keyValue[0]) {
                case "Student No":
                    data[0] = keyValue[1];
                    break;
                case "Last Name":
                    data[1] = keyValue[1];
                    break;
                case "First Name":
                    data[2] = keyValue[1];
                    break;
                case "Middle Name":
                    data[3] = keyValue[1];
                    break;
                case "Course":
                    data[4] = keyValue[1];
                    break;
                case "Year":
                    data[5] = keyValue[1];
                    break;
                case "Address":
                    data[6] = keyValue[1];
                    break;
                case "Contact No":
                    data[7] = keyValue[1];
                    break;
                case "Birthday":
                    data[8] = keyValue[1];
                    break;
                case "Position":
                    data[9] = keyValue[1];
                    break;
                case "Affiliation":
                    data[10] = keyValue[1];
                    break;
            }
        }

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_pupcite", "root", "");
            String query = "UPDATE tbl_pupcite SET LName = ?, FName = ?, MName = ?, course = ?, year = ?, address = ?, contact_no = ?, Bday = ?, Position = ?, Affiliation = ? WHERE stud_ID = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, data[1]);
            pst.setString(2, data[2]);
            pst.setString(3, data[3]);
            pst.setString(4, data[4]);
            pst.setString(5, data[5]);
            pst.setString(6, data[6]);
            pst.setString(7, data[7]);
            pst.setString(8, data[8]);
            pst.setString(9, data[9]);
            pst.setString(10, data[10]);
            pst.setString(11, data[0]);
            pst.executeUpdate();
            conn.close();

            // Refresh the table data
            refreshTableData();

            JOptionPane.showMessageDialog(this, "Student record updated successfully.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void refreshTableData() {
        model.setRowCount(0); // Clear the table

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_pupcite", "root", "");
            Statement st = conn.createStatement();
            String query = "SELECT * FROM tbl_pupcite";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String stud_ID = rs.getString("stud_ID");
                String LName = rs.getString("LName");
                String FName = rs.getString("FName");
                String MName = rs.getString("MName");
                String course = rs.getString("course");
                String year = rs.getString("year");
                String address = rs.getString("address");
                String contact_no = rs.getString("contact_no");
                String Bday = rs.getString("Bday");
                String Position = rs.getString("Position");
                String Affiliation = rs.getString("Affiliation");

                String tblInfo[] = {stud_ID, LName, FName, MName, course, year, address, contact_no, Bday, Position, Affiliation};
                DefaultTableModel tbl = (DefaultTableModel) table.getModel();
                tbl.addRow(tblInfo);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        
    }

    
    class CustomTableModel extends DefaultTableModel {
        CustomTableModel(Object[] columnNames, int rowCount) {
            super(columnNames, rowCount);
        }

    }
}


