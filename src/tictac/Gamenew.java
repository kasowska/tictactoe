/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Mia Baliga
 */

public  class Gamenew {
    
    private TTTWebService proxy;
    private TTTWebService_Service tttws;
    
     public TTTWebService getProxy(){
        
      return proxy;  
    }
     

   public void Gamenew(int x)
    {
    
    System.out.println(" AUTOKEY of the user is  " +x);
    System.out.println("Game started");
    
    

        JFrame frame = new JFrame("DETAILS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));

        
        JTextField aid = new JTextField(20);
        panel.add(aid);
        
        tttws = new TTTWebService_Service();
        proxy = tttws.getTTTWebServicePort();
    
    String gameword= proxy.newGame(x);
        if(gameword == "ERROR-NOTFOUND" || gameword == "ERROR-RETRIEVE")
                {
                    System.out.println("An error occured");
                }
        else
        {
        aid.setText("GAME ID of this game is "+ gameword);
        }
       
        
        
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true); 
    }

   // @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
