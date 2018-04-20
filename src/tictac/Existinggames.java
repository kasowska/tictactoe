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
import javax.swing.*;
import javax.swing.border.Border;
import tictac.TTTWebService;
import tictac.TTTWebService_Service;

public class Existinggames {
    
    private TTTWebService proxy;
    private TTTWebService_Service tttws;
    
    //Proxy Methos for WebService
    public TTTWebService getProxy(){
      return proxy;  
    }
     
     
     public void Existinggames(int x){
         
         //Saving users Auto key to pass into API methods later
         System.out.println(" AUTOKEY of the user has been saved  " +x);
         int uid = x;
     
        tttws = new TTTWebService_Service();
        proxy = tttws.getTTTWebServicePort();
        
        JFrame frame = new JFrame("OPEN GAMES");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,8));
                
        //Heading1 gme id
        JLabel gameid = new JLabel("Game ID");
        panel.add(gameid); 
        //Heading2 user who created the game
        JLabel username = new JLabel("Username");
        panel.add(username);
        //Heading3 date&time
        JLabel Gamedata = new JLabel("Game Data");
        panel.add(Gamedata);
        //Heading4 join
        JLabel Clickjoin =  new JLabel (" Click to join");
        panel.add(Clickjoin);
        //Heading5 Delete
        JLabel Clickdel =  new JLabel ("Delete to remove game");
        panel.add(Clickdel);
        //Heading 6 Get game state
        JLabel getgs =  new JLabel ("Game state");
        panel.add(getgs);
        //Heading 7 blank
        JLabel getgs1 =  new JLabel ("");
        panel.add(getgs1);
        //Heading 8 get board
        JLabel getboard =  new JLabel ("Get Board");
        panel.add(getboard);
        
        //Using method showopengames
        String opengames;
        opengames = proxy.showOpenGames();
        System.out.println("open games "+opengames);
        
        if (opengames == "ERROR-NOGAMES"|| opengames== "ERROR-DB")
            {
               System.out.println("ERROR" + opengames);
            }
        else{
            String[] opengamearray = opengames.split("\n");
            for(int i=0; i < opengamearray.length; i++){
                //Creating another array to split each input to seperate game id, user id and time when the game was created
                String[]splitopengamearray = opengamearray[i].split(",");
                for(int j=0; j < opengamearray.length; j++)
                        {
                         JTextField nm = new JTextField ("  ");
                         nm.setText(splitopengamearray[0]);
                         panel.add(nm);

                         JTextField nmo = new JTextField ("  ");
                         nmo.setText(splitopengamearray[1]);
                         panel.add(nmo);
                         
                         JTextField nmop = new JTextField ("  ");
                         nmop.setText(splitopengamearray[2]);
                         panel.add(nmop);
                        }
        
                JButton getstate = new JButton();
                panel.add(getstate);

                JTextField getstate1 = new JTextField();
                panel.add(getstate1);
        
                JButton xy = new JButton ("Join Game Now");
                panel.add(xy);

                JButton xyz = new JButton ("Delete game");
                panel.add(xyz);

                JButton board = new JButton ("Open board");
                panel.add(board);
                
                //Assigning Game id to a variable for later use
                int gid = Integer.parseInt(splitopengamearray[0]);
         
                //Action listener for Join Game Now
                 xy.addActionListener(new ActionListener(){
                //Action Event
   
                public void actionPerformed(ActionEvent e) {
                
                        String joinresult = proxy.joinGame(uid, gid);
             
                        if(joinresult=="0"||joinresult=="ERROR-DB")
                        {

                            System.out.println("COULD NOT JOIN GAME "+joinresult);
                        }
                        else
                        {
                              System.out.println("JOINING GAME "+joinresult);
                              Gamegrid gd = new Gamegrid();
                        }
                    }  
                });
         
                //Action listener for Delete Game Now
                xyz.addActionListener(new ActionListener(){
                //Action Event
                public void actionPerformed(ActionEvent e) {

                        System.out.println("Deleting the game");  
                        String deleteresult = proxy.deleteGame(gid, uid);
                        if(deleteresult=="ERROR-DB"||deleteresult=="ERROR-GAMESTARTED")
                        {
                            System.out.println("COULD NOT DELETE GAME "+deleteresult);

                        }
                        else
                        {

                            System.out.println("THE GAME HAS BEEN SUCCESSFULLY DELETED "+deleteresult);
                        }
                      }
                    });
     
                //Action liaster for getstate
//                getstate.addActionListener(new ActionListener(){
//                //Action Event
//                public void actionPerformed(ActionEvent e) {
//                        String getgamestateresult = proxy.getGameState(gid);
//                        getstate1.setText(getgamestateresult);
//                        if(getgamestateresult=="ERROR-NOGAME"||getgamestateresult=="ERROR-NOGAME")
//                                {
//                                    System.out.println("An Error Occured" + getgamestateresult);
//                                }   
//                        else if(getgamestateresult=="0")
//                                {
//                                    JOptionPane.showMessageDialog(frame,"The game is in progress");
//                                }
//                        else if(getgamestateresult=="1")
//                                {
//                                    JOptionPane.showMessageDialog(frame,"Player 1 WINS!");
//                                }
//                        else if(getgamestateresult=="2")
//                                {
//                                    JOptionPane.showMessageDialog(frame,"Player 2 WINS!");
//                                }
//                        else if(getgamestateresult=="3")
//                                {
//                                    JOptionPane.showMessageDialog(frame,"Game is a Draw!");
//                                }
//                        else if(getgamestateresult=="-1")
//                                {
//                                    JOptionPane.showMessageDialog(frame,"Waiting for a second player to join");
//                                }
//                             }
//                        });
    
    
                //Action liaster for board
                board.addActionListener(new ActionListener(){
                //Action Event
                public void actionPerformed(ActionEvent e) {
                        //opens the game board
                        Gamegrid gg = new Gamegrid();
                      }
                });
   
            }
        
     frame.pack();
     frame.setVisible(true);  
    }
 }
}

     

