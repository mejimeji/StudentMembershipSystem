package com.mycompany.studentmembershipmanagementsystem;

import java.awt.EventQueue;



/**
 *
 * @author Harvey
 */


public class StudentMembershipManagementSystem {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){ 
                WelcomePage wp = new WelcomePage();
                wp.setVisible(true);

            }
        });
    }
}
