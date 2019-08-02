package leetcode.multiThread;

import java.util.concurrent.Semaphore;

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
public class ZeroEvenOdd {

  private int n;
  Semaphore s1, s2, s3, s4;

  public ZeroEvenOdd(int n) {
    this.n = n;
    s1 = new Semaphore(1);
    s2 = new Semaphore(0);
    s3 = new Semaphore(0);
    s4 = new Semaphore(1);
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void zero() throws InterruptedException {
    for (int i = 1; i <= n; i++) {
      s4.acquire();
      s1.acquire();
      System.out.println(0);
//      printNumber.accept(0);
      if ((i & 1) == 0) {
        s2.release();
      } else {
        s3.release();
      }
      s1.release();
    }
  }

  public void even() throws InterruptedException {
    for (int i = 2; i <= n ; i+=2) {
      s2.acquire();
      System.out.println("even数字: " + i);
//      printNumber.accept(i);
      s4.release();
    }

  }

  public void odd() throws InterruptedException {
    for (int i = 1; i <= n ; i+=2) {
      s3.acquire();
      System.out.println("odd数字：" + i);
//      printNumber.accept(i);
      s4.release();
    }
  }
}
