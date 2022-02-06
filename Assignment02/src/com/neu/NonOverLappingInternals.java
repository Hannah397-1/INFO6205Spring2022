package com.neu;

import java.util.Arrays;
import java.util.Stack;

public class NonOverLappingInternals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(o1, o2) -> {
            if (o1[1]<o2[1]){
                return -1;
            }else if (o1[1]>o2[1]){
                return 1;
            }else {
                return o1[0]-o2[0];
            }
        });
        Stack<int[]> list=new Stack<>();
        int count=0;
        for (int[] interval : intervals) {
            if (list.isEmpty()||interval[0]>=list.peek()[1]){
                list.add(interval);
            }else {
                count++;
            }
        }
        return count;
    }
}
