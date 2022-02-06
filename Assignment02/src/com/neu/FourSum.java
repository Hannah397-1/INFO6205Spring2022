package com.neu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList();
        if (nums == null || nums.length < 4) {
            return list;
        }
        Arrays.sort(nums);

        for (int i = 0; i <= nums.length - 4; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            List<List<Integer>> temp = threeSum(nums, i, target - nums[i]);
            if (temp != null) {
                for (List<Integer> result : temp) {
                    result.add(nums[i]);

                    list.add(result);
                }
            }
        }
        return list;
    }

    //3sum
    static List<List<Integer>> threeSum(int[] nums, int i, int target) {
        List<List<Integer>> list = null;
        if (nums.length - 4 < i) {
            return list;
        }
        for (int j = i + 1; j <= nums.length - 3; j++) {

            if (nums[j] > target && target > 0) {
                break;
            }
            if (j > i + 1 && nums[j] == nums[j - 1]) {
                continue;
            }
            int k = j + 1;
            int r = nums.length - 1;
            while (k < r) {
                int sum = nums[j] + nums[k] + nums[r];
                if (sum == target) {
                    if (list == null) {
                        list = new ArrayList();
                    }
                    List<Integer> temp = new ArrayList();
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    temp.add(nums[r]);
                    list.add(temp);
                    while (k < r && nums[k] == nums[k + 1]) k++;
                    while (k < r && nums[r] == nums[r - 1]) r--;
                    k++;
                    r--;
                } else if (sum < target) k++;
                else r--;
            }
        }
        return list;
    }


}
