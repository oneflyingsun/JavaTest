package javaCode.threadPool;

import java.util.concurrent.atomic.AtomicInteger;

public class InterruptRunnableDemo extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            // ... 单次循环代码
        }
        System.out.println("done ");
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger num;
    }
}

