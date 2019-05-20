/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
    import javax.swing.*; 
    import java.awt.Graphics;

/**
 *
 * @author Kuba
 */

/**
 * zbiór metod i zmiennych odpowiedzialnych za rysowanie grafiki i animacji podczas gry
 */
public class drawingGraphics  extends JLabel  {
    //CONSTANTS
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
    
    /**przekazany numer iteracji z modułu control*/
    private int iterations=0,torreadorVar=0,bullVar=0,level=0,actual_bull_pos=0;
    /**Obiekt klasy Graphics posiadający metody do rysowania grafiki*/
    private Graphics g = getGraphics();

    /**konstruktor klasy, przypisuje zmienną iteracyjną potrzebną do animacji*/
    public drawingGraphics(int/**przekazany numer iteracji z modułu control*/ i,int torreadorVar,int bullVar,int level,int actual_bull_pos){
        iterations=i;
        this.torreadorVar=torreadorVar;
        this.bullVar=bullVar;
        this.level=level;
        this.actual_bull_pos=actual_bull_pos;
    } 
    public void update(Graphics g){
        paint(g);
    }
    public void paint(Graphics g)  {
        //tło i linia
        g.drawImage(resources.background, 0, 0, this);
        g.drawImage(resources.line, LINE_POS_X, LINE_POS_Y,this);
        //martwy torreador, nie uskoczył    
        if(torreadorVar==1)
            g.drawImage(resources.dead, TORREADOR_DEAD_POS_X, TORREADOR_DEAD_POS_AFTER_MOVE_Y, this);
        //martwy torreador, uskoczył 
        else if(torreadorVar==2)
            g.drawImage(resources.dead, TORREADOR_DEAD_POS_X, TORREADOR_DEAD_POS_Y, this);
        //żywy torreador, uskoczył
        else if(torreadorVar==3)
            g.drawImage(resources.move, TORREADOR_POS_X, TORREADOR_AFTER_MOVE_POS_Y, this);
        //żywy torreador, nie uskoczył
        else
            g.drawImage(resources.torreador, TORREADOR_POS_X, TORREADOR_POS_Y, this);    
        
        //animacja biegu byka górą    
        if(bullVar==1){
            if(iterations%12>=1 && iterations%12<4) 
                g.drawImage(resources.bull1, actual_bull_pos , BULL_POS_AFTER_MOVE_Y, this);
            
            else if(iterations%12>=5 && iterations%12<8) 
                g.drawImage(resources.bull2, actual_bull_pos , BULL_POS_AFTER_MOVE_Y, this);
            
            else 
                g.drawImage(resources.bull3, actual_bull_pos , BULL_POS_AFTER_MOVE_Y, this);            
        }
        //animacja biegu byka dołem   
        else{
            if(iterations%12>=1 && iterations%12<4) 
                g.drawImage(resources.bull1, actual_bull_pos , BULL_POS_Y, this);
            
            else if(iterations%12>=5 && iterations%12<8) 
                g.drawImage(resources.bull2, actual_bull_pos , BULL_POS_Y, this);
            
            else 
                g.drawImage(resources.bull3, actual_bull_pos , BULL_POS_Y, this);
        }
        //klawiszologia   
        g.drawString("Level: "+level,70,20); 
        g.drawString("SPACE-jump",870,20);
        g.drawString("R-restart",870,40);
        g.drawString("ESC-exit",870,60);
        g.drawString("M-mute",870,80);   
    }

}

