/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

    import java.net.URL;
    import javax.sound.sampled.AudioInputStream;
    import javax.sound.sampled.AudioSystem;
    import javax.sound.sampled.Clip;

/**
 *
 * @author Kuba
 */

/** 
 * klasa zawierająca załadowane pliki
 * dźwiękowe oraz metody do obsługi dźwięku
 */
public class sound {
    
    private static Clip clip[]={null,null,null,null,null,null};
    private static AudioInputStream ais[]={null,null,null,null,null,null};
    
    public static final String AUDIO_PATH_MUSIC = "audio/sound3.wav";
    public static final String AUDIO_PATH_BULL_SOUNDS = "audio/bullSounds.wav";
    public static final String AUDIO_PATH_CROWD_SOUNDS = "audio/crowd.wav";
    
    public static Clip[] getClip() {
        return clip;
    }  
    /** pobiera pliki dźwiękowe i przypisuje je zmiennym*/
    public static void loadSounds() throws Exception {
        
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
     /** odtwarza dźwięk*/
    public static void playSound(int number) {
        clip[number-1].loop(Clip.LOOP_CONTINUOUSLY);        
    }
}
