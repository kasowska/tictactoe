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
public class Signuppage {
    
    public Signuppage(){
    JFrame frame = new JFrame ("SIGNUP FOR THE GAME ");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //Create a heading label
    
    JLabel heading = new JLabel("SIGNUP FOR THE GAME");
    heading.setBackground(Color.red);
    heading.setName("SIGNUP FOR THE GAME");
    heading.setFont(new Font("Courier New", Font.ITALIC, 36));
    heading.setPreferredSize(new Dimension(300, 100));
    frame.getContentPane().add(heading, BorderLayout.BEFORE_FIRST_LINE);
    
    //Create a name label
    
    JLabel name = new JLabel("ENTER YOUR NAME");
    name.setBackground(Color.red);
    name.setName("ENTER YOUR NAME");
    name.setFont(new Font("Courier New", Font.ITALIC, 36));
    name.setPreferredSize(new Dimension(50, 100));
    frame.getContentPane().add(name, BorderLayout.CENTER);
    
    //Create a email label
    
    JLabel email = new JLabel("ENTER YOUR EMAIL");
    email.setBackground(Color.red);
    email.setName("ENTER YOUR EMAIL ID");
    email.setFont(new Font("Courier New", Font.ITALIC, 36));
    email.setPreferredSize(new Dimension(100, 100));
    frame.getContentPane().add(email, BorderLayout.LINE_END);
    
    //Create a password label
    
    JLabel pwd = new JLabel("Set a Password");
    pwd.setBackground(Color.red);
    pwd.setName("SET A PASSWORD");
    pwd.setFont(new Font("Courier New", Font.ITALIC, 36));
    pwd.setPreferredSize(new Dimension(100, 100));
    frame.getContentPane().add(pwd);
    
    //Create a name textbox
    
    JTextField entername = new JTextField(20);
    entername.setFont(new Font("Courier New", Font.PLAIN, 18));
    entername.setPreferredSize(new Dimension(100, 100));
    frame.getContentPane().add(entername, BorderLayout.SOUTH);
    entername.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
                entername.isEditable();
            }
     });
    
    //Create a email textbox
    
    JTextField enteremail = new JTextField(20);
    enteremail.setFont(new Font("Courier New", Font.PLAIN, 18));
    enteremail.setPreferredSize(new Dimension(100, 100));
    frame.getContentPane().add(enteremail, BorderLayout.CENTER);
    enteremail.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
                enteremail.isEditable();
            }
     });
    
    //Create a PWD textbox
    
    JTextField enterpwd = new JTextField(20);
    enterpwd.setFont(new Font("Courier New", Font.PLAIN, 18));
    enterpwd.setPreferredSize(new Dimension(100, 100));
    frame.getContentPane().add(enterpwd, BorderLayout.WEST);
    enterpwd.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
                enterpwd.isEditable();
            }
     });
    
    //Create Submit button
    JButton submit= new JButton("SUBMIT");
    submit.setName("SUBMIT");
    submit.setPreferredSize(new Dimension(500, 75));
    frame.getContentPane().add(submit, BorderLayout.PAGE_END);
    //Create Action LIstener
    submit.addActionListener(new ActionListener(){
   //Action Event
    public void actionPerformed(ActionEvent e) {
                entername.setText("");
                enteremail.setText("");
                enterpwd.setText("");
                //Objects Runs the code in the constructor leading to next page
                
                
        }
   });
    
    //Display the window.
    frame.pack();
    frame.setVisible(true); 
    
    }
}
