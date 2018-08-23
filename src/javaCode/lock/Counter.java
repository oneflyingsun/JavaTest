package javaCode.lock;

import java.util.concurrent.CountDownLatch;

public class Counter {
    private static int count=0;
    static CountDownLatch countDownLatch=new CountDownLatch(100);
    synchronized public static int inc(){
      //  synchronized (this){
            return ++count;
      //  }
    }
    static public void main(String [] strgs) throws InterruptedException {
        for(int i=0;i<100;i++){
            Thread thread=new Thread(){
                @Override
                public void run() {
                    super.run();
                    inc();
                    System.out.println("count:"+count);
                    countDownLatch.countDown();

                }
            };
            thread.start();
        }
        countDownLatch.await();
        System.out.println("1最终count为："+count);
        System.out.println("2最终count为："+count);
        System.out.println("3最终count为："+count);
        System.out.println("4最终count为："+count);


    }
}
