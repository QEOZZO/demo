package com.example.demo.test;

public class Test {

    private static volatile boolean initFlag=false;

    public static void main(String[] args) throws InterruptedException{

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("waiting data ...");
                while (!initFlag){

                }
                System.out.println("=========success");
            }
        }).start();

        Thread.sleep(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                refresh();
            }
        }).start();


    }

    public static void refresh(){
        System.out.println("修改数据");
        initFlag=true;

    }


}
