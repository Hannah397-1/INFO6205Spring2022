package com.neu;

import java.util.Arrays;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        int[] startTime = new int[intervals.length];
        int[] endTime = new int[intervals.length];
        int index = 0;
        for(int[] interval: intervals){
            startTime[index] = interval[0];
            endTime[index++] = interval[1];
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int i = 0, j = 0;
        int occupied = 0, max = 0;
        while(i < intervals.length && j < intervals.length){
            if(startTime[i] < endTime[j]){
                occupied++;
                i++;
            }else{
                occupied--;
                j++;
            }
            max = Math.max(max, occupied);
        }
        return max;
    }
}
