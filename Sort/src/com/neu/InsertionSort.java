package com.neu;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
//        int[] arr = {1, 4, 6, 2, 5, 7, 3, 8};
        if(arr == null || arr.length < 2){
            return;
        }
        // 0~0 有序的
        // 0~1， 0~2， 0~3... 0~(n-1) 想有序
        for (int i = 1; i < arr.length; i++) { // 0 ~ i范围上做到有序
            for (int j = i - 1; j >= 0 ; j--) { // 当前数，往左换到不能再换 停
                if(arr[j + 1] < arr[j]){
                    swap(arr,j,j+1);
                }
            }
        }
    }




    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void print(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
