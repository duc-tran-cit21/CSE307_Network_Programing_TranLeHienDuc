package eiu.cit.netprog;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.SourceDataLine;

public class DownloadAndPlay implements LineListener {
  public static void main(String[] args) {
    try {
      URL url = new URL("https://www.tanbinhtech.com:8443/sample10.wav");
      InputStream in = url.openStream();
      BufferedInputStream bis = new BufferedInputStream(in);
      ///////////////////
      AudioInputStream audioStream = AudioSystem.getAudioInputStream(bis);
      AudioFormat audioFormat = audioStream.getFormat();
      DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
      SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
      sourceDataLine.open(audioFormat);
      sourceDataLine.start();
      ///////////////////
      final int BUFFER_SIZE = 4096;
      byte[] bufferBytes = new byte[BUFFER_SIZE];
      int readBytes = -1;
      while ((readBytes = audioStream.read(bufferBytes)) != -1) {
        sourceDataLine.write(bufferBytes, 0, readBytes);
      }
      sourceDataLine.drain();
      sourceDataLine.close();
      audioStream.close();

    } catch (Exception e) {
      // TODO: handle exception
    }

  }

  boolean isPlaybackCompleted;

  @Override
  public void update(LineEvent event) {
    if (LineEvent.Type.START == event.getType()) {
      System.out.println("Playback started.");
    } else if (LineEvent.Type.STOP == event.getType()) {
      isPlaybackCompleted = true;
      System.out.println("Playback completed.");
    }
  }

}
