package com.neu;

public class ReorganizeString {
    public String reorganizeString(String S) {
        int[] temp = new int[26];
        StringBuilder st = new StringBuilder();
        for(int i=0;i<S.length();i++){
            temp[S.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(temp[i]>(S.length()+1)/2){
                return "";
            }
        }
        while(st.length()<S.length()){
            int index = 0;
            for(int i=0;i<26;i++){
                if(temp[index]<temp[i]) index = i;
            }
            st.append((char)('a'+index));
            temp[index]--;
            for(int i=0;i<26;i++){
                if(i!=index && temp[i]>0){
                    st.append((char)('a'+i));
                    temp[i]--;
                    break;
                }
            }
        }
        return st.toString();
    }
}
