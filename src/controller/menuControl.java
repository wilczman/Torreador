/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Kuba
 */
/**klasa odpowiedzialna za obsługę menu*/
public class menuControl implements ActionListener {
    /**listener przycisków menu*/
    public static final int
            
        GETPLAYBUTTON=12,
        GETEXITBUTTON=13;
    
    public void actionPerformed(ActionEvent event){
           
        if(event.getSource()==view.viewCommunication.communicateWithView(GETEXITBUTTON,'p')){
            model.generalLogics.buttonAction("exit");            
        }          
        else if(event.getSource()==view.viewCommunication.communicateWithView(GETPLAYBUTTON,'p')){
            model.generalLogics.buttonAction("play");
        }
    }
}
