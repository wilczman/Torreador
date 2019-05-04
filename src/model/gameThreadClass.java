/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.gameControl;
import controller.screenControl;
import javax.swing.Timer;
import static view.gui.getGameWindow;
import view.sound;

/**
 *
 * @author Kuba
 */
public class gameThreadClass {
    //public static  screenControl control=null;
    public static Thread gameThread;
    
    public static gameControl gcontrol=null;
    public static Timer timer = null;
    public static screenControl control = null;
    
    public static void starterPack(){
       gcontrol = new gameControl();
       getGameWindow().addKeyListener(gcontrol);
       control = new screenControl();
    }
    
    public static void playGameThread() throws Exception {

        sound.music(2);
        sound.music(3);
        control.screenControl();
        timer = new Timer((int)(1000/model.FRAMERATE), control);
        gameThread = new Thread(){
            public void run(){
                control.setI(0);
                timer.start(); 
                //return;
            }
        }; 
        gameThread.start();
    }
}
