package com.neu;

public class QuickSort {
    //首先排除异常情况
    public static void quickSort(int[] arr){
        if(arr == null || arr.length == 2){
            return;
        }
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int L, int R) {
        if(L < R){
            // 任意选一个数，并把它跟最后一个最交换，作为标准数，进行分层（荷兰国旗）
            int random = L + (int) (Math.random() * (R - L + 1));
            swap(arr, random, R);
            int[] res = partition(arr, L, R);
            //分好了以后，左边再快排，右边再快排，递归着来。一直到嘛时候呢，一直每边就剩一个数了，就行了。
            quickSort(arr, L, res[0] - 1);
            quickSort(arr, res[1] + 1, R);
        }
    }

    // 分层，荷兰国旗分层。
    // 但是呢，返回的不是整个数组，而是左边界和右边界
    // 返回的是一个数组，里边有俩值，是等于划分值的这个区域的左边界index和右边界index。
    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;// 一开始的<区右边界
        int more = R;// 一开始的>区左边界
        while (L < more) { // 当前数和>区没重合的时候
            if (arr[L] < arr[R]) {// L是当前数，为嘛是L呢，就相当于这个数组从第一个开始撸嘛
                swap(arr,++less, L++);// <区的下一个数和L交换，然后L再++
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
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


    public static void main(String[] args) {
        int[] arr1 = {1,3,4,6,2};
        quickSort(arr1);
    }
}
