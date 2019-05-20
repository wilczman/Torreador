/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.Timer;

import controller.gameControl;
import static view.gui.getGameWindow;

/**
 *
 * @author Kuba
 */
/**klasa odpowiedzialna za stworzenie oddzielnego wątku dla rozgrywki*/
public class gameThreadClass {
    
    protected static Thread gameThread;
    protected static gameControl gcontrol=null;
    protected static Timer timer = null;
    protected static screenLogics control = null;
    
    /**tworzy obiekt klasy gameListener i dodaje keyListenera*/
    protected static void createGameListener(){
       gcontrol = new gameControl();
       getGameWindow().addKeyListener(gcontrol);
       control = new screenLogics();
    }
    /**tworzy wątek rozgrywki, a w nim używa timera, odtwarza muzykę, startuje wątek*/
    protected static void playGameThread(){

        model.GeneralLogics.musicLogics("start", 2);
        model.GeneralLogics.musicLogics("start", 3);
        timer = new Timer((int)(1000/GeneralLogics.FRAMERATE), control);
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
