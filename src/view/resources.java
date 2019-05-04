/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author Kuba
 */
public class resources {
    
    public static final String plaquePath = "images/1.png";
    public static final String bullPath1 = "images/bullStanding.png";
    public static final String bullPath2 = "images/bullMoving1.png";
    public static final String bullPath3 = "images/bullMoving2.png";
    public static final String torreadorPath = "images/torreador.png";
    public static final String backgroundPath = "images/arenav2.png";
    public static final String linePath = "images/line.png";
    public static final String deadPath = "images/dead.png";
    public static final String movePath = "images/move.png";
    
    
    public static final URL plaqueUrl = drawingGraphics.class.getResource(plaquePath);
    public static final URL bull1Url = drawingGraphics.class.getResource(bullPath1);
    public static final URL bull2Url = drawingGraphics.class.getResource(bullPath2);
    public static final URL bull3Url = drawingGraphics.class.getResource(bullPath3);
    public static final URL torreadorUrl = drawingGraphics.class.getResource(torreadorPath);
    public static final URL backgroundUrl = drawingGraphics.class.getResource(backgroundPath);
    public static final URL lineUrl = drawingGraphics.class.getResource(linePath);
    public static final URL deadUrl = drawingGraphics.class.getResource(deadPath);
    public static final URL moveUrl = drawingGraphics.class.getResource(movePath);        
    
    public static BufferedImage plaque;
    public static BufferedImage bull1;
    public static BufferedImage bull2;
    public static BufferedImage bull3;
    public static BufferedImage torreador;
    public static BufferedImage background;
    public static BufferedImage line;
    public static BufferedImage dead;
    public static BufferedImage move;
    
    public static void setResources() throws Exception{
        plaque = ImageIO.read(plaqueUrl);
        bull1 = ImageIO.read(bull1Url);
        bull2 = ImageIO.read(bull2Url);
        bull3 = ImageIO.read(bull3Url);
        torreador = ImageIO.read(torreadorUrl);
        background = ImageIO.read(backgroundUrl);
        line = ImageIO.read(lineUrl);
        dead = ImageIO.read(deadUrl);
        move = ImageIO.read(moveUrl);
    }
}
