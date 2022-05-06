import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Q3 {
    /**
     * Given an array of strings strs, group the anagrams together. You can return the answer in any order. An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
     * <p>
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * Input: strs = [""]
     * Output: [[""]]
     * Input: strs = ["a"]
     * Output: [["a"]]
     *
     * @param strs
     * @return
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        //TODO: Write your code here
        HashMap<String, List<String>> codeToGroup = new HashMap<>();
        for (String s : strs) {
            // encoding  & group
            String code = encode(s);
            codeToGroup.putIfAbsent(code, new LinkedList<>());
            codeToGroup.get(code).add(s);
        }
        // get result
        List<List<String>> res = new LinkedList<>();
        for (List<String> group : codeToGroup.values()) {
            res.add(group);
        }

        return res;
    }

    // encode by frequency
    String encode(String s) {
        char[] code = new char[26];
        for (char c : s.toCharArray()) {
            int n = c - 'a';
            code[n]++;
        }
        return new String(code);
    }

}







