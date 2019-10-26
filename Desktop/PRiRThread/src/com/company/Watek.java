package com.company;

public class Watek extends Thread {
    private int number;
    static Licznik licznik=new Licznik();
    Watek(int id){
        this.number=id;
    }

    @Override
    public void run(){
        System.out.println("Watek "+number);
        for(int i=0; i<100000;++i){
            licznik.increment();
        }
    }
}
