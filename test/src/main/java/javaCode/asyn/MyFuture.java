package javaCode.asyn;

public interface MyFuture<V> {
    V get() throws Exception;
}
