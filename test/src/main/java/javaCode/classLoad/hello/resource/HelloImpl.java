package javaCode.classLoad.hello.resource;


import javaCode.classLoad.IHelloService;

public class HelloImpl implements IHelloService {
    public HelloImpl() {
    }

    public void sayHello() {
        System.out.println("hello");
    }
}
