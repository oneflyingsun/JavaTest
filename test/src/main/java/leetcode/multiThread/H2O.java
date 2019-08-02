package leetcode.multiThread;

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
 * @date 2019-07-22
 * @description:
 */
import java.util.concurrent.*;
public class H2O {

  private Semaphore s1,s2,s3,s4;
  public H2O() {
    s1=new Semaphore(2);//H
    s2=new Semaphore(1);//O

    s3=new Semaphore(1);
    s4=new Semaphore(1);
  }

  public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

    // releaseHydrogen.run() outputs "H". Do not change or remove this line.

    s1.acquire();//两个H
    s4.acquire();//等待O
    s3.release();
    releaseHydrogen.run();
    s1.release();
  }

  public void oxygen(Runnable releaseOxygen) throws InterruptedException {

    // releaseOxygen.run() outputs "H". Do not change or remove this line.
    s2.acquire(1);//一个O
    s3.acquire();//等待H
    s4.release(2);
    releaseOxygen.run();
    s2.release();
  }
}