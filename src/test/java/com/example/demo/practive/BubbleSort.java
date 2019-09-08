package com.example.demo.practive;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {4, 2, 7, 3, 5, 9, 8};
        String type = "drop";//drop
        bubbleSort(array, type);
        for (int n : array) {
            System.out.println(n);
        }
    }


    /**
     * 冒泡排序
     * @param array 传入的数组
     * @param type  类型（rise:升序 drop:降序）
     * @return void
     * @Author: chaiqianlong
     * @Date: 2019-08-31 12:43
     */
    public static void bubbleSort(int[] array, String type) {
        for (int i = array.length; i > 0; i--) {
            for (int j = 0; j < i-1; j++) {
                if (("rise".equals(type) && array[j] > array[j + 1]) || ("drop".equals(type) && array[j] < array[j + 1])) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

}
