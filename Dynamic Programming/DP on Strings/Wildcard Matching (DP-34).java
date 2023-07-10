/*
    Q. Wildcard Matching | (DP-34)

    Practice : https://leetcode.com/problems/wildcard-matching/description/

    Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

    '?' Matches any single character.
    '*' Matches any sequence of characters (including the empty sequence).
    The matching should cover the entire input string (not partial).

    Example 1:
    
    Input: s = "aa", p = "a"
    Output: false
    Explanation: "a" does not match the entire string "aa".
    Example 2:
    
    Input: s = "aa", p = "*"
    Output: true
    Explanation: '*' matches any sequence.
    Example 3:
    
    Input: s = "cb", p = "?a"
    Output: false
    Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
*/

// import java.util.Arrays;

public class Wildcard_Matching {

    /*
       // My Primary Solution
       public static boolean helper(int i, int j, String s, String p, Boolean[][] dp){
           if(i < 0 && j < 0) return true;
           else if(i < 0) {
               while(j >= 0) {
                   if(p.charAt(j--) != '*') return false;
               } 
               return true;
           }
           else if(j < 0) return false;
   
           if(dp[i][j] != null) return dp[i][j];
   
           if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
               boolean curr = helper(i - 1, j - 1, s, p, dp);
               if(curr) return true;
           }
           else if(p.charAt(j) == '*'){
               boolean curr = helper(i, j - 1, s, p, dp);
               if(curr) return true;
   
               for(int k = i; k >= 0; k--){
                   curr = helper(k - 1, j - 1, s, p, dp);
                   if(curr) return true;
               }
           }    
           return dp[i][j] = false;    
       }
       public static boolean isMatch(String s, String p) {
           int n = s.length();
           int m = p.length();
           Boolean[][] dp = new Boolean[n][m];
           return helper(n - 1, m - 1, s, p, dp);
       }
    */

    /*
       // Recursion
       public static boolean isAllStars(String p, int idx){
           while(idx >= 0) {
               if(p.charAt(idx--) != '*') return false;
           } 
           return true;
       }
   
       public static boolean helper(int i, int j, String s, String p){
           if(i < 0 && j < 0) return true;
           else if(i < 0 && j >= 0) return isAllStars(p, j);
           else if(j < 0 && i >= 0) return false;
   
           if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
               return helper(i - 1, j - 1, s, p);
           }
           else if(p.charAt(j) == '*'){
               return helper(i, j - 1, s, p) || helper(i - 1, j, s, p);
           }    
           return false;    
       }
   
       public static boolean isMatch(String s, String p) {
           int n = s.length();
           int m = p.length();
           return helper(n - 1, m - 1, s, p);
       }
    */

    /*
       // Memoization
       public static boolean isAllStars(String p, int idx){
           while(idx >= 0) {
               if(p.charAt(idx--) != '*') return false;
           } 
           return true;
       }
   
       public static boolean helper(int i, int j, String s, String p, Boolean[][] dp){
           if(i < 0 && j < 0) return true;
           else if(i < 0 && j >= 0) return isAllStars(p, j);
           else if(j < 0 && i >= 0) return false;
   
           if(dp[i][j] != null) return dp[i][j];
   
           if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
               return dp[i][j] = helper(i - 1, j - 1, s, p, dp);
           }
           else if(p.charAt(j) == '*'){
               return dp[i][j] = helper(i, j - 1, s, p, dp) || helper(i - 1, j, s, p, dp);
           }    
           return dp[i][j] = false;    
       }
   
       public static boolean isMatch(String s, String p) {
           int n = s.length();
           int m = p.length();
           Boolean[][] dp = new Boolean[n][m];
           return helper(n - 1, m - 1, s, p, dp);
       }

       // As the base case is if(i < 0 || j < 0) return 0, but for tabulation we can't go at negative index so we will shift every index to the 1-right

       public static boolean isAllStars(String p, int idx){
           while(idx > 0) {
               if(p.charAt(idx - 1) != '*') return false;
               idx--;
           } 
           return true;
       }
       
       public static boolean helper(int i, int j, String s, String p, Boolean[][] dp){
           if(i == 0 && j == 0) return true;
           else if(i == 0 && j > 0) return isAllStars(p, j);
           else if(j == 0 && i > 0) return false;
   
           if(dp[i][j] != null) return dp[i][j];
   
           if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
               return dp[i][j] = helper(i - 1, j - 1, s, p, dp);
           }
           else if(p.charAt(j - 1) == '*'){
               return dp[i][j] = helper(i, j - 1, s, p, dp) || helper(i - 1, j, s, p, dp);
           }    
           return dp[i][j] = false;    
       }
   
       public static boolean isMatch(String s, String p) {
           int n = s.length();
           int m = p.length();
   
           // shifting to the right by 1-index
           Boolean[][] dp = new Boolean[n + 1][m + 1];
           return helper(n, m, s, p, dp);
       }
    */

    /*
       // Tabulation
       public static boolean isAllStars(String p, int idx){
           while(idx > 0) {
               if(p.charAt(idx - 1) != '*') return false;
               idx--;
           } 
           return true;
       }
       
       public static boolean isMatch(String s, String p) {
           int n = s.length();
           int m = p.length();
   
           // shifting to the right by 1-index
           boolean[][] dp = new boolean[n + 1][m + 1];
           
           // base cases
           dp[0][0] = true;
           for(int i = 0; i <= n; i++) dp[i][0] = false;
           for(int j = 0; j <= m; j++) dp[0][j] = isAllStars(p, j);
   
           for(int i = 1; i <= n; i++){
               for(int j = 1; j <= m; j++){
                   if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                       dp[i][j] = dp[i - 1][j - 1];
                   }
                   else if(p.charAt(j - 1) == '*'){
                       dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                   }    
                   else dp[i][j] = false;  
               }
           }
   
           return dp[n][m];
       }
    */
    
    // Space Optimization  

    public static boolean isAllStars(String p, int idx){
        while(idx > 0) {
            if(p.charAt(idx - 1) != '*') return false;
            idx--;
        } 
        return true;
    }
    
    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        // shifting to the right by 1-index
        boolean[] prev = new boolean[m + 1];
        boolean[] curr = new boolean[m + 1];
        
        // base cases
        prev[0] = true;
        for (int j = 0; j <= m; j++) prev[j] = isAllStars(p, j);

        for(int i = 1; i <= n; i++){
            curr[0] = false;
            for(int j = 1; j <= m; j++){
                curr[0] = isAllStars(p, j);
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                    curr[j] = prev[j - 1];
                }
                else if(p.charAt(j - 1) == '*'){
                    curr[j] = curr[j - 1] || prev[j];
                }    
                else curr[j] = false;  
            }
            prev = curr.clone();
        }

        return prev[m];
    }
    
    public static void main(String[] args) {
        String s = "abcabczzzde", p = "*abc???de*";
        System.out.println(isMatch(s, p));
    }
}
