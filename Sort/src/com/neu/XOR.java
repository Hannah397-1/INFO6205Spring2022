package com.neu;

public class XOR {
    public static void printOddTimesNum1(int[] arr){
        int eor = 0;
        for(int cur: arr){
            eor = eor^cur;
        }
        System.out.println(eor);
    }

    public static void printOddTimesNum2(int[] arr){
        int eor = 0;
        for(int cur: arr){
            eor ^= cur;
        }
        // eor = a ^ b;
        // eor != 0;
        // eor必定有一位是1

        int rightOne = eor & (~eor + 1); // 提取出最右的1
        int onlyOne = 0;

        for(int cur:arr){
            if((cur & rightOne) == 0){
                onlyOne ^= cur;
            }
        }
        System.out.println(rightOne + " " + (rightOne ^ eor));

    }

    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
