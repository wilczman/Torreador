/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.gameThreadClass;

import static model.logics.TORREADOR_EDGE;
import static model.logics.actual_bull_pos;
import static model.logics.getLevel;
import view.drawingGraphics;
import static model.logics.BULL_POS_X;

/**
 *
 * @author kuba
 */
/**klasa odpowiedzialna za obsługę rysowania grafiki w oknie*/
public class screenControl extends view.gui implements ActionListener {
    
    private int i=0;
    private drawingGraphics mainView=new drawingGraphics(i);
    
    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }
    /** listener timera w którym wykonuje się rysowanie grafiki podczas 1 klatki działania programu*/
    public void actionPerformed(ActionEvent event){
     
        getGameWindow().remove(mainView);
        actual_bull_pos=BULL_POS_X-i*model.logics.bullSpeed;        
        mainView=new drawingGraphics(i);
        model.logics.mainViewCopy=mainView;
                
        getGameWindow().getContentPane().add(mainView); 
        getGameWindow().getContentPane().revalidate();
        i=i+1;
                
        //stop drawing if bull is outta arena 
        if(actual_bull_pos<-100) {
            gameThreadClass.timer.stop();
        }                     
        //if you were too late stop drawing and activate lost phase
        else if(actual_bull_pos<=TORREADOR_EDGE && model.logics.getBullRunFurther()==0){
            gameThreadClass.timer.stop();
            model.logics.lost();                               
        }              
    }       
}
    

