package com.neu;

import java.util.Arrays;

public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        int[] cnts = new int[201];
        for (int n : nums){
            cnts[n + 100] ++;
        }
        for (int i = 0; i < nums.length; i++){
            nums[i] = 201 * cnts[nums[i] + 100] - nums[i] + 100;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            nums[i] = 100 - nums[i] % 201;
        }
        return nums;

    }
}
