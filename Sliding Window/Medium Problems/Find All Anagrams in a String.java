/*
   Q. Find All Anagrams in a String.
   Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

   An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
   
   Example 1:
   
   Input: s = "cbaebabacd", p = "abc"
   Output: [0,6]
   Explanation:
   The substring with start index = 0 is "cba", which is an anagram of "abc".
   The substring with start index = 6 is "bac", which is an anagram of "abc".

   Example 2:
   
   Input: s = "abab", p = "ab"
   Output: [0,1,2]
   Explanation:
   The substring with start index = 0 is "ab", which is an anagram of "ab".
   The substring with start index = 1 is "ba", which is an anagram of "ab".
   The substring with start index = 2 is "ab", which is an anagram of "ab".
 */


import java.util.List;
import java.util.ArrayList;

public class Find_All_Anagrams_in_a_String {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) return false;
        }
        return true;
    }
    public static boolean check(int[] phash, int[] hash){
        for(int i = 0; i < phash.length; i++){
            if(phash[i] != hash[i]){
                return false;
            }
        }
        return true;
    }
    public static List<Integer> findAnagrams(String s, String p) {
        /*
            // BruteForce Approach:
            int k = p.length();
            List<Integer> ans = new ArrayList<>();
            int i = 0;
            for (int j = k; j <= s.length(); j++) {
                boolean possible = isAnagram(s.substring(i, j), p);
                if (possible) {
                    ans.add(i);
                }
                i++;
            }
            return ans;
        */
        
        // Optimized Approach:

        List<Integer> ans = new ArrayList<>();
        if(s.length() < p.length()){
            return ans;            
        }
        int[] phash = new int[26];
        int[] hash = new int[26];
        int left = 0, right = 0, window = p.length();
        while(right < window){
            phash[p.charAt(right) - 'a']++;
            hash[s.charAt(right) - 'a']++;
            right++;
        }
        right -=1;
        while(right < s.length())
        {            
            boolean equal = check(phash, hash);
            if(equal)
            {
                ans.add(left);
            }
            right+=1;
            if(right != s.length())
            {
                hash[s.charAt(right) - 'a'] += 1;
            }
            hash[s.charAt(left) - 'a'] -=1 ;
            left += 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        String s =  "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }
}
