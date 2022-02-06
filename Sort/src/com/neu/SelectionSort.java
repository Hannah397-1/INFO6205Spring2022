package com.neu;

public class SelectionSort {
    public static void seletionSort(int[] arr) {
//        int[] arr = {1, 4, 6, 2, 5, 7, 3, 8};
        if(arr == null || arr.length < 2){
            return;//排除掉干扰情况，arr是空或者里边就两个数，不用排
        }
        for (int i = 0; i < arr.length - 1; i++) { // i ~ N-1
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) { //  i ~ N-1 找出最小值的下标并记录
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
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
