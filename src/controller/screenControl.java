/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.Timer;
import model.gameThreadClass;
import static model.gameThreadClass.gcontrol;
import static model.model.ACTUAL_BULL_POS;
import static model.model.TORREADOR_EDGE;
import static model.model.getLevel;
import view.drawingGraphics;
import view.gui;
import static view.gui.getExit;
import static view.gui.getFrame;
import static view.gui.getPlay;
import static view.gui.gameWindowCreator;

/**
 *
 * @author kuba
 */
public class screenControl extends view.gui implements ActionListener {
    
    private int i=0;
    private drawingGraphics mainView=new drawingGraphics(getLevel(),i);
    
    public void screenControl(){
        i=0;
        mainView=new drawingGraphics(getLevel(),i);
    }
    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }
    
    
    public void actionPerformed(ActionEvent event){
     
                getGameWindow().remove(mainView);
                
                mainView=new drawingGraphics(getLevel(),i);
                model.model.mainViewCopy=mainView;
                
                getGameWindow().getContentPane().add(mainView); 
                getGameWindow().getContentPane().revalidate();
                i=i+1;
                
                //bull is outta arena 
                if(ACTUAL_BULL_POS<-100) {
                   gameThreadClass.timer.stop();
                }
                //else if(ACTUAL_BULL_POS<-100 && model.model.getBullStop()==1)
                    
                //if you were too late
                else if(ACTUAL_BULL_POS<=TORREADOR_EDGE && model.model.getBullRunFurther()==0){
                   gameThreadClass.timer.stop();
                   model.model.lost(); 
                                        
                }
                //System.out.println("spacja: " + model.model.getIfClicked()+" użycie przycisku: "+ gcontrol.getClickedFlag()+" pzycja byka: "+ ACTUAL_BULL_POS);
              
    }
    public void screenClear(){
        getGameWindow().remove(mainView);
    }
    
}
    

