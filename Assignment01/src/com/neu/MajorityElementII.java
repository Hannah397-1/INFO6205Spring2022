package com.neu;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        //(n/3) max-> 2
        int numA = Integer.MAX_VALUE;
        int numB = Integer.MAX_VALUE;
        int countA = 0, countB = 0;
        for(int i: nums){
            if(i == numA){
                countA++;
            }else if(i == numB){
                countB++;
            }else if(countA == 0){
                numA = i;
                countA = 1;
            }else if(countB == 0){
                numB = i;
                countB = 1;
            }else{
                countA--;
                countB--;
            }
        }
        countA = 0;
        countB = 0;
        for(int i: nums){
            if(i == numA){
                countA++;
            }else if(i == numB){
                countB++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if(countA > nums.length / 3){
            res.add(numA);
        }
        if(countB > nums.length / 3){
            res.add(numB);
        }
        return res;


    }
}
