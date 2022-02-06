package com.neu;

public class SingleElementinASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int eor = 0;
        for(int cur: nums){
            eor = eor^cur;
        }return eor;
    }
}
