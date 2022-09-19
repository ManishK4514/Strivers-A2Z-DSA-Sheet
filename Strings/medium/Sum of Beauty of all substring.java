/*
   he beauty of a string is the difference in frequencies between the most frequent and least frequent characters.

   For example, the beauty of "abaacc" is 3 - 1 = 2.
   Given a string s, return the sum of beauty of all of its substrings.

   Example 1:
   
   Input: s = "aabcb"
   Output: 5
   Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
   
   Example 2:
   
   Input: s = "aabcbaa"
   Output: 17
*/


import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class Sum_of_Beauty_of_All_Substrings {
    public static int findBeauty2(int[] cnt){
        int max = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++){
            max = Math.max(max, cnt[i]);
            if(cnt[i] >= 1){
                min = Math.min(min, cnt[i]);
            }
        }
        return max - min;
    }
    public static int findBeauty(String str){
        if(str.length() == 0){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }
            else{
                map.put(str.charAt(i), 1); 
            }
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            max = Math.max(entry.getValue(), max);
            min = Math.min(entry.getValue(), min);
        }
        return max - min;
    }
    public static int beautySum(String s) {
        /*
           BruteForce Appraoch: Time complexity: O(N^3) & Space complexity: O(N).
           int beauty = 0;
           for(int i = 0; i < s.length(); i++){
               for(int j = i; j < s.length(); j++){
                   beauty += findBeauty(s.substring(i, j + 1));
               }
           }
           return beauty;
        */
        
        // Optimized Appraoch: Time complexity: O(N^2) & Space Complexity: O(1).
        int beauty = 0;
        int cnt[] = new int[26];
        for(int i = 0; i < s.length(); i++){
            Arrays.fill(cnt, 0);
            for(int j = i; j < s.length(); j++){
                cnt[s.charAt(j) - 'a']++;
                beauty += findBeauty2(cnt); // This is using another function
            }
        }
        return beauty;
    }
    public static void main(String[] args) {
        String s = "aabcb";
        System.out.println(beautySum(s));
    }
}
