/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
    import javax.swing.*; 
    import java.awt.Graphics;
    import static model.logics.*;

/**
 *
 * @author Kuba
 */

/**
 * zbiór metod i zmiennych odpowiedzialnych za rysowanie grafiki i animacji podczas gry
 */
public class drawingGraphics  extends JLabel  {
    private int iterations;
    private Graphics g = getGraphics();

    public int getIterations() {
        return iterations;
    }
    /**konstruktor klasy, przypisuje zmienną iteracyjną potrzebną do animacji*/
    public drawingGraphics(int i){

        iterations=i;
    }
   
    public void update(Graphics g){
        paint(g);
    }
    public void paint(Graphics g)  {
        //tło i linia
        g.drawImage(resources.background, 0, 0, this);
        g.drawImage(resources.line, LINE_POS_X, LINE_POS_Y,this);
        //martwy torreador, nie uskoczył    
        if(actual_bull_pos<=TORREADOR_EDGE && model.logics.getBullRunFurther()==0 &&  model.logics.getIfClicked()==0)
            g.drawImage(resources.dead, TORREADOR_DEAD_POS_X, TORREADOR_DEAD_POS_AFTER_MOVE_Y, this);
        //martwy torreador, uskoczył 
        else if(actual_bull_pos<=TORREADOR_EDGE && model.logics.getBullRunFurther()==0 && model.logics.getIfClicked()==1)
            g.drawImage(resources.dead, TORREADOR_DEAD_POS_X, TORREADOR_DEAD_POS_Y, this);
        //żywy torreador, uskoczył
        else if(model.logics.getIfClicked()==1)
            g.drawImage(resources.move, TORREADOR_POS_X, TORREADOR_AFTER_MOVE_POS_Y, this);
        //żywy torreador, nie uskoczył
        else
            g.drawImage(resources.torreador, TORREADOR_POS_X, TORREADOR_POS_Y, this);    
        
        //animacja biegu byka górą    
        if(model.logics.getIfClicked()==1 && model.logics.getBullRunFurther()==0){
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
        g.drawString("Level: "+model.logics.getLevel(),70,20); 
        g.drawString("SPACE-jump",870,20);
        g.drawString("R-restart",870,40);
        g.drawString("ESC-exit",870,60);
        g.drawString("M-mute",870,80);   
    }

}

