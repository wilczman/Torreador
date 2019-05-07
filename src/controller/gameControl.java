/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.gameThreadClass;
import static model.gameThreadClass.gameThread;
import static model.logics.*;
import view.sound;

/**
 *
 * @author kuba
 */
/**klasa odpowiedzialna za obsługę rozgrywki*/
public class gameControl extends view.gui implements KeyListener{
    private int clickedFlag=0;//żeby można było tylko raz kliknąć    

    public void setClickedFlag(int flag) {
        clickedFlag = flag;
    }
    public int getClickedFlag() {
        return clickedFlag;
    }


    /**listener przycisków odpowiedzialnych za rozgrywke*/
    public void keyPressed(KeyEvent e) {
        //too early
        if (e.getKeyCode()==KeyEvent.VK_SPACE&&clickedFlag!=1 && actual_bull_pos>LINE_EDGE){
            clickedFlag=1;
            model.logics.setIfClicked(1);
        }
        //perfect
        else if(e.getKeyCode()==KeyEvent.VK_SPACE 
                &&clickedFlag!=1 
                && actual_bull_pos<LINE_EDGE
                && actual_bull_pos>TORREADOR_EDGE){
            clickedFlag=1;
            model.logics.setBullRunFurther(1);
            model.logics.setIfClicked(1);
            try {
                won();
                gameThreadClass.timer.stop();
                restart();
            } catch (Exception ex) {
                Logger.getLogger(gameControl.class.getName()).log(Level.SEVERE, null, ex);
              }
        }

    }

    /**listener przycisków odpowiedzialnych za rozgrywke*/
    public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
        System.out.println("Programme exit (0)");
        System.exit(0);
    }
    if (e.getKeyCode() == KeyEvent.VK_R) {
        try { 
            model.logics.setLevel(0);
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
            gameThread.sleep(8000);
        } catch (InterruptedException ex) {
            Logger.getLogger(gameControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     

}

    /**listener przycisków odpowiedzialnych za rozgrywke*/
    public void keyTyped(KeyEvent e){
        
            
    }
}
