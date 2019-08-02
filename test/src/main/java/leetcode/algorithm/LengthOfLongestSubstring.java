package leetcode.algorithm;

import java.util.HashSet;
import java.util.Set;

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
 * @date 2019-07-25
 * @description:
 */
public class LengthOfLongestSubstring {

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("fu"));
  }

  public static int lengthOfLongestSubstring(String s) {
    int n=s.length();
    if(n==0){
      return 0;
    }
    Set dictionary = new HashSet();
    int maxLenthTemp = 0;
    int maxLenthFinal = 0;
    /**
     * 遍历
     */
    for (int i = 0; i < n; i++) {
      maxLenthFinal = Math.max(maxLenthFinal, maxLenthTemp);
      dictionary = new HashSet();
      maxLenthTemp = 0;
//      System.out.println(maxLenthFinal   " + maxLenthTemp);
      for (int j = i; j < n; j++) {
        if (dictionary.contains(s.charAt(j))) {
          break;
        } else {
          dictionary.add(s.charAt(j));
          maxLenthTemp++;
        }
      }
    }
    return Math.max(maxLenthFinal, maxLenthTemp);
  }
}
