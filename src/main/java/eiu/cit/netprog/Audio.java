package eiu.cit.netprog;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;

import javazoom.jl.player.Player;

public class Audio {
  public static void main(String[] args) {
    try {
      URL url = new URL("http://ice10.outlaw.fm/KIEV2");
      InputStream in = url.openStream();
      BufferedInputStream bis = new BufferedInputStream(in);
      Player mp3Player = new Player(bis);
      mp3Player.play();
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

}
