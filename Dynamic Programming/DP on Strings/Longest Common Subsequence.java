/*
    Q. Longest Common Subsequence | (DP – 25)

    Practice : https://leetcode.com/problems/longest-common-subsequence/description/

    Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

    A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
    
    For example, "ace" is a subsequence of "abcde".
    A common subsequence of two strings is a subsequence that is common to both strings.
      
    Example 1:
    
    Input: text1 = "abcde", text2 = "ace" 
    Output: 3  
    Explanation: The longest common subsequence is "ace" and its length is 3.
    Example 2:
    
    Input: text1 = "abc", text2 = "abc"
    Output: 3
    Explanation: The longest common subsequence is "abc" and its length is 3.
    Example 3:
    
    Input: text1 = "abc", text2 = "def"
    Output: 0
    Explanation: There is no such common subsequence, so the result is 0.
*/

// import java.util.Arrays;

public class Longest_Common_Subsequence {
    /*
       // Recursion
       public static int helper(String text1, String text2, int i, int j){
           if(i < 0 || j < 0) return 0;
           int ans;
   
           if(text1.charAt(i) == text2.charAt(j)){
               ans = 1 + helper(text1, text2, i - 1, j - 1);
           }
           else{
               ans = Math.max(helper(text1, text2, i - 1, j), helper(text1, text2, i,j - 1));
           }
           return ans;
       }
   
       public static int longestCommonSubsequence(String text1, String text2) {
           int n = text1.length(), m = text2.length();
           return helper(text1, text2, n - 1, m - 1);
       }
    */

    /*
       // Memoization
       public static int helper(String text1, String text2, int i, int j, int[][] dp){
           if(i < 0 || j < 0) return 0;
           int ans;
           if(dp[i][j] != -1) return dp[i][j];
           if(text1.charAt(i) == text2.charAt(j)){
               ans = 1 + helper(text1, text2, i - 1, j - 1, dp);
           }
           else{
               ans = Math.max(helper(text1, text2, i - 1, j, dp), helper(text1, text2, i,j - 1, dp));
           }
           return dp[i][j] = ans;
       }
   
       public static int longestCommonSubsequence(String text1, String text2) {
           int n = text1.length(), m = text2.length();
           int[][] dp = new int[text1.length()][text2.length()];
           for(int[] nums : dp){
               Arrays.fill(nums, -1);
           }
           return helper(text1, text2, n - 1, m - 1, dp);
       }

       // As the base case is if(i < 0 || j < 0) return 0, but for tabulation we can't go at negative index so we will shift every index to the 1-right

       public static int helper(String text1, String text2, int i, int j, int[][] dp){
           if(i == 0 || j == 0) return 0;
           int ans;
           if(dp[i][j] != -1) return dp[i][j];
           if(text1.charAt(i - 1) == text2.charAt(j - 1)){
               ans = 1 + helper(text1, text2, i - 1, j - 1, dp);
           }
           else{
               ans = Math.max(helper(text1, text2, i - 1, j, dp), helper(text1, text2, i,j - 1, dp));
           }
           return dp[i][j] = ans;
       }
       public int longestCommonSubsequence(String text1, String text2) {
           int n = text1.length(), m = text2.length();
           
           // shifting 1-index to the right
           int[][] dp = new int[n + 1][m + 1];
           for(int[] nums : dp) Arrays.fill(nums, -1);
   
           return helper(text1, text2, n, m, dp);
       }
    */

    /*
       // Tabulation
       public static int longestCommonSubsequence(String text1, String text2) {
           int n = text1.length(), m = text2.length();
   
           // shifting 1-index to the right        
           int[][] dp = new int[n + 1][m + 1];
           for(int[] it : dp) Arrays.fill(it, -1);
   
           for(int j = 0; j <= m; j++) dp[0][j] = 0;
           for(int i = 0; i <= n; i++) dp[i][0] = 0;
   
           for(int i = 1; i <= n; i++){
               for(int j = 1; j <= m; j++){
                   if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                       dp[i][j] = 1 + dp[i - 1][j - 1];
                   }
                   else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
               }
           }
   
           return dp[n][m];
       }

       // Also we can skip base case at dp already filled with zeros

       public int longestCommonSubsequence(String text1, String text2) {
           int n = text1.length(), m = text2.length();
   
           // shifting 1-index to the right        
           int[][] dp = new int[n + 1][m + 1];
   
           for(int i = 1; i <= n; i++){
               for(int j = 1; j <= m; j++){
                   if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                       dp[i][j] = 1 + dp[i - 1][j - 1];
                   }
                   else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
               }
           }
   
           return dp[n][m];
       }
    */
    
    // Space Optimization  
    
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();

        // shifting 1-index to the right        
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    curr[j] = 1 + prev[j - 1];
                }
                else curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            prev = curr.clone();
        }

        return prev[m];
    }
    

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }
}
