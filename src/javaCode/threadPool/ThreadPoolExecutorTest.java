package javaCode.threadPool;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.*;

/**
 * @Author: ZhaoCong
 * @Date: 2019-03-07
 * @Description:
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ExecutorService executorService=newCachedThreadPool();
//        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor();
        for(int i=0;i<100;i++){
            ThreadPoolExecutorTest.ThreadTest threadTest=new ThreadTest();
            threadTest.setCount(i);
            executorService.execute(threadTest);
        }
//        Date date = new Date();
//        String oneWeek = dateFormat(addOnField(date, Calendar.YEAR, -2),null);
//        System.out.println(oneWeek);

    }
    public static String dateFormat(Date date, String format) {
        if (date == null) {
            date = new Date();
        }
        if (format == null || format.equals("")) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
    public static Date addOnField(Date date, int field, int interval) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(field, interval);
        return ca.getTime();
    }
    private static class ThreadTest implements Runnable{

        private int count;

        public void setCount(int count){
            this.count=count;
        }


        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" = > "+this.count);
        }
    }

}
