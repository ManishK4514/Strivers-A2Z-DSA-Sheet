/*
 * Given a string of lowercase alphabets, count all possible substrings (not necessarily distinct) that have exactly k distinct characters. 


   Example 1:
   
   Input:
   S = "aba", K = 2
   Output:
   3
   Explanation:
   The substrings are:
   "ab", "ba" and "aba".
   
   Example 2:
   
   Input: 
   S = "abaaca", K = 1
   Output:
   7
   Explanation:
   The substrings are:
   "a", "b", "a", "aa", "a", "c", "a". 
*/


import java.util.Arrays;

public class Count_number_of_substrings {
    public static int substrCount (String str, int k) {
        // Time complexity: O(N^2) & Space complexity: O(1).

        int result = 0 ;
        int n = str.length();
        int cnt[] = new int[26];
        for(int i = 0; i < n; i++){
            int dist_count = 0 ;
            Arrays.fill(cnt, 0);
            for (int j = i; j < n ; j++ ){
                if(cnt[str.charAt(j) - 'a'] == 0){
                    dist_count++;
                }
                cnt[str.charAt(j) - 'a']++;
                if(dist_count == k){
                    result++;
                }
            }
        } 
        return result;
    }
    public static void main(String[] args) {
        String s = "abaaca";
        int k = 1;
        System.out.println(substrCount(s, k));
    }
}
