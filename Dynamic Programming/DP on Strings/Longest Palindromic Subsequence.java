/*
    Q. Longest Palindromic Subsequence | (DP-28)

    Practice : https://leetcode.com/problems/longest-common-subsequence/description/

    Given a string s, find the longest palindromic subsequence's length in s.

    A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
    
    Example 1:
    
    Input: s = "bbbab"
    Output: 4
    Explanation: One possible longest palindromic subsequence is "bbbb".
    Example 2:
    
    Input: s = "cbbd"
    Output: 2
    Explanation: One possible longest palindromic subsequence is "bb".
*/

// import java.util.Arrays;

import java.util.Arrays;

public class Longest_Palindromic_Subsequence {
    /*
       Method 1
       _________________________________________________________________

       // Recursion
       public static int helper(String s, int i, int j){
           if(i == j) return 1;
   
           // if there is string of size 2 and both character are equal
           if(j - i == 1 && s.charAt(i) == s.charAt(j)) return 2;
   
           // if first and last characters are equal
           if(s.charAt(i) == s.charAt(j)){
               return 2 + helper(s, i + 1, j - 1);
           }
   
           return Math.max(helper(s, i + 1, j), helper(s, i, j - 1));
       }
       public static int longestPalindromeSubseq(String s) {
           return helper(s, 0, s.length() - 1);
       }

    */
    
    // Memoization
    
    public static int helper(String s, int i, int j, int[][] dp){
        if(i == j) return 1;
   
        if(dp[i][j] != -1) return dp[i][j];
   
        // if length is 2 and both charcter are equals
        if((j - i + 1) == 2 && s.charAt(i) == s.charAt(j)) return 2;
        
        // if first and last characters are equal then call for the remaining string
        if(s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 2 + helper(s, i + 1, j - 1, dp);
        }
   
        return dp[i][j] = Math.max(helper(s, i + 1, j, dp), helper(s, i, j - 1, dp));
    }

    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] it : dp) Arrays.fill(it, -1);
        return helper(s, 0, n - 1, dp);
    }

    /*
        // Method 2 (Use lcs -> longest common subsequence)
        
        we have String 
        s = "bbabcbcab"

        let s1 = "bbabcbcab" and s2 = reverse(s1);

        s1 = "bbabcbcab"
        s2 = "bacbcbabb"

        find lcs to get the longest Palindrome Subsequences.
        
        Intution: Now the longest subsequnce will be the longest common subsequence 
                  because any other longest subtring will alter after reversing the string
                  except the palindromic substring because palindrom are same after reversing.

        code to find the lcs:          
        
        lcs: https://github.com/ManishK4514/Strivers-A2Z-DSA-Sheet/blob/main/Dynamic%20Programming/DP%20on%20Strings/Longest%20Common%20Subsequence.java          
    */

    

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }
}
