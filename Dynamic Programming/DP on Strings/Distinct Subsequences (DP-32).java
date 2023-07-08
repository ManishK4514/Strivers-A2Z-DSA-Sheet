/*
    Q. Distinct Subsequences| (DP-32)

    Practice : https://leetcode.com/problems/distinct-subsequences/description/

    Given two strings s and t, return the number of distinct subsequences of s which equals t.

    The test cases are generated so that the answer fits on a 32-bit signed integer.

    Example 1:
    
    Input: s = "rabbbit", t = "rabbit"
    Output: 3
    Explanation:
    As shown below, there are 3 ways you can generate "rabbit" from s.
    rabbbit
    rabbbit
    rabbbit
    Example 2:
    
    Input: s = "babgbag", t = "bag"
    Output: 5
    Explanation:
    As shown below, there are 5 ways you can generate "bag" from s.
    babgbag
    babgbag
    babgbag
    babgbag
    babgbag
*/

// import java.util.Arrays;

public class Distinct_Subsequences {
    /*
       // Recursion
       public static int helper(String s, String t, int i, int j){
           if(j < 0) return 1;
           if(i < 0) return 0;
           
           if(s.charAt(i) == t.charAt(j)){
               // max of take or notTake(if characters are same)
               return  helper(s, t, i - 1, j - 1) + helper(s, t, i - 1, j) ;
           }
           else return helper(s, t, i - 1, j);
       }
   
       public static int numDistinct(String s, String t) {
           int n = s.length(), m = t.length();
           return helper(s, t, n - 1, m - 1);
       }
    */

    /*
       // Memoization
       public static int helper(String s, String t, int i, int j, int[][] dp){
           if(j < 0) return 1;
           if(i < 0) return 0;
   
           if(dp[i][j] != -1) return dp[i][j];
           
           if(s.charAt(i) == t.charAt(j)){
               // max of take or notTake(if characters are same)
               return dp[i][j] = helper(s, t, i - 1, j - 1, dp) 
                                 + helper(s, t, i - 1, j, dp) ;
           }
           else return dp[i][j] = helper(s, t, i - 1, j, dp);
       }
       public static int numDistinct(String s, String t) {
           int n = s.length(), m = t.length();
           int[][] dp = new int[n][m];
           for(int[] it : dp) Arrays.fill(it, -1);
   
           return helper(s, t, n - 1, m - 1, dp);
       }

       // As the base case is if(j < 0) return 1 & if(i < 0) return 0, but for tabulation we can't go at negative index so we will shift every index to the 1-right

       public static int helper(String s, String t, int i, int j, int[][] dp){
           if(j == 0) return 1;
           if(i == 0) return 0;
   
           if(dp[i][j] != -1) return dp[i][j];
   
           if(s.charAt(i - 1) == t.charAt(j - 1)){
               // max of take or notTake(if characters are same)
               return dp[i][j] = helper(s, t, i - 1, j - 1, dp) 
                                 + helper(s, t, i - 1, j, dp) ;
           }
           else return dp[i][j] = helper(s, t, i - 1, j, dp);
       }
   
       public static int numDistinct(String s, String t) {
           int n = s.length(), m = t.length();
           int[][] dp = new int[n + 1][m + 1];
           for(int[] it : dp) Arrays.fill(it, -1);
   
           return helper(s, t, n, m, dp);
       }
    */

    /*
       // Tabulation
       public static int numDistinct(String s, String t) {
           int n = s.length(), m = t.length();
           int[][] dp = new int[n + 1][m + 1];
   
           for(int i = 0; i <= n; i++) dp[i][0] = 1;
   
           for(int i = 1; i <= n; i++){
               for(int j = 1; j <= m; j++){
                   if(s.charAt(i - 1) == t.charAt(j - 1)){
                       // max of take or notTake(if characters are same)
                       dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                   }
                   else dp[i][j] = dp[i - 1][j];
               }
           }
           return dp[n][m];
       }
    */

    /*
       // Space Optimization  -> (2 Array)

       public static int numDistinct(String s, String t) {
           int n = s.length(), m = t.length();
           int[] prev = new int[m + 1];
           int[] curr = new int[m + 1];
   
           prev[0] = curr[0] = 1;
   
           for(int i = 1; i <= n; i++){
               for(int j = 1; j <= m; j++){
                   if(s.charAt(i - 1) == t.charAt(j - 1)){
                       // max of take or notTake(if characters are same)
                       curr[j] = prev[j - 1] + prev[j];
                   }
                   else curr[j] = prev[j];
               }
               prev = curr.clone();
           }
           return prev[m];
       }
    */
    
    // Space Optimization  (1 - Array)
    
    public static int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[] dp = new int[m + 1];
        
        // base case
        dp[0] = 1;

        for(int i = 1; i <= n; i++){
            // we have to move j in reverse so that values in dp can't be overriden
            for(int j = m; j >= 1; j--){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    // max of take or notTake(if characters are same)
                    dp[j] = dp[j - 1] + dp[j];
                }
                // else not required (dp[j] = dp[j]) no sense of doing this
            }
        }
        return dp[m];
    }    

    public static void main(String[] args) {
        String s = "babgbag", t = "bag";
        System.out.println(numDistinct(s, t));
    }
}
