package com.neu;

import java.util.Arrays;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] intersection = new int[nums1.length + nums2.length];
        int i=0, j=0, k=0;// i->num1 index; j-> num2 index; k->intersection index;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                if(k == 0 || nums1[i] !=intersection[k - 1]){
                    intersection[k] = nums1[i];
                    k++;
                }else{
                    i++;
                    j++;
                }
            }
            else if(nums1[i]< nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        return Arrays.copyOfRange(intersection,0,k);
    }
}
