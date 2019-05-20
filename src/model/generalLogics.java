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

    import static model.gameThreadClass.gameThread;
    import static model.gameThreadClass.playGameThread;

/**klasa odpowiedzialna za logikę rozgrywki, posiada stałe oznaczające pozycje elementów na ekranie*/

/**klasa odpowiedzialna za logikę rozgrywki*/
public class generalLogics {
    //stałe
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
    
    public static final int 
            SENDLOSTCOMMUNICATE=0,
            SENDWONCOMMUNICATE=1,
            OPENMENUWINDOWCREATOR=2,
            OPENGAMEWINDOWCREATOR=3,
            LOADRESOURCES=4,
            DISPOSEGAMEWINDOW=5,
            PLAYSOUND=6,
            STOPSOUND=7,
            RETURNGAMEWINDOWOBJECT=8,
            RETURNMENUWINDOWOBJECT=9,
            DRAWING=10,
            DELETINGLAYER=11;
    
    /**zmienna oznaczająca osiągnięty poziom */
    protected static int level=0;
    private static int bullRunFurther=0; //czy byk ma sie zatrzymac czy biec dalej
    private static int ifClicked=0;
    private static int clickedFlag=0;
    
    protected static int bullSpeed=BULL_DEFAULT_SPEED+5*level;
    protected static int actual_bull_pos=BULL_POS_X;

    protected static int getIfClicked() {
        return ifClicked;
    }
    
    protected static int getClickedFlag() {
        return clickedFlag;
    }

    protected static void setIfClicked(int ifClicked) {
        generalLogics.ifClicked = ifClicked;
    }

    protected static int getBullRunFurther() {
        return bullRunFurther;
    }

    protected static void setBullRunFurther(int bullStop) {
        generalLogics.bullRunFurther = bullStop;
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
    private static void start() throws Exception {   
        
        System.out.println("Running");
        view.viewCommunication.communicateWithView(LOADRESOURCES);
        view.viewCommunication.communicateWithView(OPENMENUWINDOWCREATOR);
    }
    /** restartuje rozgrywkę */
    private static void restart() { 
          
        gameThreadClass.timer.stop();
        gameThread.stop();
        bullSpeed=BULL_DEFAULT_SPEED+5*level;
        bullRunFurther=0;
        actual_bull_pos=BULL_POS_X;
        ifClicked=0;
        clickedFlag=0;
        view.viewCommunication.communicateWithView(DELETINGLAYER);
        //view.gui.getGameWindow().remove(mainViewCopy);
        //resseting audio tracks
        musicLogics("stop",1);
        musicLogics("stop",2);
        
        playGameThread();   
    } //TU FUNKCJE STATE ZROB
    /** woła funkcje wyświetlającą komunikat o przegranej i zeruje poziom */
    protected static void lost(){
        view.viewCommunication.communicateWithView(SENDLOSTCOMMUNICATE);
        level=0;        
    }
    /** woła funkcje wyświetlającą komunikat o wygranej i zwiększa poziom */
    protected static void won(){
        bullRunFurther=1;
        ifClicked=1;
        level+=1;
        view.viewCommunication.communicateWithView(SENDWONCOMMUNICATE);
        gameThreadClass.timer.stop();
        restart();
    }
    private static void playSequention(){
            view.viewCommunication.communicateWithView(OPENGAMEWINDOWCREATOR);
            gameThreadClass.createGameListener();
            playGameThread();            
            view.viewCommunication.communicateWithView(DISPOSEGAMEWINDOW);
    }
    private static void check(){
        //too early
        if(ifClicked==0 && actual_bull_pos>LINE_EDGE){
            ifClicked=1;
        }
        //perfect
        else if(ifClicked==0 && actual_bull_pos<LINE_EDGE  && actual_bull_pos>TORREADOR_EDGE){
            ifClicked=1;
            won();
        }
    }
    private static void restartSequention(){
        level=0;
        bullSpeed=BULL_DEFAULT_SPEED; 
        restart();
    }
    protected static void musicLogics(String command, int number){
        if ("start".equals(command))
            view.viewCommunication.communicateWithView(PLAYSOUND,number);
        
        else if ("stop".equals(command))
            view.viewCommunication.communicateWithView(STOPSOUND,number);
    }
    public static void keyboardAction(String key) {
        if (key.equals("r"))   
            restartSequention();
        else if ( key.equals("space"))
            check();
        else if (key.equals("m")){
            System.out.println("Muted");
            musicLogics("stop",0);  
        }
        else if (key.equals("escape")){
            System.out.println("Programme exit (0)");
            System.exit(0);
        }
        else if (key.equals("p")){
            try {
                System.out.println("pause");
                model.gameThreadClass.gameThread.sleep(8000);
            } 
            catch (InterruptedException ex) {
                System.out.println("Exception during pause");
            }
        }       
    }
    public static void buttonAction(String button) {
        if (button.equals("exit"))
            System.exit(0);            
        else if(button.equals("play")){
            playSequention();
        }
    }
    //public static void soundLogics()
}
