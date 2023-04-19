package Vista;

import javax.sound.sampled.*;

public class AudioPlayer {

    private Clip clip;

    public void playAudio(String filename) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(filename));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void stopAudio() {
        clip.stop();
    }
}