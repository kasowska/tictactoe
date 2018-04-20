package tictac;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mia Baliga
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.net.*;
import javax.swing.*;

public class StartUp{
    
    
   public StartUp(){
    JFrame frame = new JFrame ("WELCOME TO TIC TAC TOE ");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //Create intro Label
    JLabel emptyLabel1 = new JLabel("WELCOME TO TIC TAC TOE");
    emptyLabel1.setName("WELCOME TO TIC TAC TOE");
    emptyLabel1.setFont(new Font("Courier New", Font.ITALIC, 36));
    emptyLabel1.setPreferredSize(new Dimension(175, 100));
    frame.getContentPane().add(emptyLabel1, BorderLayout.BEFORE_FIRST_LINE);
    
    
     //Create Login button
    JButton login= new JButton("LOGIN");
    login.setName("LOGIN");
    login.setPreferredSize(new Dimension(500, 75));
    frame.getContentPane().add(login, BorderLayout.CENTER);
    //Create Action LIstener
    login.addActionListener(new ActionListener(){
   //Action Event
    public void actionPerformed(ActionEvent e) {
                Loginform lf= new Loginform();
        }
    
   });
    
    
    
    //Create Signup button
    JButton signup= new JButton("SIGN-UP");
    signup.setName("REGISTER");
    signup.setPreferredSize(new Dimension(500, 75));
    frame.getContentPane().add(signup, BorderLayout.PAGE_END);
    //Create Action LIstener
    signup.addActionListener(new ActionListener(){
   //Action Event
    public void actionPerformed(ActionEvent e) {
                Signupform sf = new Signupform();
        }
    
   });
    
    //Display the window.
    frame.pack();
    frame.setVisible(true); 
   } 
    
}
