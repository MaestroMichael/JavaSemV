package com.company;

public class Main1 {
    public static void main(String[] args) throws InterruptedException{
//        System.out.println(Watek.licznik.get());
//        int ileWatkow=10;
//        Watek watek[]=new Watek[ileWatkow];
//        for(int i=0; i<ileWatkow;i++){
//            watek[i]=new Watek(i+1);
//            watek[i].start();
//        }
//        for (int i=0;i<ileWatkow;i++){
//            watek[i].join();
//        }
//        System.out.println(Watek.licznik.get());
        Thread2 t2=new Thread2();
        Thread thread2=new Thread(t2);
        Thread1 t1=new Thread1(thread2);

        Thread thread1=new Thread(t1);


        thread1.start();
        thread2.start();
        thread2.join();
    }
}
