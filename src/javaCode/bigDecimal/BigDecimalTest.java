package javaCode.bigDecimal;

/**
 * @Author: ZhaoCong
 * @Date: 2019-03-15
 * @Description:
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        float f = 0.1f;
        double d = 0.1;
        for (int i = 0; i < 10; i++) {
            System.out.println(f += 0.1);
        }
        System.out.println("=============");
        for (int i = 0; i < 10; i++) {
            System.out.println(d += 0.1);
        }
    }
}
