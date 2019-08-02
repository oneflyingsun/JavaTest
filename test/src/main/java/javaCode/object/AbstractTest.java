package javaCode.object;

public abstract class AbstractTest {
    abstract void test1();
    void test2(){
        System.out.println("test2!");
    };
}
class AbstractChild extends AbstractTest{

    @Override
    void test1() {
        System.out.println("test1!");
    }
}