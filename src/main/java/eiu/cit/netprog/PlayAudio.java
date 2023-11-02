package eiu.cit.netprog;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlayAudio {
    public static void main(String[] args) {
        try {
            File soundFile = new File("D:\\CSE306\\lab_exercise_uri_and_url\\src\\main\\java\\eiu\\cit\\n" + //
                    "etprog\\song.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);
            

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
