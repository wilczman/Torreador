/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author kuba
 */
/**klasa odpowiedzialna za obsługę rysowania grafiki w oknie*/
public class screenLogics implements ActionListener {
    
    public static final int 
            SENDLOSTCOMMUNICATE=0,
            SENDWONCOMMUNICATE=1,
            OPENMENUWINDOWCREATOR=2,
            OPENGAMEWINDOWCREATOR=3,
            STOPSOUND=7,
            RETURNGAMEWINDOWOBJECT=8,
            RETURNMENUWINDOWOBJECT=9,
            DRAWING=10,
            DELETINGLAYER=11;
        
    private int i=0,torreadorVar=0,bullVar=0;
    //protected view.drawingGraphics mainView = new view.drawingGraphics(i,torreadorVar,bullVar,model.generalLogics.level,model.generalLogics.actual_bull_pos);

    protected void setI(int i) {
        this.i = i;
    }
    /** listener timera w którym wykonuje się rysowanie grafiki podczas 1 klatki działania programu*/
    public void actionPerformed(ActionEvent event){
     
        generalLogics.actual_bull_pos=generalLogics.BULL_POS_X-i*generalLogics.bullSpeed;
        if(generalLogics.actual_bull_pos<=generalLogics.TORREADOR_EDGE && model.generalLogics.getBullRunFurther()==0 &&  model.generalLogics.getIfClicked()==0)
            torreadorVar=1;
        else if(generalLogics.actual_bull_pos<=generalLogics.TORREADOR_EDGE && model.generalLogics.getBullRunFurther()==0 && model.generalLogics.getIfClicked()==1)
            torreadorVar=2;
        else if(model.generalLogics.getIfClicked()==1)
            torreadorVar=3;
        if (model.generalLogics.getIfClicked()==1 && model.generalLogics.getBullRunFurther()==0)    
            bullVar=1;
        
        view.viewCommunication.communicateWithView(DRAWING,i,torreadorVar,bullVar,model.generalLogics.level,model.generalLogics.actual_bull_pos);
        
        i=i+1;
                
        //stop drawing if bull is outta arena 
        if(generalLogics.actual_bull_pos<-100) {
            gameThreadClass.timer.stop();
        }                     
        //if you were too late stop drawing and activate lost phase
        else if(generalLogics.actual_bull_pos<=generalLogics.TORREADOR_EDGE && model.generalLogics.getBullRunFurther()==0){
            gameThreadClass.timer.stop();
            model.generalLogics.lost();                               
        }
        torreadorVar=0;
        bullVar=0;
    }       
}
    

