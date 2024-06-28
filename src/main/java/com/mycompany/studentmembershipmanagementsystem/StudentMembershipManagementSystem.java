/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.studentmembershipmanagementsystem;

import java.awt.EventQueue;

/**
 *
 * @author Harvey
 */
public class StudentMembershipManagementSystem {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run(){ 
                WelcomePage wp = new WelcomePage();
                wp.setVisible(true);
                
            }
        });
    }
}
