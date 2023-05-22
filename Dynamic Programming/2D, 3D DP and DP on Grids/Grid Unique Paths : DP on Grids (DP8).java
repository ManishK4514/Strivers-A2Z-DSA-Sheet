/*
    Q. Grid Unique Paths : DP on Grids (DP8)
    Practice : https://leetcode.com/problems/unique-paths/description/
    There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

    Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
    
    The test cases are generated so that the answer will be less than or equal to 2 * 109.
        
    Example 1:
        
    Input: m = 3, n = 7
    Output: 28
    Example 2:
    
    Input: m = 3, n = 2
    Output: 3
    Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
    1. Right -> Down -> Down
    2. Down -> Down -> Right
    3. Down -> Right -> Down
*/

// import java.util.Arrays;

public class Grid_Unique_Paths {
    /*
       // Recursion
       public static int totalPaths(int row, int col){
           if(row == 0 && col == 0) return 1;
           if(row < 0 || col < 0) return 0;
   
           int left = totalPaths(row, col - 1);
           int up = totalPaths(row - 1, col);
   
           return left + up;
       }
       public static int uniquePaths(int m, int n) {
           return totalPaths(m - 1, n - 1);
       }
    */

    /*
       // Memoization
       public static int totalPaths(int row, int col, int[][] dp){
           if(row == 0 && col == 0) return 1;
           if(row < 0 || col < 0) return 0;
           
           if(dp[row][col] != -1) return dp[row][col];
           
           int left = totalPaths(row, col - 1, dp);
           int up = totalPaths(row - 1, col, dp);
   
           return dp[row][col] = left + up;
       }
       public static int uniquePaths(int m, int n) {
           int[][] dp = new int[m + 1][n + 1];
           for(int[] it : dp) Arrays.fill(it, -1);
           return totalPaths(m - 1, n - 1, dp);
       }
    */

    /*
       // Tabulation
       public static int uniquePaths(int m, int n) {
           int[][] dp = new int[m][n];
           for(int row = 0; row < m; row++){
               for(int col = 0; col < n; col++){
                   if(row == 0 && col == 0) dp[row][col] = 1;
                   else{
                       int up = 0, left = 0;
                       if(row > 0) up = dp[row - 1][col];
                       if(col > 0) left = dp[row][col - 1];
                               
                       dp[row][col] = left + up;
                   }
               }
           }
           return dp[m - 1][n - 1];
       }
    */

    public static int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        for(int row = 0; row < m; row++){
            int[] curr = new int[n];
            for(int col = 0; col < n; col++){
                if(row == 0 && col == 0) curr[col] = 1;
                else{
                    int up = 0, left = 0;
                    if(row > 0) up = prev[col];
                    if(col > 0) left = curr[col - 1];
                            
                    curr[col] = left + up;
                }
            }
            prev = curr;
        }
        return prev[n - 1];
    }
    
    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(uniquePaths(m, n));
    }
}
