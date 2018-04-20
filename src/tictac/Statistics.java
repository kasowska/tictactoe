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

//Importing the web service

import tictac.TTTWebService;
import tictac.TTTWebService_Service;

public class Statistics {
    
    private TTTWebService proxy;
    private TTTWebService_Service tttws;

    public TTTWebService getProxy(){

          return proxy;  
    }
     
        public Statistics(){
     
            tttws = new TTTWebService_Service();
            proxy = tttws.getTTTWebServicePort();

                JFrame frame = new JFrame("LEADS");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(0,5));
                frame.getContentPane().add(panel);

                JLabel autoKey = new JLabel("Click View Dashboard to view stats");
                panel.add(autoKey);

                JButton closeboard = new JButton("CLOSE THE DASHBOARD");
                closeboard.setBackground(Color.cyan);
                closeboard.setForeground(Color.WHITE);
                panel.add(closeboard);

                JButton getleads = new JButton("VIEW DASHBOARD");
                getleads.setBackground(Color.cyan);
                getleads.setForeground(Color.WHITE);
                panel.add(getleads);

                getleads.addActionListener( new ActionListener(){

                    public void actionPerformed(ActionEvent e) {

                        String leagueresult = proxy.leagueTable();
                        String [] leaguearray = leagueresult.split("\n");

                        JFrame frame1 = new JFrame();
                        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        JPanel panel1 = new JPanel();
                        panel1.setLayout(new GridLayout(0,5));
                        frame1.getContentPane().add(panel1);

                        JLabel gameid = new JLabel ("Game ID ");
                        panel1.add(gameid);
                        JLabel player1 = new JLabel ("Player 1 ");
                        panel1.add(player1);
                        JLabel player2 = new JLabel ("Player 2 ");
                        panel1.add(player2);
                        JLabel gamestate = new JLabel ("Game-State ID ");
                        panel1.add(gamestate);
                        JLabel status = new JLabel ("Status ");
                        panel1.add(status);

                        for(int y=0;y<leaguearray.length;y++){
                            String [] splitleaguearray = leaguearray[y].split(",");
                            for(int n= 0; n <splitleaguearray.length; n++){

                                JTextField league_result = new JTextField (" ");
                                league_result.setText(splitleaguearray[n]);
                                panel1.add(league_result);

                                frame1.pack();
                                frame1.setVisible(true);

                            }

                    } 
                    System.out.println("Fetching league data");
                }}); //close action listener

         frame.pack();
         frame.setVisible(true); 
        }
}


     
