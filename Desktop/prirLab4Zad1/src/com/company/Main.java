package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public interface Monitor{
        void proceduraWejsciowaWatek1();
        void proceduraWejsciowaWatek2();
        void proceduraWyjsciowaWatek1();
        void proceduraWyjsciowaWatek2();
    }


}

class Monitor implements Main.Monitor {
    boolean flag;
    int turn;
    @Override
    public void proceduraWejsciowaWatek1() {
        flag=true;
        turn=2;
        while(turn==1){}
    }

    @Override
    public void proceduraWejsciowaWatek2() {
        flag=true;
        turn=1;
        while(turn==1){}
    }

    @Override
    public void proceduraWyjsciowaWatek1() {
        flag=false;
    }

    @Override
    public void proceduraWyjsciowaWatek2() {
        flag=false;
    }
}

class W1 implements Runnable{
    Monitor m;
    Licznik l;
    public W1(Monitor m, Licznik l){
        this.m=m;
        this.l=l;
    }
    public void run(){
        for(int i=0;i<100;i++){
            m.proceduraWejsciowaWatek1();
            l.increment();
            m.proceduraWyjsciowaWatek1();;
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