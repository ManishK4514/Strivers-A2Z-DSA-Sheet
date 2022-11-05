/*
    Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

    The testcases will be generated such that the answer is unique.

    Example 1:
    
    Input: s = "ADOBECODEBANC", t = "ABC"
    Output: "BANC"
    Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

    Example 2:
    
    Input: s = "a", t = "a"
    Output: "a"
    Explanation: The entire string s is the minimum window.

    Example 3:
    
    Input: s = "a", t = "aa"
    Output: ""
    Explanation: Both 'a's from t must be included in the window.
    Since the largest window of s only has one 'a', return empty string.
 */

import java.util.HashMap;
// import java.util.Map;

public class Minimum_Window_Substring {
    /* 
        Solution 1: BruteForce Approach: Time Complexity: O(N^2) & Space Complexity: O(2N).
        public static boolean search(String str, String target){       
            HashMap<Character, Integer> map1 = new HashMap<>();
            HashMap<Character, Integer> map2 = new HashMap<>();
            for(int i = 0; i < str.length(); i++){
                map1.put(str.charAt(i), map1.getOrDefault(str.charAt(i), 0) + 1);
            }
            for(int i = 0; i < target.length(); i++){
                map2.put(target.charAt(i), map2.getOrDefault(target.charAt(i), 0) + 1);
            }
            for(Map.Entry<Character, Integer> entry: map2.entrySet()){
                if(!map1.containsKey(entry.getKey())) return false;
                else if(map1.containsKey(entry.getKey()) && map1.get(entry.getKey()) < entry.getValue()) return false;
            }
            return true;
        }
        public static String minWindow(String s, String t) {
            if(s.length() < t.length()){
                return "";
            }
            String res = "";
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < s.length(); i++){
                StringBuilder sb = new StringBuilder();
                for(int j = i; j < s.length(); j++){
                    sb.append(s.charAt(j));
                    if(search(sb.toString(), t)){
                        if(min > sb.length()){
                            min = sb.length();
                            res = sb.toString();
                        }
                    }
                }
            }
            return res;
            
        }
    */

    public static String minWindow(String s, String t) {
        // Solution 2: Time Complexity: O(N) & Space Complexity: O(2N)
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        int i = 0, j = 0, mct = 0, dmct = t.length();
        String ans = "";
        while(true){
            boolean f1 = false;
            boolean f2 = false;

            while(j < s.length() && mct < dmct){
                map1.put(s.charAt(j), map1.getOrDefault(s.charAt(j), 0) + 1);
                if(map2.containsKey(s.charAt(j)) && map1.get(s.charAt(j)) <= map2.get(s.charAt(j))){
                    mct++;
                }
                j++;
                f1 = true;
            }
            while(i < j && mct == dmct){
                String temp = s.substring(i, j);
                if(ans.length() == 0 || ans.length() > temp.length()){
                    ans = temp;
                }

                map1.put(s.charAt(i), map1.get(s.charAt(i)) - 1);
                
                if(map2.containsKey(s.charAt(i)) && map1.get(s.charAt(i)) < map2.get(s.charAt(i))){
                    mct--;
                }
                i++;
                f2 = true;
            }
            if(!f1 && !f2){
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
