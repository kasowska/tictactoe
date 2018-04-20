package tictac;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
//Importing the webservice
import tictac.TTTWebService;
import tictac.TTTWebService_Service;

public class Loginform {
    
 private TTTWebService proxy;
 private TTTWebService_Service tttws;
    
     public TTTWebService getProxy(){
        
      return proxy;  
    }
     
  public Loginform()
  {
        tttws = new TTTWebService_Service();
        proxy = tttws.getTTTWebServicePort();
        
        JFrame frame = new JFrame("DETAILS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,2));
        frame.getContentPane().add(panel);

        JLabel username = new JLabel("UserName");
        panel.add(username);
        JTextField uname = new JTextField(20);
        panel.add(uname);
        
        JLabel password = new JLabel("Password");
        panel.add(password);
        JTextField passwords = new JTextField(20);
        panel.add(passwords);
        
        JButton reg = new JButton("Go to register");
        reg.setName("Go to Register");
        panel.add(reg);
   
        reg.addActionListener(new ActionListener(){
        //Action Event
   
            public void actionPerformed(ActionEvent e) {
    
         Signupform suf = new Signupform();
     
            }
    });
        
        //Create newgame button
    JButton login = new JButton("LOGIN");
    login.setName("LOGIN");
    panel.add(login);
   
   
   
   
    //Register Button click using action listener
    login.addActionListener(new ActionListener(){
   //Action Event
    @Override
    public void actionPerformed(ActionEvent e) {
        
         try {
           
            String un = uname.getText();
            String pw = passwords.getText();
            
Loginform myService = new Loginform();
TTTWebService proxy = myService.getProxy();
    
int result = proxy.login(un, pw);
System.out.println("Auto key is "+result);
if(result==0||result ==-1)
{
       System.out.println("WRONG CREDENTIALS!");
   }
    
    else
    {
       System.out.println("LOGIN SUCCESSFUL");
         Nextstep ns= new Nextstep(); 
         ns.Nextstep(result);
        //Passing the User id in the parameterized constructor.
        
        //System.out.println("Starting new game");
        //Parameterized constructor from Newgame class
        //proxy.newGame(result);
        
        
        //Existinggames egg = new Existinggames();
    }
//    
//            //1.Get connection to database
//            Connection myConn;
//            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoe","root","mialucifer");
//            //2.Create a statement
//            Statement myStmt = myConn.createStatement();
//            //3.Execute Query
//            //ResultSet rs = myStmt.executeQuery("Select autoID from users where username ="+un+ "and password="+pw+";");
//            ResultSet rs = myStmt.executeQuery("Select autokey from users where username ='" + un + "' and password = '" + pw + "'");
//
//            //4.process result set
//            System.out.println("Your AutoId is " + rs);

                  // TODO add your handling code here:
                  
        } catch (Exception ex) {
            Logger.getLogger(Loggingin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        passwords.setText("");
        uname.setText("");
        
       }
     });

//Display the window.
    frame.pack();
    frame.setVisible(true); 
    
}
 
}
