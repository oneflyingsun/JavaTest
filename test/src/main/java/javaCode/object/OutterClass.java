package javaCode.object;

public class OutterClass {
    public int normalInt=1;
    public static int staticInt=2;
    public static void doSomethingStatic(){
        System.out.println("doSomethingStatic:"+staticInt);
    }
    public void doSomethingNormal(){
        System.out.println("doSomethingNormal:"+normalInt);
    }
    public static class InnerStaticTest{
        public int normalInt=3;
        public static int staticInt=4;
        public static void doSomethingStatic(){
            OutterClass.doSomethingStatic();
            System.out.println("doSomethingInnerStatic:"+OutterClass.staticInt+staticInt);
        }
        public void doSomethingNormal(){
            System.out.println("doSomethingInnerNormal:"+normalInt);
        }
    }
    public class InnerNormalTest{
        public int normalInt=5;
        public static final int staticInt=6;
//        public static void doSomethingStatic(){
//            System.out.println("doSomethingInnerStatic:"+OutterClass.staticInt+staticInt);
//        }
        public void doSomethingNormal(){
            OutterClass.doSomethingStatic();
            System.out.println("doSomethingInnerNormal:"+normalInt+staticInt+OutterClass.staticInt);
        }
    }
}
