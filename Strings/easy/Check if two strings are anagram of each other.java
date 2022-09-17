/*
 * Check if two Strings are anagrams of each other
   Problem Statement: Given two strings, check if two strings are anagrams of each other or not.
   
   Examples:
   
   Example 1:
   Input: CAT, ACT
   Output: true
   Explanation: Since the count of every letter of both strings are equal.
   
   Example 2:
   Input: RULES, LESRT 
   Output: false
   Explanation: Since the count of U and T  is not equal in both strings.
*/


// import java.util.HashMap;
import java.util.Arrays;

public class Valid_Anagram {
    public static String SortString(String str){
        char c[] = str.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
    public static boolean isAnagram(String s, String t) {
        /*
         * BruteForce approach: Time complexity: O(N^2) & Space complexity: O(1).
         * if(s.length() != t.length()){
               return false;
           }
           HashMap<Character, Integer> map = new HashMap<>();
           for(int i = 0; i < s.length(); i++){
               if(!map.containsKey(s.charAt(i))){
                   map.put(s.charAt(i), 1);
               }
               else{
                   map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
               }
           }
           int count = 0;
           for(int i = 0; i < s.length(); i++){
               char c = s.charAt(i);
               count = 0;
               for(int j = 0; j < t.length(); j++){
                   if(c == t.charAt(j)){
                       count++;
                   }
               }
               if(map.get(c) != count){
                   return false;
               }
           }
           return true;
        */
        
        /*
         * Solution 2: Time complexity: O(NlogN) & Space complexity: O(1).
         * if(s.length() != t.length()){
               return false;
           }
           s = SortString(s);
           t = SortString(t);
           
           for(int i = 0; i < s.length(); i++){
               if(s.charAt(i) != t.charAt(i)){
                   return false;
               }
           }
           return true;
        */
        
        /*

           // Solution 2: Time complexity: O(N) & Space complexity: O(1).

           if(s.length() != t.length())return false;
        
           HashMap<Character, Integer> map = new HashMap<>();
           for(int i = 0; i < s.length(); i++){
               if(map.containsKey(s.charAt(i))){
                   map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
               }
               else{
                   map.put(s.charAt(i), 1);
               }
           }
           for(int i = 0; i < t.length(); i++){
               if(!map.containsKey(t.charAt(i))){
                   return false;
               }
               else if(map.get(t.charAt(i)) == 1){
                   map.remove(t.charAt(i));
               }
               else{
                   map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
               }
           }
           return map.size() == 0;
        */

        // Optimized Approach: Time complexity: O(N) & Space compelxity: O(1).

        if (s.length() != t.length())return false;
     
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
          freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
          freq[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
          if (freq[i] != 0)
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
