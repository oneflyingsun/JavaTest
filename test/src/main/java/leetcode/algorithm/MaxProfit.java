package leetcode.algorithm;

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
 * @date 2019-07-29
 * @description:
 */
public class MaxProfit {

  public static void main(String[] args) {
    int[] prices = {7, 1, 2, 3, 6, 4};
    System.out.println(maxProfit(prices));
  }

  public static int maxProfit(int[] prices) {
    int maxProfit = 0;
    if (prices.length < 2) {
      return 0;
    }
    for (int i = 0; i < prices.length; i++) {
      int j = findMaxSub(i, prices);
      maxProfit += prices[j] - prices[i];
      System.out.println("maxProfit:" + maxProfit + " i:" + i + " j:" + j);
      i = j;
    }
    return maxProfit;
  }

  /**
   * 寻找从index开始的最长升序的下标，如(3,[1,2,3,2,5,6,7])返回7的下标，(0,[1,2,3,2,5,6,7])返回3的下标。
   */
  public static int findMaxSub(int index, int[] list) {
    if (list.length < 2) {
      return index;
    }
    for (int i = index; i < list.length - 1;) {
      if (list[i + 1] > list[i]) {
        index = ++i;
      } else {
        return index;
      }

    }
    return index;
  }
}
