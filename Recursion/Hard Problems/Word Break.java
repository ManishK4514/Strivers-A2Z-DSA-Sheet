/*
    Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

    Note that the same word in the dictionary may be reused multiple times in the segmentation.
        
    Example 1:    
    Input: s = "leetcode", wordDict = ["leet","code"]
    Output: true
    Explanation: Return true because "leetcode" can be segmented as "leet code".

    Example 2:    
    Input: s = "applepenapple", wordDict = ["apple","pen"]
    Output: true
    Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
    Note that you are allowed to reuse a dictionary word.

    Example 3:    
    Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
    Output: false
*/


import java.util.*;

public class Word_Break {
    static HashMap<String, Boolean> map = new HashMap<String,Boolean>();

    public static boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0) return true;

        if(map.containsKey(s) && !map.get(s)) return false;
        for(String str:wordDict){
            int len = str.length();
            if(s.indexOf(str) == 0){
                if(wordBreak(s.substring(len),wordDict)){
                    return true;
                }
            }
        }
        map.put(s,false);
        return false;
    }
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s, wordDict));
    }
}
