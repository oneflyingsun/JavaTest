package javaCode.classLoad.hello;


import javaCode.classLoad.IHelloService;

public class HelloImpl_revised implements IHelloService {
    public HelloImpl_revised() {
    }

    public void sayHello() {
        System.out.println("hello revised");
    }
}
