package com.company;

public class Thread2 implements Runnable{


//    int id;
//    public Thread2(int id ){
//        this.id=id;
//
//    }

    @Override
    public void run() {
            for (int i=100;i<121;i++){
                System.out.println("Wątek2 "+i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}
