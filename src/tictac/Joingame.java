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
public class Joingame {
    
    public Joingame(){
        
        JFrame frame = new JFrame("DETAILS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,2));

        //GridLayout to enter values
        
        frame.getContentPane().add(panel);
        
        JLabel FirstNameL = new JLabel("FirstName");
        panel.add(FirstNameL);
        JTextField FirstName = new JTextField(20);
        panel.add(FirstName);
        
        JLabel LastNameL = new JLabel("LastName");
        panel.add(LastNameL);
        JTextField LastName = new JTextField(20);
        panel.add(LastName);
        
        JLabel password = new JLabel("password");
        panel.add(password);
       JTextField pwd = new JTextField(20);
        panel.add(pwd);
        
        JButton SUBMIT = new JButton("SUBMIT");
        panel.add(SUBMIT);
        SUBMIT.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
                JDBC jdbc = new JDBC();
            }
     });

//Display the window.
    frame.pack();
    frame.setVisible(true);   
}
    
}
