package com.neu;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[1] - b[1];
            }
        });
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int value = entry.getKey();
            int count = entry.getValue();
            if(queue.size() == k){
                if(queue.peek()[1] < count){
                    queue.poll();
                    queue.offer(new int[]{value,count});
                }
            }else{
                queue.offer(new int[]{value,count});
            }
        }
        int[] res = new int[k];
        for(int i = 0;i < k;i++){
            res[i] = queue.poll()[0];
        }
        return res;

    }

}
