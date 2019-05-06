/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**zbiór klas związanych z GUI i dźwiękiem*/
package view;

    import java.awt.image.BufferedImage;
    import java.net.URL;
    import javax.imageio.ImageIO;

/**
 *
 * @author Kuba
 */

/** klasa zawierająca załadowane pliki graficzne*/
public class resources {
    
    //paths to files
    public static final String BULL_PATH1 = "images/bullStanding.png";
    public static final String BULL_PATH2 = "images/bullMoving1.png";
    public static final String BULL_PATH3 = "images/bullMoving2.png";
    public static final String TORREADOR_PATH = "images/torreador.png";
    public static final String BACKGROUND_PATH = "images/arenav2.png";
    public static final String LINE_PATH = "images/line.png";
    public static final String DEAD_PATH = "images/dead.png";
    public static final String MOVE_PATH = "images/move.png";
     
    //making URLS from string paths
    public static final URL BULL1_URL = drawingGraphics.class.getResource(BULL_PATH1);
    public static final URL BULL2_URL = drawingGraphics.class.getResource(BULL_PATH2);
    public static final URL BULL3_URL = drawingGraphics.class.getResource(BULL_PATH3);
    public static final URL TORREADOR_URL = drawingGraphics.class.getResource(TORREADOR_PATH);
    public static final URL BACKGROUND_URL = drawingGraphics.class.getResource(BACKGROUND_PATH);
    public static final URL LINE_URL = drawingGraphics.class.getResource(LINE_PATH);
    public static final URL DEAD_URL = drawingGraphics.class.getResource(DEAD_PATH);
    public static final URL MOVE_URL = drawingGraphics.class.getResource(MOVE_PATH);        
    
    //declaring images variables
    /**animacja byka #1*/
    public static BufferedImage bull1;
    /**animacja byka #2*/
    public static BufferedImage bull2;
    /**animacja byka #3*/
    public static BufferedImage bull3;
    /**grafika toreadora*/
    public static BufferedImage torreador;
    /**grafika tła*/
    public static BufferedImage background;
    /**grafika linii*/
    public static BufferedImage line;
    /**grafika martwego toreadora*/
    public static BufferedImage dead;
    /**grafika linii*/
    public static BufferedImage move;
    
    /** 
     * funkcja pobiera obrazy z adresów url i przypisuje je zmiennym
     */
    public static void loadResources() throws Exception{
        bull1 = ImageIO.read(BULL1_URL);
        bull2 = ImageIO.read(BULL2_URL);
        bull3 = ImageIO.read(BULL3_URL);
        torreador = ImageIO.read(TORREADOR_URL);
        background = ImageIO.read(BACKGROUND_URL);
        line = ImageIO.read(LINE_URL);
        dead = ImageIO.read(DEAD_URL);
        move = ImageIO.read(MOVE_URL);
    }
}
