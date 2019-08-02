//package javaCode.proxy;
//import org.aopalliance.intercept.MethodInterceptor;
//import java.lang.reflect.Method;
//
//public class SimpleCGLibDemo {
//    static class RealService {
//        public void sayHello() {
//            System.out.println("hello");
//        }
//    }
//
//    static class SimpleInterceptor implements MethodInterceptor {
//
//        @Override
//        public Object intercept(Object object, Method method,
//                                Object[] args, MethodProxy proxy) throws Throwable {
//            System.out.println("entering " + method.getName());
//            Object result = proxy.invokeSuper(object, args);
//            System.out.println("leaving " + method.getName());
//            return result;
//        }
//    }
//
//    @SuppressWarnings("unchecked")
//    private static <T> T getProxy(Class<T> cls) {
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(cls);
//        enhancer.setCallback(new SimpleInterceptor());
//        return (T) enhancer.create();
//    }
//
//    public static void main(string[] args) throws Exception {
//        RealService proxyService = getProxy(RealService.class);
//        proxyService.sayHello();
//    }
//}