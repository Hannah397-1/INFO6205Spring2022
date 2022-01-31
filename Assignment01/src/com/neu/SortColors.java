package com.neu;

public class SortColors {
    public void sortColors(int[] nums) {
        int i, j, insertNote;
        for(i = 0;i < nums.length;i++){
            insertNote = nums[i];
            j = i -1;
            while(j >= 0 && insertNote < nums[j]){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = insertNote;
        }
    }
}
