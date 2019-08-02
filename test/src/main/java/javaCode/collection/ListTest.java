package javaCode.collection;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    static public void main(String[] args){
        /**
         * 测试ArrayList和LinkedList的效率
         */
        List<String> list=new ArrayList();
//        List<string> list=new LinkedList();
        Long time=System.currentTimeMillis();
        System.out.println("=====");
        for(int i=0;i<10000;i++){
            list.add("test" +i);
        }
        System.out.println("=====");
        System.out.println(System.currentTimeMillis()-time);
        for(String str:list){
            System.out.print(str);
        }
//        HashSet
    }
}
//i=100000 arraylist:92 linkedlist:66
//i=10000 arraylist:8,10,10,8 linkedlist:8,9,7
//i=1000 arraylist:4 linkedlist:4
//i=100 arraylist:2 linkedlist:2
//i=10 arraylist:1 linkedlist:1