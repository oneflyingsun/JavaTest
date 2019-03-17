package javaCode.basicType.integer;

/**
 * @Author: ZhaoCong
 * @Date: 2019-03-15
 * @Description:
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer a = new Integer(127);
        Integer b = new Integer(127);
        if (a == b) {
            System.out.println("a==b");
        } else {
            System.out.println("a!=b");
        }

        Integer c = 127;
        Integer d = 127;
        if (c == d) {
            System.out.println("c==d");
        } else {
            System.out.println("c!=d");
        }

        Integer e = 128;
        Integer f = 128;
        if (e == f) {
            System.out.println("e==f");
        } else {
            System.out.println("e!=f");
        }

        Integer g = 128;
        int h = 128;
        if (g == h) {
            System.out.println("g==h");
        } else {
            System.out.println("g!=h");
        }

    }
}
