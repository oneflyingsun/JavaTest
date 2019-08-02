package javaCode.basicType.string;

/**
 * @author zhaocong
 * @date 2019-06-17
 * @description:
 */
public class StringTest{

  public static void main(String[] args) {
    String s = new String("12");
    s.intern();
    String s2 = "12";
    System.out.println(s == s2);

    String s3 = new String("3") + new String("4");
    s3.intern();
    String s4 = "34";
    String s5 = "34";

    System.out.println(s3 == s4);
//    System.out.println(s3 == s);
//    System.out.println(s4 == s2);
    System.out.println(s5 == s4);

  }

}
