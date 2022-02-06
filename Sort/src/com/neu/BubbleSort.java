package com.neu;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
//        int[] arr = {1, 2, 5, 9, 3, 7, 8, 4, 6};
        if(arr == null || arr.length < 2){
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) { // 0~i 规定在哪个范围上操作
            for (int j = 0; j < i; j++) { //操作
                if(arr[j] > arr[j + 1]){
                    swap(arr, j, j+1);
                }
            }
        }
        print(arr);
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
