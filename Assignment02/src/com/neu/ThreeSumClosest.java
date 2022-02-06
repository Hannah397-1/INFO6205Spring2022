package com.neu;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        if(res >= target){
            return res;
        }
        if(nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] <= target){
            return nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
        }

        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                if(Math.abs(nums[i] + nums[left] + nums[right] - target) < Math.abs(res - target)){
                    res = nums[i] + nums[left] + nums[right];
                    if(res == target){
                        return res;
                    }
                }
                if(nums[i] + nums[left] + nums[right] < target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }
}
