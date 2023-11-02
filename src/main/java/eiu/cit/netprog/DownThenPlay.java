package eiu.cit.netprog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class DownThenPlay {
  public static void main(String[] args) {
    try {
      URL url = new URL("https://www.tanbinhtech.com:8443/sample1.wav");
      InputStream in = url.openStream();
      FileOutputStream fos = new FileOutputStream("D:\\CSE306\\lab_exercise_uri_and_url\\src\\main\\java\\eiu\\cit\\n" + //
          "etprog\\sample1.wav");

      int temp;
      while ((temp = in.read()) != -1) {
        fos.write(temp);
      }
      fos.close();
    } catch (Exception ex) {
      System.out.println(ex);
    }
    /////////////// Play Audio///////////////
    try {
      File soundFile = new File("D:\\CSE306\\lab_exercise_uri_and_url\\src\\main\\java\\eiu\\cit\\n" + //
          "etprog\\sample1.wav");
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
