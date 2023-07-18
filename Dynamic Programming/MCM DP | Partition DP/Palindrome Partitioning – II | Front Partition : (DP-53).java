/*
    Q. Palindrome Partitioning – II | Front Partition : DP 53

    Practice : https://leetcode.com/problems/palindrome-partitioning-ii/

    Given a string s, partition s such that every substring of the partition is a palindrome.
   
    Return the minimum cuts needed for a palindrome partitioning of s.

    Example 1:
    
    Input: s = "aab"
    Output: 1
    Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

    Example 2:
    
    Input: s = "a"
    Output: 0
    Example 3:
    
    Input: s = "ab"
    Output: 1
*/

// import java.util.Arrays;

public class Palindrome_Partitioning_II {
    /*
       // My Initial Approach

        // front partition
        public static int helper(String s, int i, int[] dp, boolean[][] isPalindrome) {
            if (i == s.length() || isPalindrome[i][s.length() - 1]) return 0;
    
            if(dp[i] != -1) return dp[i];
    
            int min = (int) 1e9;
                    
            for(int k = i; k < s.length(); k++){
                // partition
                if(isPalindrome[i][k]){
                    min = Math.min(min, 1 + helper(s, k + 1, dp, isPalindrome));
                }
            }
           
            return dp[i] = min;
        }
    
        public static int minCut(String s) {
            int n = s.length();
            int[] dp = new int[n];
            Arrays.fill(dp, -1);
    
            boolean[][] isPalindrome = new boolean[n][n];
    
            // Single character substrings are palindromes
            for (int i = 0; i < n; i++) {
                isPalindrome[i][i] = true;
            }
    
            // Check palindromes of length 2 or more
            for (int len = 2; len <= n; len++) {
                for (int start = 0; start <= n - len; start++) {
                    int end = start + len - 1;
    
                    // Check if the substring is a palindrome
                    if (s.charAt(start) == s.charAt(end)) {
                        if (len == 2 || isPalindrome[start + 1][end - 1]) {
                            isPalindrome[start][end] = true;
                        }
                    }
                }
            }
    
            return helper(s, 0, dp, isPalindrome);
        }
    */

    /*
       // Recursion

        public static int helper(String s, int i, boolean[][] isPalindrome) {
            if (i == s.length() || isPalindrome[i][s.length() - 1]) return 0;
    
            int min = (int) 1e9;
                    
            for(int k = i; k < s.length(); k++){
                // partition
                if(isPalindrome[i][k]){
                    min = Math.min(min, 1 + helper(s, k + 1, isPalindrome));
                }
            }
           
            return min;
        }
    
        public static int minCut(String s) {
            int n = s.length();
            boolean[][] isPalindrome = new boolean[n][n];
    
            for(int g = 0; g < s.length(); g++){
                for(int i = 0, j = g; j < isPalindrome.length; i++, j++){
                    if(g == 0){
                        isPalindrome[i][j] = true;
                    }
                    else if(g == 1){
                        isPalindrome[i][j] = s.charAt(i) == s.charAt(j);
                    }
                    else{
                        if(s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1] == true){
                            isPalindrome[i][j] = true;
                        }
                    }
                }
            }
            return helper(s, 0, isPalindrome);
        }
    */

    /*
       // Memoization

        public static int helper(String s, int i, int[] dp, boolean[][] isPalindrome) {
            if (i == s.length() || isPalindrome[i][s.length() - 1]) return 0;
    
            if(dp[i] != -1) return dp[i];
    
            int min = (int) 1e9;
                    
            for(int k = i; k < s.length(); k++){
                // partition
                if(isPalindrome[i][k]){
                    min = Math.min(min, 1 + helper(s, k + 1, dp, isPalindrome));
                }
            }
           
            return dp[i] = min;
        }
    
        public static int minCut(String s) {
            int n = s.length();
            int[] dp = new int[n];
            Arrays.fill(dp, -1);
    
            boolean[][] isPalindrome = new boolean[n][n];
    
            for(int g = 0; g < s.length(); g++){
                for(int i = 0, j = g; j < isPalindrome.length; i++, j++){
                    if(g == 0){
                        isPalindrome[i][j] = true;
                    }
                    else if(g == 1){
                        isPalindrome[i][j] = s.charAt(i) == s.charAt(j);
                    }
                    else{
                        if(s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1] == true){
                            isPalindrome[i][j] = true;
                        }
                    }
                }
            }
            return helper(s, 0, dp, isPalindrome);
        }
    */

    // Tabulation
    
    public static int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        boolean[][] isPalindrome = new boolean[n][n];

        for(int g = 0; g < s.length(); g++){
            for(int i = 0, j = g; j < isPalindrome.length; i++, j++){
                if(g == 0){
                    isPalindrome[i][j] = true;
                }
                else if(g == 1){
                    isPalindrome[i][j] = s.charAt(i) == s.charAt(j);
                }
                else{
                    if(s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1] == true){
                        isPalindrome[i][j] = true;
                    }
                }
            }
        }

        for(int i = n - 1; i >= 0; i--){
            int min = (int) 1e9;
                
            for(int k = i; k < n; k++){
                // partition
                if(isPalindrome[i][k]){
                    min = Math.min(min, 1 + dp[k + 1]);
                }
            }
           
            dp[i] = min;
        }

        return dp[0] - 1;
    }
    
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(minCut(s));
    }
}
