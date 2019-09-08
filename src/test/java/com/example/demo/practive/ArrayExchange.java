package com.example.demo.practive;

/**
 * 交换两个数组位置
 */
public class ArrayExchange {


    public static void main(String[] args) {
        int[] a={1,2,3,4};
        int[] b={5,6,7,8,9};
        int[][] c = arrayExchange(a,b);
        a=c[0];
        b=c[1];
        for(int x:a){
            System.out.println(x);
        }
        for(int x:b){
            System.out.println(x);
        }
    }

    /**
     * 通过中间变量交换引用地址
     * @param a 数组 a
     * @param b 数组 b
     * @return int[][] 返回的二维数组
     * @Author: chaiqianlong
     * @Date: 2019-08-31 12:56
     */
    public static int[][] arrayExchange(int[] a, int[] b) {
        int[] temp = a;
        a = b;
        b = temp;
        return new int[][]{a, b};
    }


}
