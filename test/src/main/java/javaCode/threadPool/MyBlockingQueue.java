//package javaCode.threadPool;
//
//import java.util.ArrayDeque;
//import java.util.Queue;
//
//public class MyBlockingQueue<E> {
//    private Queue<E> queue=null;
//    private int limit;
//    public MyBlockingQueue(int limit){
//        this.limit=limit;
//        queue=new ArrayDeque<>(limit);
//    }
//    public synchronized void put(E e) throws InterruptedException{
//        while(queue.size()==limit){
//            wait();
//            System.out.println("Wait01");
//        }
//        queue.add(e);
//        notifyAll();
//    }
//    public synchronized E take() throws InterruptedException{
//        while(queue.isEmpty()){
//            wait();
//            System.out.println("Wait02");
//        }
//        E e=queue.poll();
//        notifyAll();
//        return e;
//    }
//}
