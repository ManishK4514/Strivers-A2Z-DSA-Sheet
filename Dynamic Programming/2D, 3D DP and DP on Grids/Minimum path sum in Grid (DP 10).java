/*
    Q. Minimum Path Sum In a Grid (DP 10)
    Practice : https://leetcode.com/problems/minimum-path-sum/description/
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.
         
    Example 1:
       
    Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
    Output: 7
    Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
    Example 2:
    
    Input: grid = [[1,2,3],[4,5,6]]
    Output: 12
*/

// import java.util.Arrays;

public class Minimum_path_sum_in_Grid {
    /*
       // Recursion
       public static int helper(int[][] grid, int row, int col){
           if(row == 0 && col == 0) return grid[row][col];
           if(row < 0 || col < 0) return Integer.MAX_VALUE;
   
           int up = helper(grid, row - 1, col);
           int left = helper(grid, row, col - 1);
   
           return grid[row][col] + Math.min(up, left);
       }
       public static int minPathSum(int[][] grid) {
           int n = grid.length;
           int m = grid[0].length;
           return helper(grid, n - 1, m - 1);
       }
    */

    /*
       // Memoization
       public static int helper(int[][] grid, int row, int col, int[][] dp){
           if(row == 0 && col == 0) return grid[row][col];
           if(row < 0 || col < 0) return Integer.MAX_VALUE;
           
           if(dp[row][col] != -1) return dp[row][col];
   
           int up = helper(grid, row - 1, col, dp);
           int left = helper(grid, row, col - 1, dp);
   
           return dp[row][col] = grid[row][col] + Math.min(up, left);
       }
       public static int minPathSum(int[][] grid) {
           int n = grid.length;
           int m = grid[0].length;
           int[][] dp = new int[n][m];
           for(int[] it : dp) Arrays.fill(it, -1);
           return helper(grid, n - 1, m - 1, dp);
       }
    */
    
    // Tabulation
    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(row == 0 && col == 0) dp[row][col] = grid[row][col];
                else{
                    int up = (int)1e9, left = (int)1e9;
                    if(row > 0) up = dp[row - 1][col];
                    if(col > 0) left = dp[row][col - 1];
                    dp[row][col] = grid[row][col] + Math.min(up, left);
                }
            }
        }
        return dp[n - 1][m - 1];
    }
    
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
}
