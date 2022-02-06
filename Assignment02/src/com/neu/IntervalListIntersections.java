package com.neu;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList.length == 0 || secondList.length == 0) return new int[0][];
        List<int[]> res = new ArrayList<>();
        int first = 0;
        int second = 0;
        while(first < firstList.length && second < secondList.length) {
            boolean flag = helper(firstList[first], secondList[second]);
            if(flag) {
                int[] temp = find(firstList[first], secondList[second]);
                res.add(temp);
                if(temp[1] == firstList[first][1]) ++first;
                else ++second;
            } else {
                if(firstList[first][0] > secondList[second][0]) ++second;
                else ++first;
            }
        }
        return res.toArray(new int[0][]);
    }
    static boolean helper(int[] first, int[] second) {
        if(first[0] <= second[0] && first[1] >= second[0]) {
            return true;
        } else if(second[0] <= first[0] && second[1] >= first[0]) {
            return true;
        }
        return false;
    }

    static int[] find(int[] first, int[] second) {
        return new int[]{Math.max(first[0], second[0]), Math.min(first[1], second[1])};
    }
}
