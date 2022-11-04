/*
   Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.

   Example 1:
   
   Input:
   S = "aabacbebebe", K = 3
   Output: 7
   Explanation: "cbebebe" is the longest 
   substring with K distinct characters.
   
   Example 2:
   
   Input: 
   S = "aaaa", K = 2
   Output: -1
   Explanation: There's no substring with K
   distinct characters.
 */


import java.util.HashMap;

public class Longest_K_unique_characters_substring {
    public static int longestkSubstr(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, max = -1;
        for(int j = 0; j < s.length(); j++){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            while(map.size() > k){
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if(map.get(s.charAt(i)) == 0){
                    map.remove(s.charAt(i));
                }
                i++;
            }
            if(map.size() == k){
                max = Math.max(max, (j - i) + 1);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println(longestkSubstr(s, k));
    }
}
