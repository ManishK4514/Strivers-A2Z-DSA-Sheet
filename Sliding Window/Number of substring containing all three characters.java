/*
   1358. Number of Substrings Containing All Three Characters
   Given a string s consisting only of characters a, b and c.
   
   Return the number of substrings containing at least one occurrence of all these    characters a, b and c.
   
    
   
   Example 1:
   
   Input: s = "abcabc"
   Output: 10
   Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
   Example 2:
   
   Input: s = "aaacb"
   Output: 3
   Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
   Example 3:
   
   Input: s = "abc"
   Output: 1
 */


public class Number_of_Substrings_Containing_All_Three_Characters {
    public static int numberOfSubstrings(String s) {
        /*
           // BruteForce Approach: We will to generate all the possible subStirng and among then we will check, How many are the Substring which contains 'a' & 'b' & 'c' and we will return the count of the Substring.

           // Time Complexity: O(N^2) & Space Complexity: O(N);

           String str;
           int count = 0;
           for(int i = 0; i < s.length(); i++){
               str = "";
               for(int j = i; j < s.length(); j++){
                   str += s.charAt(j);
                   if(str.contains("a") && str.contains("b") && str.contains("c")){
                       count++;
                   }
               }
           }
           return count;
        */
        
        /* 
            // Solution 2:
            int count[] = {0, 0, 0}, res = 0 , i = 0, n = s.length();
            for (int j = 0; j < n; j++) {
                count[s.charAt(j) - 'a']++;
                while (count[0] > 0 && count[1] > 0 && count[2] > 0){
                    count[s.charAt(i++) - 'a']--;
                }
                res += i;
            }
            return res;
        */

        // Optimized Approach: Using Sliding Window *Explanation(https://www.youtube.com/watch?v=VNL2VhDxj7U)
        int count = 0;
        int idx_a = -1, idx_b = -1, idx_c = -1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a'){
                idx_a = i;
            }
            else if(s.charAt(i) == 'b'){
                idx_b = i;
            }
            else{
                idx_c = i;
            }
            if(i > 1){
                int min = Math.min(idx_a, idx_b);
                min = Math.min(min, idx_c);
                count += min + 1;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }
}
