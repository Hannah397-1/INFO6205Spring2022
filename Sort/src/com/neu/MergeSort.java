package com.neu;

public class MergeSort {
    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + (R - L) >> 1;
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L, p2 = M + 1;

        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
//            if (arr[p1] <= arr[p2]) {
//                help[i++] = arr[p1++];
//            }help[i++] = arr[p2++];
        }
        //上面的while过后，left和right数组一定有一个越界一个不越界
        //所以需要把没越界的，剩下的都拷贝到help里去
        while(p1 <= M){
            help[i++] = arr[p1++];
        }
        while(p2 <= R){
            help[i++] = arr[p2++];
        }
        // 三个while完了之后，把help数组里的数，copy回原来的数组里
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }
}
