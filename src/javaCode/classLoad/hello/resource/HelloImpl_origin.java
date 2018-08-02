package javaCode.classLoad.hello;

import javaCode.classLoad.IHelloService;

public class HelloImpl_origin implements IHelloService {
    public HelloImpl_origin() {
    }

    public void sayHello() {
        System.out.println("hello");
    }
}
