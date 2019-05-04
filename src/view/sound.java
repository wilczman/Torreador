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
public class sound {
    
    private static Clip clip[]={null,null,null,null,null,null};
    private static AudioInputStream ais[]={null,null,null,null,null,null};
    
    public static final String path1 = "audio/sound3.wav";
    public static final String path2 = "audio/bullSounds.wav";
    public static final String path3 = "audio/crowd.wav";
    
    public static Clip[] getClip() {
        return clip;
    }  
    
    public static void getSounds() throws Exception {
        
        URL url[] ={gui.class.getResource(path1),
                    gui.class.getResource(path2),
                    gui.class.getResource(path3)
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
    
    public static void music(int number) throws Exception {
        clip[number-1].loop(Clip.LOOP_CONTINUOUSLY);        
    }
}
