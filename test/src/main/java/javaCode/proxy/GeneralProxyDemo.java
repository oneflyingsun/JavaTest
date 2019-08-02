package javaCode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GeneralProxyDemo {
    static interface IServiceA {
        public void sayHello();
        public void sayHello2();
    }

    static class ServiceAImpl implements IServiceA {

        @Override
        public void sayHello() {
            System.out.println("hello");
        }

        @Override
        public void sayHello2() {
            System.out.println("hello2");
        }
    }

    static interface IServiceB {
        public void fly();
    }

    static class ServiceBImpl implements IServiceB {

        @Override
        public void fly() {
            System.out.println("flying");
        }
    }

    static class SimpleInvocationHandler implements InvocationHandler {
        private Object realObj;

        public SimpleInvocationHandler(Object realObj) {
            this.realObj = realObj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("entering " + realObj.getClass().getSimpleName() + "::" + method.getName());
            Object result = method.invoke(realObj, args);
            System.out.println("leaving " + realObj.getClass().getSimpleName() + "::" + method.getName());
            return result;
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> T getProxy(Class<T> intf, T realObj) {
        return (T) Proxy.newProxyInstance(intf.getClassLoader(), new Class<?>[] { intf },
                new SimpleInvocationHandler(realObj));
    }

    public static void main(String[] args) throws Exception {
        IServiceA a = new ServiceAImpl();
        IServiceA aProxy = getProxy(IServiceA.class, a);
        aProxy.sayHello();
        aProxy.sayHello2();

        IServiceB b = new ServiceBImpl();
        IServiceB bProxy = getProxy(IServiceB.class, b);
        bProxy.fly();
    }
}