package javaCode.classLoad.hello;


import javaCode.classLoad.IHelloService;

public class HelloImpl implements IHelloService {
    public HelloImpl() {
    }

    public void sayHello() {
        System.out.println("hello");
    }
}
