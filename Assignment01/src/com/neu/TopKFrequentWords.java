package com.neu;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<String, Integer>(words.length * 2);
        int count = 0;
        for(int i = 0; i < words.length; i++){
            if(map.get(words[i]) == null){
                count++;
                map.put(words[i],1);
            }else{
                map.put(words[i],map.get(words[i]) + 1);
            }
        }
        Iterator<String> it = map.keySet().iterator();
        String[][] temp = new String[map.size()][2];
        int i = 0;
        while(it.hasNext()){
            temp[i][0]=it.next();
            temp[i][1]=map.get(temp[i][0]).toString();
            i++;
        }
        Arrays.sort(temp,new Comparator<String[]>(){
            public int compare(String[] o1, String[] o2){
                if(Integer.valueOf(o1[1]) != Integer.valueOf(o2[1])){
                    return Integer.valueOf(o2[1]) - Integer.valueOf(o1[1]);
                }
                int min;
                if(o1[0].length()>o2[0].length()){
                    min = o2[0].length();
                }else{
                    min = o1[0].length();
                }
                for (int i = 0; i < min; i ++){
                    if(o1[0].charAt(i) - o2[0].charAt(i) != 0){
                        return o1[0].charAt(i) - o2[0].charAt(i);
                    }
                }
                return o1[0].length() - o2[0].length();

            }
        });
        List<String> list = new ArrayList<String>();
        for(int j =0; j<k; j++){
            list.add(temp[j][0]);
        }
        return list;
    }
}
