package javaCode.collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

  //static AtomicInteger j=new AtomicInteger(0);
  static int j = 0;

  public static void unsafeConcurrentUpdate() {
    final Map<Integer, Integer> map = new ConcurrentHashMap<>();

    for (int i = 0; i < 100; i++) {
      Thread t = new Thread() {

        @Override
        public void run() {
          for (int i = 0; i < 100; i++) {
            //   map.put(j.incrementAndGet(), 1);
            map.put(j++, i);
            System.out.println(j + "===" + i);
          }
        }
      };
      t.start();
    }
  }

  public static void main(String args[]) {
    unsafeConcurrentUpdate();
    System.out.println("++");
  }
}
