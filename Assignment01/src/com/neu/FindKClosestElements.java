package com.neu;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length - k;
        int i = 0;
        for(; i < n; i++){
            if(arr[i]>= x) break;
            if(arr[i+k] < x) continue;
            if(Math.abs(arr[i] - x)<= Math.abs(arr[i+k] - x)) break;
        }
        for(int j = 0; j < k; j++){
            list.add(arr[j+i]);
        }
        return list;
    }
}
