package nio;// $Id$

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadAndShow {

  static public void main(String args[]) throws Exception {
    FileInputStream fin = new FileInputStream("/Users/zhaocong/Work/Project/JavaTest/test/src/main/java/nio/readandshow.txt");
    FileChannel fc = fin.getChannel();

    ByteBuffer buffer = ByteBuffer.allocate(1024);

    fc.read(buffer);

    buffer.flip();

    int i = 0;
    while (buffer.remaining() > 0) {
      byte b = buffer.get();
      System.out.println("Character " + i + ": " + ((char) b));
      i++;
    }

    fin.close();
  }
}
