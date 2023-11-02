package eiu.cit.netprog;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class DownPlay {
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

  }

}
