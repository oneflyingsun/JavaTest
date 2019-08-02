package javaCode.collection;

import java.util.HashMap;

public class HashMapTest {

    public static void main(String[] args) {
        HashMap hashMap=new HashMap();
        for(int i=0;i<30;i++){

            if(i==0){
                System.out.println(hashMap.size());
            }
            if(i==2){
                System.out.println(hashMap.size());
            }
            if(i==11){
                System.out.println(hashMap.size());
            }
            if(i==15){
                System.out.println(hashMap.size());
            }
            if(i==17){
                System.out.println(hashMap.size());
            }
            if(i==20){
                System.out.println(hashMap.size());
            }
            hashMap.put(i,i);
        }
        System.out.println(hashMap.get(2)+"测试");

    }
}
