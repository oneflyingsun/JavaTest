package tool;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * @date 2019-04-23
 * @description: 比较同一类对象不同的值
 */
public class DiffTwoObj<T> {

  public String contrastObj(T oldBean, T newBean) {
    String str = "";
    T pojo1 = oldBean;
    T pojo2 = newBean;
    try {
      Class clazz = pojo1.getClass();
      List<Field> fieldList = new ArrayList<>();
      while (clazz != null) {
        //当父类为null的时候说明到达了最上层的父类(Object类).
        fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));
        //得到父类,然后赋给自己
        clazz = clazz.getSuperclass();
      }
      int i = 1;
      for (Field field : fieldList) {
        if ("serialVersionUID".equals(field.getName())) {
          continue;
        }
        PropertyDescriptor pd = new PropertyDescriptor(field.getName(), pojo1.getClass());
        Method getMethod = pd.getReadMethod();
        Object o1 = getMethod.invoke(pojo1);
        Object o2 = getMethod.invoke(pojo2);
        if (o2 == null) {
          continue;
        }
        if (o1 == null) {
          str += " [" + i + "]、" + field.getName() + ":null,->" + o2 + "\n";
          i++;
          continue;
        }
        if (!o1.equals(o2)) {
          str += " [" + i + "]、" + field.getName() + ":" + o1 + ",->" + o2 + "\n";
          i++;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return str;
  }
}
