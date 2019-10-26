package com.company;

public class Main1 {
    public static void main(String[] args) throws InterruptedException{
        System.out.println(Watek.licznik.get());
        int ileWatkow=10;
        Watek watek[]=new Watek[ileWatkow];
        for(int i=0; i<ileWatkow;i++){
            watek[i]=new Watek(i+1);
            watek[i].start();
        }
        for (int i=0;i<ileWatkow;i++){
            watek[i].join();
        }
        System.out.println(Watek.licznik.get());

    }
}
