package com.neu;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> list=new ArrayList<>();
        int size=arr.length-1;
        while(size>0){
            if(findIdexs(arr,size)<size){
                list.add(findIdexs(arr,size)+1);
                list.add(size+1);
            }
            reverse(arr,0,findIdexs(arr,size));
            reverse(arr,0,size--);
        }
        return list;
    }
    public static int[] reverse(int[] arr,int i,int j){
        for(;i<j;i++,j--){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        return arr;
    }
    public static int findIdexs(int[] arr,int size){
        int max=0,k=0;
        for(int i=0;i<=size;i++){
            if(max<arr[i]){
                max=arr[i];
                k=i;
            }
        }
        return k;

    }
}
