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
            OPENGAMEWINDOWCREATOR=3;
        
    private int i=0,torreadorVar=0,bullVar=0;
    protected view.drawingGraphics mainView = new view.drawingGraphics(i,torreadorVar,bullVar,model.GeneralLogics.level,model.GeneralLogics.actual_bull_pos);

    protected void setI(int i) {
        this.i = i;
    }
    /** listener timera w którym wykonuje się rysowanie grafiki podczas 1 klatki działania programu*/
    public void actionPerformed(ActionEvent event){
     
        view.gui.getGameWindow().remove(mainView);
        GeneralLogics.actual_bull_pos=GeneralLogics.BULL_POS_X-i*GeneralLogics.bullSpeed;
        if(GeneralLogics.actual_bull_pos<=GeneralLogics.TORREADOR_EDGE && model.GeneralLogics.getBullRunFurther()==0 &&  model.GeneralLogics.getIfClicked()==0)
            torreadorVar=1;
        else if(GeneralLogics.actual_bull_pos<=GeneralLogics.TORREADOR_EDGE && model.GeneralLogics.getBullRunFurther()==0 && model.GeneralLogics.getIfClicked()==1)
            torreadorVar=2;
        else if(model.GeneralLogics.getIfClicked()==1)
            torreadorVar=3;
        if (model.GeneralLogics.getIfClicked()==1 && model.GeneralLogics.getBullRunFurther()==0)    
            bullVar=1;
        
        mainView=new view.drawingGraphics(i,torreadorVar,bullVar,model.GeneralLogics.level,model.GeneralLogics.actual_bull_pos);
        GeneralLogics.mainViewCopy=mainView;
                
        view.gui.getGameWindow().getContentPane().add(mainView); 
        view.gui.getGameWindow().getContentPane().revalidate();
        i=i+1;
                
        //stop drawing if bull is outta arena 
        if(GeneralLogics.actual_bull_pos<-100) {
            gameThreadClass.timer.stop();
        }                     
        //if you were too late stop drawing and activate lost phase
        else if(GeneralLogics.actual_bull_pos<=GeneralLogics.TORREADOR_EDGE && model.GeneralLogics.getBullRunFurther()==0){
            gameThreadClass.timer.stop();
            model.GeneralLogics.lost();                               
        }
        torreadorVar=0;
        bullVar=0;
    }       
}
    

