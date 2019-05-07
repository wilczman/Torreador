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

    import view.*;
    import static model.gameThreadClass.gameThread;
    import static model.gameThreadClass.playGameThread;
    import static view.gui.*;
/**klasa odpowiedzialna za logikę rozgrywki*/
public class logics {
    public static final int TORREADOR_POS_X = 102;
    public static final int TORREADOR_POS_Y = 103+370;
    public static final int TORREADOR_AFTER_MOVE_POS_Y = TORREADOR_POS_Y-20;
    public static final int TORREADOR_DEAD_POS_X = TORREADOR_POS_X-50;
    public static final int TORREADOR_DEAD_POS_Y = TORREADOR_POS_Y+30;
    public static final int TORREADOR_DEAD_POS_AFTER_MOVE_Y = TORREADOR_DEAD_POS_Y+30;
    public static final int LINE_POS_X = 193;
    public static final int LINE_POS_Y = 520;
    public static final int BULL_POS_X = 800;
    public static final int BULL_POS_Y = 485;
    public static final int BULL_POS_AFTER_MOVE_X = 800;
    public static final int BULL_POS_AFTER_MOVE_Y = 455;
    
    
    public static final int TORREADOR_EDGE = TORREADOR_POS_X+23;
    public static final int LINE_EDGE = LINE_POS_X+4;
    public static final int BULL_DEFAULT_SPEED = 15;
    public static final int FRAMERATE = 24;

    /**zmienna oznaczająca osiągnięty poziom */
    private static int level=0;
    private static int bullRunFurther=0; //czy byk ma sie zatrzymac czy biec dalej
    private static int ifClicked=0;
    
    public static drawingGraphics mainViewCopy=null;
    public static int bullSpeed=BULL_DEFAULT_SPEED+5*level;
    public static int actual_bull_pos=BULL_POS_X;

    public static int getIfClicked() {
        return ifClicked;
    }

    public static void setIfClicked(int ifClicked) {
        logics.ifClicked = ifClicked;
    }

    public static int getBullRunFurther() {
        return bullRunFurther;
    }

    public static void setBullRunFurther(int bullStop) {
        logics.bullRunFurther = bullStop;
    }
    
    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        logics.level = level;
    }
    /**woła funkcję start*/
    public static void main(String[] args) throws Exception {
        start(); 
    }
    /** drukuje komunikat o rozpoczęciu programu, 
     * woła funkcję ładującą pliki dźwiękowe,
     * woła funkcje ładującą pliki graficzne,
     * woła funkcję tworzącą okno menu
     */
    public static void start() throws Exception {   
        
        System.out.println("Running");
        sound.loadSounds();
        view.resources.loadResources();
        gui.menuWindowCreator();
    }
    /** restartuje rozgrywkę */
    public static void restart() { 
          
        gameThreadClass.timer.stop();
        gameThread.stop();
        bullSpeed=BULL_DEFAULT_SPEED+5*level;
        bullRunFurther=0;
        actual_bull_pos=BULL_POS_X;
        ifClicked=0;
        gameThreadClass.gcontrol.setClickedFlag(0);
        
        getGameWindow().remove(mainViewCopy);
        //resseting audio tracks
        sound.getClip()[1].stop();
        sound.getClip()[1].setMicrosecondPosition(0);
        sound.getClip()[2].stop();
        sound.getClip()[2].setMicrosecondPosition(0);
        
        playGameThread();   
    } 
    /** woła funkcje wyświetlającą komunikat o przegranej i zeruje poziom */
    public static void lost(){
        gui.youLost();
        level=0;        
    }
    /** woła funkcje wyświetlającą komunikat o wygranej i zwiększa poziom */
    public static void won() {
        level+=1;
        gui.youWon();
    }
}
