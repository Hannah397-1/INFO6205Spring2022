import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q4 {
    public int[][] MergeIntervals(int[][] intervals){
        List<List<Integer>> res = new ArrayList<>();
        // corner case
        if(intervals.length == 0){
            return res.toArray(new int[0][0]);
        }
        Arrays.sort(intervals,(o1,o2)->o1[0]-o2[0]);
        LinkedList<int[]> list = new LinkedList<>();
        list.add(intervals[0]);
        for(int i = 1;i < intervals.length; i++){
            int[] cur = intervals[i];
            int[] last = list.getLast();
            if(cur[0] <= last[1]){// has overlapping area
                last[1] = Math.max(cur[1],last[1]);
            }else{
                list.add(cur);
            }
        }
        return list.toArray(new int[0][0]);
    }
}
