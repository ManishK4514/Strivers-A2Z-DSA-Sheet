/*
    Q. Minimum path sum in Triangular Grid (DP 11)
    Practice : https://leetcode.com/problems/triangle/description/
    Given a triangle array, return the minimum path sum from top to bottom.

    For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 
    Example 1:
    
    Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
    Output: 11
    Explanation: The triangle looks like:
       2
      3 4
     6 5 7
    4 1 8 3
    The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
    Example 2:
    
    Input: triangle = [[-10]]
    Output: -10
*/

import java.util.*;

public class Minimum_path_sum_in_Triangular_Grid {
    /*
       // Recursion
       public static int helper(List<List<Integer>> triangle, int i, int j){
           if(i == triangle.size() - 1) return triangle.get(triangle.size() - 1).get(j);
   
           int down = helper(triangle, i + 1, j);
           int diagonal = helper(triangle, i + 1, j + 1);
   
           return triangle.get(i).get(j) + Math.min(down, diagonal);
       }
       public static int minimumTotal(List<List<Integer>> triangle) {
           int n = triangle.size();
           int[][] dp = new int[n + 1][n + 1];
           for(int[] it : dp) Arrays.fill(it, -1);
           return helper(triangle, 0, 0);
       }
    */

    /*
       // Memoization
       public static int helper(List<List<Integer>> triangle, int i, int j, int[][] dp){
           if(i == triangle.size() - 1) return triangle.get(triangle.size() - 1).get(j);
   
           if(dp[i][j] != -1) return dp[i][j];
   
           int down = helper(triangle, i + 1, j, dp);
           int diagonal = helper(triangle, i + 1, j + 1, dp);
   
           return dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
       }
       public static int minimumTotal(List<List<Integer>> triangle) {
           int n = triangle.size();
           int[][] dp = new int[n + 1][n + 1];
           for(int[] it : dp) Arrays.fill(it, -1);
           return helper(triangle, 0, 0, dp);
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
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] front = new int[n];
        int[] curr = new int[n];
        for(int j = 0; j < n; j++) {
            front[j] = triangle.get(n - 1).get(j);
        }
        for(int i = n - 2; i >= 0; i--){            
            for(int j = i; j >= 0; j--){
                int down = triangle.get(i).get(j) + front[j];
                int diagonal = triangle.get(i).get(j) + front[j + 1];
            
                curr[j] = Math.min(down, diagonal);
            }
            front = curr.clone();
        }
        return front[0];
    }
    
    public static void main(String[] args) {
        int inpTriangle[][] = {{1},
                       {2, 3},
                       {3, 6, 7},
                       {8, 9, 6, 10}};

        int n = inpTriangle.length;
        List<List<Integer>> triangle = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < inpTriangle[i].length; j++) {
                row.add(inpTriangle[i][j]);
            }
            triangle.add(row);
        }

        System.out.println(minimumTotal(triangle));
    }
}
