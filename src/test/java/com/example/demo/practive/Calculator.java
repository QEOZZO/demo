package com.example.demo.practive;

import java.util.Scanner;

/**
 * 计算器
 */
public class Calculator {

    public static void main(String[] args) {
        calculator();
    }

    /**
     * 模拟计算器
     * @return void
     * @Author: chaiqianlong
     * @Date: 2019-08-31 13:23
     */
    public static void calculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字");
        String a = scanner.nextLine();
        while (true) {
            System.out.println("请输入符号");
            String symbol = scanner.nextLine();
            if ("=".equals(symbol)) {
                System.out.println("计算结束,结果为：" + a);
                break;
            }
            if (!("+".equals(symbol) || "-".equals(symbol) || "*".equals(symbol) || "/".equals(symbol))) {
                System.out.println("符号输入错误！");
                continue;
            }
            System.out.println("请输入数字");
            String b = scanner.nextLine();
            switch (symbol) {
                case "+":
                    a = addition(Float.parseFloat(a), Float.parseFloat(b)) + "";
                    break;
                case "-":
                    a = subtraction(Float.parseFloat(a), Float.parseFloat(b)) + "";
                    break;
                case "*":
                    a = multiplication(Float.parseFloat(a), Float.parseFloat(b)) + "";
                    break;
                case "/":
                    a = division(Float.parseFloat(a), Float.parseFloat(b)) + "";
                    break;
                default:
            }
            System.out.println("当前结果为：" + a);
        }
    }

    //加法
    public static float addition(float a, float b) {
        return a + b;
    }

    //减法
    public static float subtraction(float a, float b) {
        return a - b;
    }

    //乘法
    public static float multiplication(float a, float b) {
        return a * b;
    }

    //除法
    public static float division(float a, float b) {
        return a / b;
    }


}
