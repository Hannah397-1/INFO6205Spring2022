import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q1 {
    public static void MissingNums(int[] nums, int lower, int upper){
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int newLower = lower;// pointer in inclusive range
        //Because "where all elements are in the inclusive range."
        // the nums[i] is either less or equals to the upper numer.
        while(i < nums.length){
            int cur = nums[i];

            if(cur == newLower){// 如果现在的数和区间起始值一样，那么i后移一位
                newLower = cur + 1;
                i++;
            }else if(cur > newLower){
                list.add(new int[2]);
                list.get(list.size()-1)[0] = newLower;
                list.get(list.size()-1)[1] = cur-1;
                newLower = cur + 1;
                i++;
            }
        }
        if(newLower < upper){
            list.add(new int[2]);
            list.get(list.size()-1)[0] = newLower;
            list.get(list.size()-1)[1] = upper;
        }
        // print
        String SEP = ",";
        System.out.print("[");
        for(i = 0; i < list.size();i++){

            int[] cur = list.get(i);
            if(cur[0] == cur[1]){
                System.out.print(cur[0] + SEP);
            }else{
                System.out.print(cur[0] + "->" + cur[1] + SEP);
            }
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,3,50,75};
        int lower = 0;
        int upper = 99;
        MissingNums(nums, lower,upper);
    }
}

