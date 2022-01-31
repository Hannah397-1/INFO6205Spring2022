package com.neu;

public class CustomSortString {
    public String customSortString(String order, String str) {
        char[] c = order.toCharArray(),c1 = str.toCharArray();
        boolean[] b = new boolean[c1.length];
        String ss = "";
        for(int i = 0;i < c.length;i++){
            for(int j = 0;j < c1.length;j++){
                if(c[i] == c1[j] && !b[j]){
                    ss += c[i];
                    b[j] = true;
                }

            }
        }
        for(int i = 0;i < c1.length;i++){
            if(!b[i]){
                ss += c1[i];
            }
        }
        return ss;
    }
}
