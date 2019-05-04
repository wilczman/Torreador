/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kuba
 */
package model;

    import java.util.*;
    import java.awt.*;
    import java.lang.*;
    import static java.util.Arrays.copyOf;
    import javax.swing.*; 
    import view.*;
    import controller.*;

    
    import java.net.URL;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import javax.swing.*;
    import javax.sound.sampled.*;
import static model.gameThreadClass.gameThread;
import static model.gameThreadClass.playGameThread;
    import static view.gui.*;

public class model {
    public static final int TORREADOR_POS=102;
    public static final int LINE_POS=173+20;
    public static final int BULL_POS=800;
    public static final int TORREADOR_EDGE=TORREADOR_POS+23;
    public static final int LINE_EDGE=LINE_POS+4;
    public static final int BULL_DEFAULT_SPEED=15;
    public static final int FRAMERATE=24;

    
    private static int level=0;
    private static int bullRunFurther=0; //czy byk ma sie zatrzymac czy biec dalej
    private static int ifClicked=0;
    
    public static drawingGraphics mainViewCopy=null;
    public static int bullSpeed=BULL_DEFAULT_SPEED+5*level;
    public static int ACTUAL_BULL_POS=BULL_POS;

    public static int getIfClicked() {
        return ifClicked;
    }

    public static void setIfClicked(int ifClicked) {
        model.ifClicked = ifClicked;
    }

    public static int getBullRunFurther() {
        return bullRunFurther;
    }

    public static void setBullRunFurther(int bullStop) {
        model.bullRunFurther = bullStop;
    }
    
    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        model.level = level;
    }
    
    public static void main(String[] args) throws Exception {
        start(); 
    }
    
    public static void start() throws Exception {   
        
        System.out.println("Running");
        sound.getSounds();
        view.resources.setResources();
        gui.menuWindowCreator();
        
    
    }
    
    public static void restart() throws Exception { 
        

        //gameThreadClass.control.screenClear();
        //gameThreadClass.control=null;        
        gameThreadClass.timer.stop();
        gameThread.stop();
        bullSpeed=BULL_DEFAULT_SPEED+5*level;
        bullRunFurther=0;
        ACTUAL_BULL_POS=BULL_POS;
        ifClicked=0;
        gameThreadClass.gcontrol.setClickedFlag(0);
        
        getGameWindow().remove(mainViewCopy);
        
        sound.getClip()[1].stop();
        sound.getClip()[1].setMicrosecondPosition(0);
        sound.getClip()[2].stop();
        sound.getClip()[2].setMicrosecondPosition(0);
        
        playGameThread();
        
    }
    
 
    public static void lost(){/*
        String pathScream = "audio/scream1.wav";  
        try {
            music(pathScream,4);
        } catch (Exception ex) {
            Logger.getLogger(model.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        gui.youLost();
        level=0;        
    }
    
    public static void won() throws Exception {
            level+=1;
            gui.youWon();
    }
}
