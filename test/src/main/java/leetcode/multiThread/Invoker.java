package leetcode.multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaocong
 * @ ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━龙妈保佑，永无BUG━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * @ -
 * @ -
 * @ -                                                    __----~~~~~~~~~~~------___
 * @ -                                   .  .   ~~//====......          __--~ ~~
 * @ -                   -.            \_|//     |||\\  ~~~~~~::::... /~
 * @ -                ___-==_       _-~o~  \/    |||  \\            _/~~-
 * @ -        __---~~~.==~||\=_    -_--~/_-~|-   |\\   \\        _/~
 * @ -    _-~~     .=~    |  \\-_    '-~7  /-   /  ||    \      /
 * @ -  .~       .~       |   \\ -_    /  /-   /   ||      \   /
 * @ - /  ____  /         |     \\ ~-_/  /|- _/   .||       \ /
 * @ - |~~    ~~|--~~~~--_ \     ~==-/   | \~--===~~        .\
 * @ -          '         ~-|      /|    |-~\~~       __--~~
 * @ -                      |-~~-_/ |    |   ~\_   _-~                /\
 * @ -      龙妈保佑                 /  \     \__   \/~                \__
 * @ -                       _--~ _/ | .-~~____--~-/                  ~~==.
 * @ -                      ((->/~   '.|||' -_|    ~~-/ ,              . _||
 * @ -                                 -_     ~\      ~~---l__i__i__i--~~_/
 * @ -                                 _-~-__   ~)  \--______________--~~
 * @ -                               //.-~~~-~_--~- |-------~~~~~~~~
 * @ -                                      //.-~~~--\
 * @ ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━龙妈保佑，永无BUG━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * @date 2019-07-23
 * @description:
 */
public class Invoker extends Thread {

  ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
  int i = 0;

  Invoker(ZeroEvenOdd zero, int num) {
    zeroEvenOdd = zero;
    i = num;
  }

  public static void main(String[] args) {
    ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
    ExecutorService pool = Executors.newFixedThreadPool(3);

    Thread t1 = new Invoker(zeroEvenOdd, 1);
    Thread t2 = new Invoker(zeroEvenOdd, 2);
    Thread t3 = new Invoker(zeroEvenOdd, 3);

    // 将线程放入池中进行执行
    pool.execute(t1);
    pool.execute(t3);
    pool.execute(t2);
    try {
      sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // 关{闭线程池
    pool.shutdown();
  }

  @Override
  public void run() {
    if (i == 1) {
      try {
        zeroEvenOdd.zero();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } else if (i == 2) {
      try {
        zeroEvenOdd.even();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } else if (i == 3) {
      try {
        zeroEvenOdd.odd();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }
}


