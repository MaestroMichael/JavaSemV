package com.company;

public class Thread1 extends Thread {

    int id;

    public Thread1(int id){
        this.id=id;
    }
    @Override
    public void run(){
//        try{
//            Thread.sleep((long)(300*Math.random()));
//        } catch (InterruptedException e) {
//            //e.printStackTrace();
//            System.out.println("Watek: "+this.getName()+" o numerze "+id);
//        }
        for(int i=0;i<21;i++){
            System.out.println("Wątek1 "+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
