/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
    import java.util.*;
    import java.awt.*;
    import java.lang.*;
    import static java.util.Arrays.copyOf;
    import javax.swing.*; 
    import controller.*;
    import model.*;

    import java.net.URL;
    import javax.swing.*;
    import javax.sound.sampled.*;
    import java.awt.Graphics;
    import java.applet.Applet;
    import java.awt.GridLayout;
    import java.awt.image.BufferedImage;
    import java.io.File;
    import java.io.IOException;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import javax.imageio.ImageIO;
    import java.util.concurrent.TimeUnit;
import java.util.Timer;
import static model.model.ACTUAL_BULL_POS;
import static model.model.BULL_POS;
import static model.model.LINE_POS;
import static model.model.TORREADOR_EDGE;
import static model.model.TORREADOR_POS;
import view.resources;

/**
 *
 * @author Kuba
 */
public class drawingGraphics  extends JLabel  {
    private int level;
    private int iterations;
    private Graphics g = getGraphics();

    public int getIterations() {
        return iterations;
    }
    public drawingGraphics(int arg,int i){
        level=arg;
        iterations=i;
    }


   
    public void update(Graphics g){
        paint(g);
    }
    public void paint(Graphics g)  {
            //animacje

            ACTUAL_BULL_POS=BULL_POS-iterations*model.bullSpeed;

            g.drawImage(resources.background, 0, 0, this);
            g.drawImage(resources.line, LINE_POS, 150+370,this);
            
            if(ACTUAL_BULL_POS<=TORREADOR_EDGE && model.getBullRunFurther()==0 &&  model.getIfClicked()!=1){
                g.drawImage(resources.dead, TORREADOR_POS-50, 103+370+60, this);
            }
            else if(ACTUAL_BULL_POS<=TORREADOR_EDGE && model.getBullRunFurther()==0 && model.getIfClicked()==1){
                g.drawImage(resources.dead, TORREADOR_POS-50, 103+370+30, this);
            }
            else if(model.getIfClicked()==1){
                g.drawImage(resources.move, TORREADOR_POS, 103+370-20, this);
            }
            else{
                g.drawImage(resources.torreador, TORREADOR_POS, 103+370, this);    
            }
            
            if(model.getIfClicked()==1 && model.getBullRunFurther()==0){
                if(iterations%12>=1 && iterations%12<4) g.drawImage(resources.bull1, ACTUAL_BULL_POS , 115+340, this);
                else if(iterations%12>=5 && iterations%12<8) g.drawImage(resources.bull2, ACTUAL_BULL_POS , 115+340, this);
                else g.drawImage(resources.bull3, ACTUAL_BULL_POS , 115+340, this);
            }
            else{
                if(iterations%12>=1 && iterations%12<4) g.drawImage(resources.bull1, ACTUAL_BULL_POS , 115+370, this);
                else if(iterations%12>=5 && iterations%12<8) g.drawImage(resources.bull2, ACTUAL_BULL_POS , 115+370, this);
                else g.drawImage(resources.bull3, ACTUAL_BULL_POS , 115+370, this);
            }
            
            g.drawString("Level: "+model.getLevel(),70,20); 
            g.drawString("SPACE-jump",870,20);
            g.drawString("R-restart",870,40);
            g.drawString("ESC-exit",870,60);
            g.drawString("M-mute",870,80);   
    }

}

