package Modelo;

import javax.sound.sampled.*;

public class AudioPlayer {

    private Clip clip;

    public void playAudio(String filename) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(filename));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            /*
            // Obtener el control de volumen
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            // Bajar el volumen en decibelios (-10dB)
            gainControl.setValue(-10.0f); 
            */
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void stopAudio() {
        clip.stop();
    }
}