package javaCode.singleton;

/**
 * @author zhaocong
 * @date 2019-07-31
 * @description:
 */
public class Singleton {

  private volatile static Singleton single;

  private Singleton() {
  }

  public static Singleton getSingle() {
    if (single == null) {
      synchronized (Singleton.class) {
        if (single == null) {
          single = new Singleton();
        }
      }
    }
    return single;
  }
}