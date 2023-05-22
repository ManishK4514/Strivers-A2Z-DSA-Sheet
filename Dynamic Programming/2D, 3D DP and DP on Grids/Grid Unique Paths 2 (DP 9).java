/*
    Q. Grid Unique Paths 2 (DP 9)
    Practice : https://leetcode.com/problems/unique-paths-ii/description/
    You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

    An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
    
    Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
    
    The testcases are generated so that the answer will be less than or equal to 2 * 109.
    
    Example 1:    
    
    Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
    Output: 2
    Explanation: There is one obstacle in the middle of the 3x3 grid above.
    There are two ways to reach the bottom-right corner:
    1. Right -> Right -> Down -> Down
    2. Down -> Down -> Right -> Right
    Example 2:
        
    Input: obstacleGrid = [[0,1],[0,0]]
    Output: 1
*/

// import java.util.Arrays;

public class Minimum_path_sum_in_Grid {
    /*
       // Recursion
       public static int totalPaths(int row, int col, int[][] obstacleGrid){
           if(row < 0 || col < 0 || obstacleGrid[row][col] == 1) return 0;
           if(row == 0 && col == 0) return 1;
   
           int up = totalPaths(row - 1, col, obstacleGrid);
           int left = totalPaths(row, col - 1, obstacleGrid);
           return up + left;
       }
       public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
           int n = obstacleGrid.length;
           int m = obstacleGrid[0].length;
           return totalPaths(n - 1, m - 1, obstacleGrid);
       }
    */

    /*
       // Memoization
       public static int totalPaths(int row, int col, int[][] obstacleGrid, int[][] dp){
           if(row < 0 || col < 0 || obstacleGrid[row][col] == 1) return 0;
           if(row == 0 && col == 0) return 1;
           if(dp[row][col] != -1) return dp[row][col];
   
           int up = totalPaths(row - 1, col, obstacleGrid, dp);
           int left = totalPaths(row, col - 1, obstacleGrid, dp);
           return dp[row][col] = up + left;
       }
       public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
           int n = obstacleGrid.length;
           int m = obstacleGrid[0].length;
           int[][] dp = new int[n][m];
           for(int[] it : dp) Arrays.fill(it, -1);
           return totalPaths(n - 1, m - 1, obstacleGrid, dp);
       }
    */

    /*
       // Tabulation
       public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
           int n = obstacleGrid.length;
           int m = obstacleGrid[0].length;
           int[][] dp = new int[n][m];
           for(int row = 0; row < n; row++){
               for(int col = 0; col < m; col++){
                   if(obstacleGrid[row][col] == 1) dp[row][col] = 0;
                   else if(row == 0 && col == 0) dp[row][col] = 1;
                   else{
                       int up = 0, left = 0;
                       if(row > 0) up = dp[row - 1][col];
                       if(col > 0) left = dp[row][col - 1];
                       dp[row][col] = up + left;
                   }
               }
           }
           return dp[n - 1][m - 1];
       }
    */
    
    // Space Optimization
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] prev = new int [m];
        for(int row = 0; row < n; row++){
            int[] curr = new int[m];
            for(int col = 0; col < m; col++){
                if(obstacleGrid[row][col] == 1) curr[col] = 0;
                else if(row == 0 && col == 0) curr[col] = 1;
                else{
                    int up = 0, left = 0;
                    if(row > 0) up = prev[col];
                    if(col > 0) left = curr[col - 1];
                    curr[col] = up + left;
                }
            }
            prev = curr;
        }
        return prev[m - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }    
}
