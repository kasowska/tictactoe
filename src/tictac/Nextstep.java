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

public class Nextstep {
  
    
    public void Nextstep (int x)
    
    
    {
        
    System.out.println(" AUTOKEY of the user has been saved  " +x);
    
    JFrame frame = new JFrame ("START OR JOIN A GAME ");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel(); 
    panel.setLayout(new GridLayout(0,1));
    
    //Create intro Label
    JLabel emptyLabel1 = new JLabel("START OR JOIN A GAME");
    emptyLabel1.setName("START OR JOIN A GAME");
    panel.add(emptyLabel1);
    
    
    //Create newgame button
    JButton newgame = new JButton("Start New Game");
    newgame.setName("CREATE GAME");
    panel.add(newgame);
   
    //Register Button click using action listener
    newgame.addActionListener(new ActionListener(){
   //Action Event
    public void actionPerformed(ActionEvent e) {
        System.out.println("Starting new game");
        Gamenew ng = new Gamenew();
        ng.Gamenew(x);
        }
     });
    
    //Create LEAGUE TABLE BUTTON
    JButton league= new JButton("VIEW LEAGUES");
    league.setName("LEAGUES");
    panel.add(league);
    
    league.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e) { 
           
           Statistics sc = new Statistics();
       } 
    });
    
    
    //Create joingame button
    JButton joingame= new JButton("Join open Games");
    joingame.setName("JOIN GAME");
    panel.add(joingame);
    
   
    //Register Button click using action listener
    joingame.addActionListener(new ActionListener(){
   //Action Event
    public void actionPerformed(ActionEvent e) {
        System.out.println("Joining game");
        //Calling the cinstructor
        Existinggames egg = new Existinggames();
        egg.Existinggames(x);
        }
     });
      //Display the window.
    frame.getContentPane().add(panel);
    frame.pack();
    frame.setVisible(true);   
    }
    
}
