package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        Monitor m= new Monitor();
        Licznik l=new Licznik();
        Thread th1=new W1(m,l);
        Thread th2=new W2(m,l);
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        System.out.println(l.get());
    }




}

interface MonitorInterface{
    void proceduraWejsciowaWatek1();
    void proceduraWejsciowaWatek2();
    void proceduraWyjsciowaWatek1();
    void proceduraWyjsciowaWatek2();
}

class Monitor implements MonitorInterface {
    boolean[] flag=new boolean[2];
    int turn;
    @Override
    public void proceduraWejsciowaWatek1() {
        flag[0]=true;
        turn=2;
        while(turn==1&& flag[0]==true){}
    }

    @Override
    public void proceduraWejsciowaWatek2() {
        flag[1]=true;
        turn=1;
        while(turn==2&& flag[1]==true){}
    }

    @Override
    public void proceduraWyjsciowaWatek1() {
        flag[0]=false;
    }

    @Override
    public void proceduraWyjsciowaWatek2() {
        flag[1]=false;
    }
}

class W1 extends Thread{
    MonitorInterface m;
    Licznik l;
    public W1(MonitorInterface m, Licznik l){
        this.m=m;
        this.l=l;
    }

    @Override
    public void run(){
        for(int i=0;i<100;i++){
            m.proceduraWejsciowaWatek1();
            l.increment();
            m.proceduraWyjsciowaWatek1();;
        }
    }
}

class W2 extends Thread{
    MonitorInterface m;
    Licznik l;
    public W2(MonitorInterface m, Licznik l){
        this.m=m;
        this.l=l;
    }
    @Override
    public void run(){
        for(int i=0;i<100;i++){
            m.proceduraWejsciowaWatek2();
            l.increment();
            m.proceduraWyjsciowaWatek2();;
        }
    }
}


class Licznik{
    public int licznik=0;

    public void increment(){
        licznik++;
    }


    public int get(){
        return licznik;
    }
}