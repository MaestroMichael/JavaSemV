package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

class Main {
    static class MyThread implements Runnable{
        int start;
        public MyThread(int x){
            start=x;
        }
        @Override
        public void run() {
            for (int i=start;i<=start+20;i++){
                System.out.println(i);
            }
        }
    }
    static class MyThread2 extends Thread{
        public Integer max;
        private Double money=99999999.0;
        private int min_range,max_range;
        HashMap<Integer, Double> data;
        public MyThread2(HashMap<Integer,Double>x,int min,int max){
            data=x;
            min_range=min;
            max_range=max;
        }
        @Override
        public void run(){
            for(int i=min_range;i<max_range;i++){
                if(data.get(i)<money){
                    max=i;
                    money=data.get(i);
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException, IOException {
//        MyThread x1=new MyThread(0);
//        MyThread x2=new MyThread(100);
//        Thread t=new Thread(x1);
//        Thread t2=new Thread(x2);
//        t.start();
//        t.join();
//        t2.start();
//        t2.join();
        HashMap<Integer,Double> data=new HashMap<>();
        BufferedReader reader =new BufferedReader(new FileReader("dane.txt"));
        String line;
        int k=1;
        while((line = reader.readLine()) != null){
            String[] lines = line.split(";");
            data.put(Integer.parseInt(lines[0]),Double.parseDouble(lines[1]));
        }
        reader.close();
        if(k==1){
            MyThread2 thr=new MyThread2(data,0,data.size());
            thr.start();
            thr.join();
            System.out.println(thr.max+" "+thr.money);
        }
        else{
            ArrayList<MyThread2> threads=new ArrayList<>();
            for(int i=0;i<k;i++){
                threads.add(new MyThread2(data,((i+1)*(data.size()/k))-(data.size()/k),((i+1)*(data.size()/k))));
                threads.get(i).start();
            }
            for(int i=0;i<k;i++)threads.get(i).join();
            Double min=999999.0;
            Integer index = null;
            for(int i=0;i<k;i++){
                if(threads.get(i).money<min){
                    min=threads.get(i).money;
                    index=threads.get(i).max;
                }
            }
            System.out.println(data.get(index)+" "+index);
        }

    }
}
