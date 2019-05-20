/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static view.gui.getExit;
import static view.gui.getPlay;
/**
 *
 * @author Kuba
 */
/**klasa odpowiedzialna za obsługę menu*/
public class menuControl implements ActionListener {
    /**listener przycisków menu*/
    public void actionPerformed(ActionEvent event){
           
        if(event.getSource()==getExit()){
            model.GeneralLogics.buttonAction("exit");            
        }          
        else if(event.getSource()==getPlay()){
            model.GeneralLogics.buttonAction("play");
        }
    }
}
