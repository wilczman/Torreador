/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


    import java.awt.*;
    import java.lang.*;
    import static java.util.Arrays.copyOf;
    import javax.swing.*; 
    import controller.*;
    import model.*;

    import java.net.URL;
    //import javax.swing.*;
    import javax.sound.sampled.*;
    import java.awt.Graphics;
    import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import controller.menuControl;
import controller.gameControl;
import static model.model.ACTUAL_BULL_POS;
import static model.model.BULL_POS;
import static model.model.getLevel;
import static view.gui.gameWindowCreator;

/**
 *
 * @author Kuba
 */
public class gui{
    
    private static JButton play;
    private static JButton exit;
    private static JFrame menuWindow;
    private static JFrame gameWindow;
    private static JPanel canvas;

   
    


    public static JPanel getCanvas() {
        return canvas;
    }     
    public static JFrame getFrame() {
        return menuWindow;
    } 
    public static JButton getPlay() {
        return play;
    }
    public static JButton getExit() {
        return exit;
    }
    public static JFrame getGameWindow() {
        return gameWindow;
    }    
        
    public static void menuWindowCreator() throws Exception{
        //ta klasa jest potrzebne do pobierania obrazków
        Class<gui> klas = gui.class;
        Icon icon = new ImageIcon(klas.getResource("images/torreadorPlaque.png"));
       //Creating the Frame
        menuWindow = new JFrame("TorreadorGame");
        menuWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        menuWindow.setFocusable(true);
        menuWindow.setSize(400,400);
        menuWindow.setLocationRelativeTo(null);
        menuWindow.setResizable(false);
        
        //Creating the panel at bottom and adding components
        JPanel exitPanel = new JPanel();
        JPanel playPanel=new JPanel();  // the panel is not visible in output
        JLabel banner = new JLabel(icon);
        play = new JButton("PLAY");
        exit = new JButton("EXIT");
        play.setPreferredSize(new Dimension(200,100));
        exit.setPreferredSize(new Dimension(200,50));
        playPanel.setBackground(Color.green);
        exitPanel.setBackground(Color.red);
        playPanel.add(play); // Components Added using Flow Layout
        exitPanel.add(exit); // Components Added using Flow Layout  
        
        //Adding Components to the frame.
        menuWindow.getContentPane().add(BorderLayout.CENTER, playPanel);
        menuWindow.getContentPane().add(BorderLayout.SOUTH, exitPanel);
        menuWindow.getContentPane().add(BorderLayout.NORTH, banner);
        menuWindow.setVisible(true);
            
        menuControl control = new menuControl();
        play.addActionListener(control);
        exit.addActionListener(control);

        sound.music(1);
    }
    
    public static void gameWindowCreator() throws Exception {

        
        gameWindow = new JFrame("TorreadorGame");      
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        gameWindow.setSize(1000,700);
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setResizable(false);
        gameWindow.setFocusable(true);
        
        canvas = new JPanel(); 
        //gameWindow.add(canvas);
        gameWindow.setVisible(true);
        
        //gameThread();
    }


  //komunikaty  
    public static void youLost()  {
        //drawingGraphics.test()
        
        JFrame l = new JFrame("Lost");
        JOptionPane.showMessageDialog(l, "You lost");
    }
    
    public static void youWon()  {
        
        JFrame l = new JFrame("Won");
        JOptionPane.showMessageDialog(l, "The Winner takes it all!!!");
    }   
}




    

