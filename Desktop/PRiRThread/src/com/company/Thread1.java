package com.company;

public class Thread1 extends Thread {

//    int id;

//    public Thread1(int id){
//        this.id=id;
//    }


    Thread t2;
    public Thread1(Thread t2){this.t2=t2;}

    @Override
    public void run(){
//        try{
//            Thread.sleep((long)(300*Math.random()));
//        } catch (InterruptedException e) {
//            //e.printStackTrace();
//            System.out.println("Watek: "+this.getName()+" o numerze "+id);
//        }


        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
