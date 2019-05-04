/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.gameThreadClass;
import static model.gameThreadClass.gameThread;
import static model.model.*;
import view.gui;
import view.sound;

/**
 *
 * @author kuba
 */
public class gameControl extends view.gui implements KeyListener{
    private int clickedFlag=0;//żeby można było tylko raz kliknąć    

    public void setClickedFlag(int flag) {
        clickedFlag = flag;
    }
    public int getClickedFlag() {
        return clickedFlag;
    }


@Override
    public void keyPressed(KeyEvent e) {
        //too early
        if (e.getKeyCode()==KeyEvent.VK_SPACE&&clickedFlag!=1 && ACTUAL_BULL_POS>LINE_EDGE){
            System.out.println("EARLY GREY");
            clickedFlag=1;
            model.model.setIfClicked(1);
            //Thread.sleep(5000);
            //lost();
           // model.model.check();
        }
        //perfect
        else if(e.getKeyCode()==KeyEvent.VK_SPACE 
                &&clickedFlag!=1 
                && ACTUAL_BULL_POS<LINE_EDGE
                && ACTUAL_BULL_POS>TORREADOR_EDGE){
            clickedFlag=1;
            model.model.setBullRunFurther(1);
            model.model.setIfClicked(1);
            try {
                won();
                gameThreadClass.timer.stop();
                restart();
            } catch (Exception ex) {
                Logger.getLogger(gameControl.class.getName()).log(Level.SEVERE, null, ex);
              }
        }

    }

@Override
    public void keyReleased(KeyEvent e) {
        //spacedPressed = false;
        //System.out.println("Released");
    if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
        System.out.println("Programme exit (0)");
        System.exit(0);
    }
    if (e.getKeyCode() == KeyEvent.VK_R) {
        //System.out.println("Programme restarted");
        try { 
            model.model.setLevel(0);
            bullSpeed=BULL_DEFAULT_SPEED; 
            restart();
        }
        catch (Exception ex) { Logger.getLogger(gameControl.class.getName()).log(Level.SEVERE, null, ex);}    
    }
    if (e.getKeyCode() == KeyEvent.VK_M) {
        System.out.println("Muted");
        try {   
            sound.getClip()[0].stop();
        }
        catch (Exception ex) { Logger.getLogger(gameControl.class.getName()).log(Level.SEVERE, null, ex);}    
    }
    if (e.getKeyCode()==KeyEvent.VK_P){
        try {
            System.out.println("pause");
            gameThread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(gameControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     

}

@Override
    public void keyTyped(KeyEvent e){
        
            
    }
}
