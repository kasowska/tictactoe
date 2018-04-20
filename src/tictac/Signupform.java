
/**
 *
 * @author Mia Baliga
 */
package tictac;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.net.*;
import java.util.Scanner;
import javax.swing.*;
import tictac.TTTWebService;
import tictac.TTTWebService_Service;


public class Signupform {
 
    private TTTWebService proxy;
    private TTTWebService_Service tttws;
    
    public TTTWebService getProxy(){
        
        return proxy;  
    }
    
        public Signupform(){
        tttws = new TTTWebService_Service();
        proxy = tttws.getTTTWebServicePort();
        
        
        //GUI
        JFrame frame = new JFrame("DETAILS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,2));
        frame.getContentPane().add(panel);
        
        JLabel FirstNameL = new JLabel("FirstName");
        panel.add(FirstNameL);
        JTextField FirstName = new JTextField(20);
        panel.add(FirstName);
        
        JLabel LastNameL = new JLabel("LastName");
        panel.add(LastNameL);
        JTextField LastName = new JTextField(20);
        panel.add(LastName);
        
        JLabel uname = new JLabel("USER NAME");
        panel.add(uname);
        JTextField username = new JTextField(20);
        panel.add(username);
        
        JLabel password = new JLabel("Password");
        panel.add(password);
        JTextField passwords = new JTextField(20);
        panel.add(passwords);
        
        JButton reg = new JButton("Go to Login");
        reg.setName("Go to Login");
        panel.add(reg);
   
        reg.addActionListener(new ActionListener(){
        //Action Event on clicking "Register"
   
        public void actionPerformed(ActionEvent e) {
            //Calling loginform.java constuctor
            Loginform lf = new Loginform();
     
            }
        });
        
        //Create newgame button
        JButton signup = new JButton("SIGN UP");
        signup.setName("signup");
        panel.add(signup);
   
        //Register Button click using action listener
        signup.addActionListener(new ActionListener(){
        //Action Event
    @Override
        public void actionPerformed(ActionEvent e) {
        
       //JDBC CONNECTIONS to insert into table  
        try {
    
                String fn = FirstName.getText();
                String ln = LastName.getText();
                String un = username.getText();
                String p = passwords.getText();
    
                    Signupform myService = new Signupform();
                    TTTWebService proxy = myService.getProxy();
                    
                    String result = proxy.register(un,p,fn, ln);
                    
                    if("ERROR-REPEAT".equals(result)||"ERROR-INSERT".equals(result)||"ERROR-RETRIEVE".equals(result)||"ERROR-DB".equals(result))
                    {
                        System.out.println("Could not register the user!" + result);
                    
                    }
                    
                    else
                    {
                        System.out.println(result);
                        System.out.println("LOGIN NOW!");
                        //loginform lf = new loginform();
                    }
                    
//                //1.Get connection to database
//                Connection myConn;
//                myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoe","root","mialucifer");
//                //2.Create a statement
//                Statement myStmt = myConn.createStatement();
//                //3.Execute Query
//                myStmt.executeQuery("Insert into users (name,surname,username, password)values('" + fn + "','" + ln + "','" + un + "','" + p + "')");
//                //4.process result set
//                //System.out.print("Values have been Inserted into table USER and autoID is " + rs);
            } catch (Exception exc) {
                    // TODO Auto-generated catch block
                    exc.printStackTrace();
            } 
        
    FirstName.setText("");
    LastName.setText("");
    username.setText("");
    passwords.setText("");
        
    }
    });

//Display the window.
    frame.pack();
    frame.setVisible(true);   
    
 }
    
}
