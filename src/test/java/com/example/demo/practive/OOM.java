package com.example.demo.practive;

import java.util.ArrayList;
import java.util.List;

public class OOM {

    public static void main(String[] args) {
        System.out.println("44444");
        List<Test> list = new ArrayList<>();
        while (true) {
            list.add(new Test());
        }
    }


}
