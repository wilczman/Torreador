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
    import javax.sound.sampled.AudioInputStream;
    import javax.sound.sampled.AudioSystem;
    import javax.sound.sampled.Clip;

/**
 *
 * @author Kuba
 */

/** klasa zawierająca załadowane pliki graficzne*/
public class resources {
    
    //paths to files
    /**ścieżka grafiki byka*/
    public static final String BULL_PATH1 = "images/bullStanding.png";
    /**ścieżka grafiki byka*/
    public static final String BULL_PATH2 = "images/bullMoving1.png";
    /**ścieżka grafiki byka*/
    public static final String BULL_PATH3 = "images/bullMoving2.png";
    /**ścieżka grafiki toreadora*/
    public static final String TORREADOR_PATH = "images/torreador.png";
    /**ścieżka grafiki tła*/
    public static final String BACKGROUND_PATH = "images/arenav2.png";
    /**ścieżka grafiki linii*/
    public static final String LINE_PATH = "images/line.png";
    /**ścieżka grafiki martwego toreadora*/
    public static final String DEAD_PATH = "images/dead.png";
    /**ścieżka grafiki przesuniętego toreadora*/
    public static final String MOVE_PATH = "images/move.png";
     
    //making URLS from string paths
    
    /**adres URL grafiki byka*/
    public static final URL BULL1_URL = drawingGraphics.class.getResource(BULL_PATH1);
    /**adres URL grafiki byka*/
    public static final URL BULL2_URL = drawingGraphics.class.getResource(BULL_PATH2);
    /**adres URL grafiki byka*/
    public static final URL BULL3_URL = drawingGraphics.class.getResource(BULL_PATH3);
    /**adres URL grafiki toreadora*/
    public static final URL TORREADOR_URL = drawingGraphics.class.getResource(TORREADOR_PATH);
    /**adres URL grafiki tła*/
    public static final URL BACKGROUND_URL = drawingGraphics.class.getResource(BACKGROUND_PATH);
    /**adres URL grafiki linii*/
    public static final URL LINE_URL = drawingGraphics.class.getResource(LINE_PATH);
    /**adres URL grafiki martwego toreadora*/
    public static final URL DEAD_URL = drawingGraphics.class.getResource(DEAD_PATH);
    /**adres URL grafiki przesuniętego toreadora*/
    public static final URL MOVE_URL = drawingGraphics.class.getResource(MOVE_PATH);  
    
    public static final String AUDIO_PATH_MUSIC = "audio/sound3.wav";
    public static final String AUDIO_PATH_BULL_SOUNDS = "audio/bullSounds.wav";
    public static final String AUDIO_PATH_CROWD_SOUNDS = "audio/crowd.wav";  
    
    //declaring images variables
    /**animacja byka #1*/
    protected static BufferedImage bull1;
    /**animacja byka #2*/
    protected static BufferedImage bull2;
    /**animacja byka #3*/
    protected static BufferedImage bull3;
    /**grafika toreadora*/
    protected static BufferedImage torreador;
    /**grafika tła*/
    protected static BufferedImage background;
    /**grafika linii*/
    protected static BufferedImage line;
    /**grafika martwego toreadora*/
    protected static BufferedImage dead;
    /**grafika linii*/
    protected static BufferedImage move;
        
    protected static Clip clip[]={null,null,null,null,null,null};
    protected static AudioInputStream ais[]={null,null,null,null,null,null};
    
    protected static Clip[] getClip() {
        return clip;
    }  
    /** pobiera pliki dźwiękowe i przypisuje je zmiennym*/
    private static void loadSounds() throws Exception {
        
        URL url[] ={gui.class.getResource(AUDIO_PATH_MUSIC),
                    gui.class.getResource(AUDIO_PATH_BULL_SOUNDS),
                    gui.class.getResource(AUDIO_PATH_CROWD_SOUNDS)
        };    
        clip[0] = AudioSystem.getClip();
        clip[1] = AudioSystem.getClip();
        clip[2] = AudioSystem.getClip();
        
        // getAudioInputStream() also accepts a File or InputStream
        ais[0] = AudioSystem.getAudioInputStream(url[0]);
        ais[1] = AudioSystem.getAudioInputStream(url[1]);
        ais[2] = AudioSystem.getAudioInputStream(url[2]);
        clip[0].open(ais[0]);
        clip[1].open(ais[1]);
        clip[2].open(ais[2]);
    }
    /** 
     * funkcja pobiera obrazy z adresów url i przypisuje je zmiennym
     */
    private static void loadGraphics() throws Exception{
        bull1 = ImageIO.read(BULL1_URL);
        bull2 = ImageIO.read(BULL2_URL);
        bull3 = ImageIO.read(BULL3_URL);
        torreador = ImageIO.read(TORREADOR_URL);
        background = ImageIO.read(BACKGROUND_URL);
        line = ImageIO.read(LINE_URL);
        dead = ImageIO.read(DEAD_URL);
        move = ImageIO.read(MOVE_URL);
    }
    protected static void loadResources() throws Exception{
        loadSounds();
        loadGraphics();
    }
}
