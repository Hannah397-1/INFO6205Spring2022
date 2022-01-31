package com.neu;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i ++){
            int h = citations.length - i;
            if(h <=citations[i]){
                return h;
            }
        }
        return 0;

    }
}
