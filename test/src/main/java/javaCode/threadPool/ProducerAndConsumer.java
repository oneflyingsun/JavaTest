//package javaCode.threadPool;
//
//public class ProducerAndConsumer {
//    static class Producer extends Thread{
//        MyBlockingQueue2<string> queue;
//        public Producer(MyBlockingQueue2<string> queue){
//            this.queue=queue;
//        }
//        @Override
//        public void run(){
//            int num=0;
//            try{
//                while(true){
//                    string task=string.valueOf(num);
//                    queue.put(task);
//                    System.out.println("Producer task "+ task);
//                    num++;
//                    Thread.sleep((int)Math.random()*100);
//                }
//            }catch (InterruptedException e){
//
//            }
//        }
//    }
//    static class Consumer extends Thread{
//        MyBlockingQueue2<string> queue;
//        public Consumer(MyBlockingQueue2<string> queue){
//            this.queue=queue;
//        }
//        @Override
//        public void run(){
//            try{
//                while(true){
//                    string task=queue.take();
//                    System.out.println("handle task "+ task);
//                    Thread.sleep((int)Math.random()*100);
//                }
//            }catch (InterruptedException e){
//
//            }
//        }
//    }
//    public static void main(string[] args) {
//        MyBlockingQueue2<string> queue=new MyBlockingQueue2<>(5);
//        new Producer(queue).start();
//        new Consumer(queue).start();
//    }
//}
