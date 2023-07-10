/*
    Q. Edit Distance | (DP-33)

    Practice : https://leetcode.com/problems/edit-distance/description/

    Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

    You have the following three operations permitted on a word:
    
    Insert a character
    Delete a character
    Replace a character

    Example 1:
    
    Input: word1 = "horse", word2 = "ros"
    Output: 3
    Explanation: 
    horse -> rorse (replace 'h' with 'r')
    rorse -> rose (remove 'r')
    rose -> ros (remove 'e')
    
    Example 2:
    
    Input: word1 = "intention", word2 = "execution"
    Output: 5
    Explanation: 
    intention -> inention (remove 't')
    inention -> enention (replace 'i' with 'e')
    enention -> exention (replace 'n' with 'x')
    exention -> exection (replace 'n' with 'c')
    exection -> execution (insert 'u')
*/

// import java.util.Arrays;

public class Edit_Distance {

    /*
       // Primary Code with detailed Explaination
       public static int helper(String word1, String word2, int i, int j, int[][] dp){
           // base case
           if(i < 0) {
               // if i will be exausted then we have to insert j + 1 charcters in starting of the word1
               return j + 1;
           }
           if(j < 0) {
               // if j will be exausted then we have to delete i + 1 charcters from starting of the word1
               return i + 1;
           }
   
           if(dp[i][j] != -1) return dp[i][j];
   
           if(word1.charAt(i) == word2.charAt(j)) {
               // if characters are same no need to do operation  
               return dp[i][j] = helper(word1, word2, i - 1, j - 1, dp);
           }
           else{
               int ans = (int)(1e9);
   
               // replace
               ans = Math.min(ans, helper(word1, word2, i - 1, j - 1, dp));
               
               // insert 
               ans = Math.min(ans, helper(word1, word2, i, j - 1, dp));
               
               // delete
               ans = Math.min(ans, helper(word1, word2, i - 1, j, dp));
               
               return dp[i][j] = 1 + ans;
           }
       }
    */

    /*
       // Recursion
       public static int helper(String word1, String word2, int i, int j){
           if(i < 0) return j + 1;
           if(j < 0) return i + 1;
   
           if(word1.charAt(i) == word2.charAt(j)) {
               return helper(word1, word2, i - 1, j - 1);
           }
           return 1 + Math.min(helper(word1, word2, i - 1, j - 1), Math.min(helper(word1, word2, i, j - 1), helper(word1, word2, i - 1, j)));
       }
    
       public static int minDistance(String word1, String word2) {
           int n = word1.length();
           int m = word2.length();
           return helper(word1, word2, n - 1, m - 1);
       }
    */

    /*
       // Memoization
       public static int helper(String word1, String word2, int i, int j, int[][] dp){
           if(i < 0) return j + 1;
           if(j < 0) return i + 1;
   
           if(dp[i][j] != -1) return dp[i][j];
   
           if(word1.charAt(i) == word2.charAt(j)) {
               return dp[i][j] = helper(word1, word2, i - 1, j - 1, dp);
           }
           return dp[i][j] = 1 + Math.min(helper(word1, word2, i - 1, j - 1, dp), Math.min(helper(word1, word2, i, j - 1, dp), helper(word1, word2, i - 1, j, dp)));
       }
       public static int minDistance(String word1, String word2) {
           int n = word1.length();
           int m = word2.length();
           int[][] dp = new int[n][m];
           for(int[] it : dp) Arrays.fill(it, -1);
           return helper(word1, word2, n - 1, m - 1, dp);
       }

       // As the base case is if(i < 0 || j < 0) return 0, but for tabulation we can't go at negative index so we will shift every index to the 1-right

       public static int helper(String word1, String word2, int i, int j, int[][] dp){
           if(i == 0) return j;
           if(j == 0) return i;
   
           if(dp[i][j] != -1) return dp[i][j];
   
           if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
               return dp[i][j] = helper(word1, word2, i - 1, j - 1, dp);
           }
           return dp[i][j] = 1 + Math.min(helper(word1, word2, i - 1, j - 1, dp), Math.min(helper(word1, word2, i, j - 1, dp), helper(word1, word2, i - 1, j, dp)));
       }
   
       public static int minDistance(String word1, String word2) {
           int n = word1.length();
           int m = word2.length();
           int[][] dp = new int[n + 1][m + 1];
           for(int[] it : dp) Arrays.fill(it, -1);
           return helper(word1, word2, n, m, dp);
       }
    */

    /*
       // Tabulation
       public static int minDistance(String word1, String word2) {
           int n = word1.length();
           int m = word2.length();
           int[][] dp = new int[n + 1][m + 1];
   
           for(int j = 0; j <= m; j++) dp[0][j] = j;
           for(int i = 0; i <= n; i++) dp[i][0] = i;
   
           for(int i = 1; i <= n; i++){
               for(int j = 1; j <= m; j++){
                   if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                       dp[i][j] = dp[i - 1][j - 1];
                   }
                   else dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
               }
           }
   
           return dp[n][m];
       }
    */
    
    // Space Optimization  
    
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] prev = new int [m + 1];
        int[] curr = new int [m + 1];

        for(int j = 0; j <= m; j++) prev[j] = j;

        for(int i = 1; i <= n; i++){
            curr[0] = i;
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                }
                else curr[j] = 1 + Math.min(prev[j - 1], Math.min(curr[j - 1], prev[j]));
            }
            prev = curr.clone();
        }

        return prev[m];
    }
    
    public static void main(String[] args) {
        String word1 = "intention", word2 = "execution";
        System.out.println(minDistance(word1, word2));
    }
}
