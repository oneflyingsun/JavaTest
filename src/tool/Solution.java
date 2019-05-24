package tool;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Solution {

  /**
   * @param str: An array of char
   * @param offset: An integer
   * @return: nothing
   */
  public static void rotateString(char[] str, int offset) {
    // write your code here
    if (offset == 0) {
      System.out.println(str);
    }
    int length = str.length;
    char[] str2 = new char[length];
    for (int i = 0; i < length; i++) {
      int temp = (length - offset + i) % length;
      str2[i] = str[temp];
    }
    System.out.println(str2);
  }

  public boolean rotateString(String A, String B) {
    if (A.length() != B.length()) {
      return false;
    }
    boolean flag = true;
    for (int j = 0; j < B.length(); j++) {
      for (int i = 0; i < A.length(); i++) {
        if (A.charAt(i) == B.charAt(j)) {

        }
      }
    }
    return flag;

  }

  public static void main(String[] args) {
    long todayZeroTimeMills =
      System.currentTimeMillis() / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone
        .getDefault().getRawOffset() - 1;
    System.out.println(todayZeroTimeMills);
    Date date = new Date(todayZeroTimeMills);
    System.out.println(date.toString());
    Date date1 = new Date();
    System.out.println(date1);

    Calendar c = Calendar.getInstance();
    c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
    c.set(Calendar.HOUR_OF_DAY, 0);
    c.set(Calendar.MINUTE, 0);
    c.set(Calendar.SECOND, 0);
    System.out.println(c.getTimeInMillis());
  }
}