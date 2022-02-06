package com.neu;

public class QuickSort {
    public static void quickSort(int[] arr){
        if(arr == null || arr.length == 2){
            return;
        }
        quickSort(arr, 0, arr.length-1);
    }
    public static void quickSort(int[] arr, int L, int R) {
        if(L < R){
            int random = L + (int) (Math.random() * (R - L + 1));
            swap(arr, random, R);
            int[] res = partition(arr, L, R);
            quickSort(arr, L, res[0] - 1);
            quickSort(arr, res[1] + 1, R);
        }
    }

    // 返回的是一个数组，里边有俩值，是等于划分值的这个区域的左边界index和右边界index。
    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr,++less, L++);
            } else if (arr[L] > arr[more]) {
                swap(arr, --more, L); //如果不这么写是咋搞
            } else {
                L++;
            }
        }
        swap(arr, R, more);
        return new int[]{less + 1, more};

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
