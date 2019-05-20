/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author kuba
 */
public class viewCommunication {
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
            DELETINGLAYER=11,
            GETPLAYBUTTON=12,
            GETEXITBUTTON=13;
    private static drawingGraphics copy;
    //private static int i=0,torreadorVar=0,bullVar=0;
    private static drawingGraphics mainView = new drawingGraphics(0,0,0,0,0);
    
    public static JFrame communicateWithView(int command) {
        if (command==SENDLOSTCOMMUNICATE){
            gui.youLost();
        }
        else if (command==SENDWONCOMMUNICATE){
            gui.youWon();
        }
        else if (command==OPENMENUWINDOWCREATOR){       
            gui.menuWindowCreator();
        }
        else if(command==OPENGAMEWINDOWCREATOR){
            gui.gameWindowCreator();
        }
        else if(command==LOADRESOURCES){
            try {
                resources.loadResources();
            } catch (Exception ex) {
                Logger.getLogger(viewCommunication.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(command==DISPOSEGAMEWINDOW){ 
            gui.getFrame().dispose();
        } 
        else if(command==PLAYSOUND){
        }
        else if(command==STOPSOUND){
        }
        else if(command==RETURNGAMEWINDOWOBJECT){
            return gui.getGameWindow();
        }
        else if(command==RETURNMENUWINDOWOBJECT){
            return gui.getFrame();
        }
        else if(command==DELETINGLAYER){
            gui.getGameWindow().remove(copy);
        }
        else{
            JFrame l = new JFrame("Lost");
            JOptionPane.showMessageDialog(l,"error during communication");
        }
        return null;
    }
    public static void communicateWithView(int command, int number) {
        if (command==PLAYSOUND){
            sound.playSound(number);
        }
        else if (command==STOPSOUND){
            sound.stopSound(number);
        }
        else{
            JFrame l = new JFrame("Lost");
            JOptionPane.showMessageDialog(l,"error during communication");
        }        
    }
    public static void communicateWithView(int command, int i,int torreadorVar,int bullVar,int level,int actual_bull_pos) {
        if(command==DRAWING){
            gui.getGameWindow().remove(mainView);
            mainView=new view.drawingGraphics(i,torreadorVar,bullVar,level,actual_bull_pos);
            copy=mainView;
            gui.getGameWindow().getContentPane().add(mainView); 
            gui.getGameWindow().getContentPane().revalidate();
        }
        else{
            JFrame l = new JFrame("Lost");
            JOptionPane.showMessageDialog(l,"error during communication");
            return;
        } 
    }
    public static JButton communicateWithView(int command,char p) {
        if(command==GETPLAYBUTTON){
            return gui.getPlay();
        }
        if(command==GETEXITBUTTON){
            return gui.getExit();
        }
        else{
            JFrame l = new JFrame("Lost");
            JOptionPane.showMessageDialog(l,"error during communication");
        }
        return null;
    }
}
