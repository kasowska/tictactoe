/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac;

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
import tictac.TTTWebService;
import tictac.TTTWebService_Service;

public class Gamegrid   {
    
    private TTTWebService proxy;
 private TTTWebService_Service tttws;
    
     public TTTWebService getProxy(){
        
      return proxy;  
    }
   
    public Gamegrid(){
        
        tttws = new TTTWebService_Service();
        proxy = tttws.getTTTWebServicePort();
        
        
        JFrame frame = new JFrame("DETAILS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,3));
        panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        frame.getContentPane().add(panel);
        
        JButton[][] grid = new JButton[3][3] ;
        //Creating button array.
        for (int i=0; i<9;i++)
        {
        
        for (int d=0; d<9;d++)
        {
            for(int j=0;j<9;j++)
            {
            
                //Adding the buttons with names that is same as the array coordinates
             grid [d][j]= new JButton ("");
             grid [d][j].setName("Button" + grid [d][j]);
             panel.add(grid [d][j]);
            
            
            }
        
        
        
        }
        
        
       
        
        JButton quit = new JButton("QUIT NOW");
        quit.setBackground(Color.green);
        
        panel.add(quit);
        
        quit.addActionListener(new ActionListener(){
        
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Quitters never win!");
            frame.dispose();;
        }
     });
      
        JButton start = new JButton("Start Game");
        start.setBackground(Color.green);
        panel.add(start);
        start.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        
        String check_Result= proxy.checkSquare(0, 0, 0);
        
        if(check_Result== "1")
                {
                
                System.out.println("Square has been taken, try another square");
                
                }
        
        else 
        {
        
        String takesq_Result = proxy.takeSquare(0, 0, 0, 0);
        
             if(takesq_Result == "0"|| takesq_Result == "ERROR-TAKEN"||takesq_Result == "ERROR-DB" || takesq_Result == "ERROR"){
             
                  System.out.println("Move was Unsuccessful " + takesq_Result);
             
             }   
             else
                {
                
                
                
                }
        
        }
            
            
        
        }
        
        
        
        
        
        });
        
         
    frame.pack();
    frame.setVisible(true); 
    
    }

    
    }
}


