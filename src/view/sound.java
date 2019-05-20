/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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

     /** odtwarza dźwięk*/
    protected static void playSound(int number){
            resources.getClip()[number-1].stop();
            resources.getClip()[number-1].setMicrosecondPosition(0);
        resources.getClip()[number-1].loop(Clip.LOOP_CONTINUOUSLY);     
    }
    protected static void stopSound(int number){
        resources.getClip()[number].stop();
        resources.getClip()[number].setMicrosecondPosition(0);        
    }
    
    
}
