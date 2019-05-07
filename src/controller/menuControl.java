/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.gameThreadClass;
import static model.gameThreadClass.playGameThread;


/**
 *
 * @author Kuba
 */
/**klasa odpowiedzialna za obsługę menu*/
public class menuControl extends view.gui implements ActionListener {
    /**listener przycisków menu*/
    public void actionPerformed(ActionEvent event){
        String line ="";
           
        if(event.getSource()==getExit()){
            line=String.format("ActionCommand: %s", event.getActionCommand());
            System.exit(0);
        }          
        else if(event.getSource()==getPlay()){
            line=String.format("ActionCommand: %s", event.getActionCommand());     
            gameWindowCreator();
            gameThreadClass.createGameListener();
            playGameThread();            
            getFrame().dispose();
        }
    }
}
