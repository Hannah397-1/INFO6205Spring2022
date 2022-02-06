package com.neu;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int index = 0;

        while(index < intervals.length && intervals[index][1] < newInterval[0]){
            res.add(intervals[index++]);
        }
        while(index < intervals.length && intervals[index][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }
        res.add(newInterval);
        while(index < intervals.length){
            res.add(intervals[index++]);
        }
        return res.toArray(new int[0][]);
    }
}
