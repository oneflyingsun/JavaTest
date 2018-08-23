package javaCode.object;

public class staticMain {
    static public void  main(String[] args){
        /**
         * 非静态
         */
        OutterClass staticTest=new OutterClass();
        staticTest.doSomethingNormal();
        //  OutterClass.InnerNormalTest innerNormalTest=new OutterClass.InnerNormalTest();

        OutterClass.InnerStaticTest innerStaticTest=new OutterClass.InnerStaticTest();
        innerStaticTest.doSomethingNormal();
        System.out.println("innerStaticTest.normalInt:"+innerStaticTest.normalInt);

        System.out.println("Static ------");
        /**
         * 静态
         */
        OutterClass.doSomethingStatic();
        OutterClass.InnerStaticTest.doSomethingStatic();
        System.out.println("innerStaticTest.staticInt:"+OutterClass.InnerStaticTest.staticInt);

    }
}
