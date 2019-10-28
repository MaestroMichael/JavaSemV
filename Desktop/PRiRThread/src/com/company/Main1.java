package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

class Main {
    static class MyThread2 extends Thread{
        public Integer max;
        private Double salary=99999999.0;
        private int firstCount,lastCount;
        HashMap<Integer, Double> data;
        public MyThread2(HashMap<Integer,Double>x,int min,int max){
            data=x;
            firstCount=min;
            lastCount=max;
        }
        @Override
        public void run(){
            for(int i=firstCount;i<lastCount;i++){
                if(data.get(i)<salary){
                    max=i;
                    salary=data.get(i);
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        HashMap<Integer,Double> data=new HashMap<>();
        BufferedReader reader =new BufferedReader(new FileReader("dane.txt"));
        String line;
        int howManyThreads=3;
        while((line = reader.readLine()) != null){
            String[] lines = line.split(";");
            data.put(Integer.parseInt(lines[0]),Double.parseDouble(lines[1]));
        }
        reader.close();
        if(howManyThreads==1){
            MyThread2 thr=new MyThread2(data,0,data.size());
            thr.start();
            thr.join();
            System.out.println("K wynosi "+howManyThreads);
            System.out.println(thr.max+" "+thr.salary);
        }
        else{
            ArrayList<MyThread2> threads=new ArrayList<>();
            for(int i=0;i<howManyThreads;i++){
                threads.add(new MyThread2(data,((i+1)*(data.size()/howManyThreads))-(data.size()/howManyThreads),((i+1)*(data.size()/howManyThreads))));
                threads.get(i).start();
            }
            for(int i=0;i<howManyThreads;i++)threads.get(i).join();
            Double min=999999.0;
            Integer index = null;
            for(int i=0;i<howManyThreads;i++){
                if(threads.get(i).salary<min){
                    min=threads.get(i).salary;
                    index=threads.get(i).max;
                }
            }
            System.out.println(data.get(index)+" "+index);
        }

    }
}
