/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.logging.Level;
import java.util.logging.Logger;
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
            DISPOSEGAMEWINDOW=5;
    
    public static void communicateWithView(int command) {
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
              
        else{
            JFrame l = new JFrame("Lost");
            JOptionPane.showMessageDialog(l,"error during communication");
        }
            
    }
}
