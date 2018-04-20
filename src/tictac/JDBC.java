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
import java.util.Scanner;
import javax.swing.*;
public class JDBC {
    public JDBC(){

try {
    
    Scanner s = new Scanner(System.in);
    System.out.print("Enter your last name: ");
    String lname = s.nextLine();

    System.out.print("Enter your first name: ");
    String fname = s.nextLine();

    System.out.print("Enter your password ");
    String pwd = s.nextLine();

    System.out.print("Enter your username ");
    String username = s.nextLine();
     //1.Get connection to database
     Connection myConn;
     myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoe/users","root","mialucifer");
     //2.Create a statement
     Statement myStmt = myConn.createStatement();
     
    ResultSet myRs = myStmt.executeQuery("Insert into users (name,surname,password, username)values(lname,fname,pwd,username)");
     //4.process result set
    while (myRs.next()){
    System.out.print(myRs.getString("Name"));
    System.out.println("\n");
    
    System.out.print(myRs.getString("Surname"));
    System.out.println("\n");
    
    System.out.print(myRs.getString("username"));
    System.out.println("\n");
    
    };
            
        } catch (Exception exc) {
            // TODO Auto-generated catch block
            exc.printStackTrace();
        } 
}
}
