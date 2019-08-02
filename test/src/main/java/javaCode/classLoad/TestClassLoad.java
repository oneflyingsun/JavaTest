package javaCode.classLoad;

class TestClassType{

//构造函数

    public TestClassType(){

        System.out.println("----构造函数---");

    }

//静态的参数初始化

    static{

        System.out.println("---静态的参数初始化---");

    }

//非静态的参数初始化

    {

        System.out.println("----非静态的参数初始化---");

    }

}

public class TestClassLoad {
    public static void main(String[] args)
    {
     //   TestClassType testTypeGetClass2= new TestClassType();
        try {
//测试.class

            Class testTypeClass=TestClassType.class;

            System.out.println("testTypeClass---"+testTypeClass);


//测试Class.forName()

            Class testTypeForName=Class.forName("javaCode.classLoad.TestClassType");

            System.out.println("testTypeForName---"+testTypeForName);


//测试Object.getClass()

            TestClassType testTypeGetClass= new TestClassType();

            System.out.println("testTypeGetClass---"+testTypeGetClass.getClass());



        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}


//public class Main {
//    static public void main(string[] args){
//        Scanner scan=new Scanner(System.in);
//        int n,k;
//        n=scan.nextInt();
//        if(n<1||n>10000)
//            return;
//        int[] appleHeap = new int[10000];
//        int sum=0;
//        for(int j=0;j<n;j++){
//            appleHeap[j]=scan.nextInt();
//            sum+=appleHeap[j];
//        }
//        k=scan.nextInt();
//        if(k<1||k>10000)
//            return;
//        int[] result = new int[10000];
//        int[] requireApple=new int[10000];
//        for(int j=0;j<k;j++){
//            requireApple[j]=scan.nextInt();
////            if(requireApple[j]>sum)
////                return;
//        }
//        for(int i=0;i<k;i++){
//            int temp;
//            temp=requireApple[i];
//            for(int j=0;j<n;j++){
//                temp-=appleHeap[j];
//                if (temp<=0){
//                    result[i]=j+1;
//                    break;
//                }
//            }
//            if (temp>0){
//                result[i]=0;
//            }
//        }
//
//
//        for(int i=0;i<k;i++){
//            System.out.println(result[i]);
//        }
//
//
//
//
//    }
//}

