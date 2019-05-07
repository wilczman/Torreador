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
/**klasa odpowiedzialna za stworzenie oddzielnego wątku dla rozgrywki*/
public class gameThreadClass {
    
    public static Thread gameThread;
    public static gameControl gcontrol=null;
    public static Timer timer = null;
    public static screenControl control = null;
    
    /**tworzy obiekt klasy gameListener i dodaje keyListenera*/
    public static void createGameListener(){
       gcontrol = new gameControl();
       getGameWindow().addKeyListener(gcontrol);
       control = new screenControl();
    }
    /**tworzy wątek rozgrywki, a w nim używa timera, odtwarza muzykę, startuje wątek*/
    public static void playGameThread(){

        sound.playSound(2);
        sound.playSound(3);
        timer = new Timer((int)(1000/logics.FRAMERATE), control);
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
