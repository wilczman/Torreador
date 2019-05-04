/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import model.gameThreadClass;
import static model.gameThreadClass.playGameThread;
import view.gui;


/**
 *
 * @author Kuba
 */
public class menuControl extends view.gui implements ActionListener {
    
    public void actionPerformed(ActionEvent event){
                String string ="";
           
                if(event.getSource()==getExit()){
                    string=String.format("ActionCommand: %s", event.getActionCommand());
                    System.exit(0);
                }          
                else if(event.getSource()==getPlay()){
                    string=String.format("ActionCommand: %s", event.getActionCommand());     
                    try {
                        gameWindowCreator();
                        gameThreadClass.starterPack();
                        playGameThread();
                    }  
                    catch (Exception ex) {Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);}   
                    getFrame().dispose();
                }
                //JOptionPane.showMessageDialog(null, string);
            }
}
