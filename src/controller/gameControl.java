/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author kuba
 */
/**klasa odpowiedzialna za obsługę rozgrywki*/
public class gameControl implements KeyListener{    

    /**listener przycisków odpowiedzialnych za rozgrywke*/
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_SPACE) 
            model.GeneralLogics.keyboardAction("space");     
    }

    /**listener przycisków odpowiedzialnych za rozgrywke*/
    public void keyReleased(KeyEvent e) {
        
    if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
        model.GeneralLogics.keyboardAction("escape");
    }
    if (e.getKeyCode() == KeyEvent.VK_R) {
        model.GeneralLogics.keyboardAction("r");
    }
    if (e.getKeyCode() == KeyEvent.VK_M) {
        model.GeneralLogics.keyboardAction("m");  
    }
    if (e.getKeyCode()==KeyEvent.VK_P){
        model.GeneralLogics.keyboardAction("p");
    }
}
    /**listener przycisków odpowiedzialnych za rozgrywke*/
    public void keyTyped(KeyEvent e){}
}
