/*
    Q. Minimum/Maximum Falling Path Sum (DP-12)
    Practice : https://leetcode.com/problems/minimum-falling-path-sum/description/
    Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

    A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
        
    Example 1:
        
    Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
    Output: 13
    Explanation: There are two falling paths with a minimum sum as shown.
    Example 2:
    
    
    Input: matrix = [[-19,57],[-40,-5]]
    Output: -59
    Explanation: The falling path with a minimum sum is shown.
*/

import java.util.Arrays;

public class Minimum_Falling_Path_Sum {
    /*
       // Recursion
       public static int findPath(int[][] matrix, int row, int col, int n){
           if(col < 0 || col >= n) return Integer.MAX_VALUE;
           if(row == 0) return matrix[row][col];
           
           int opt1 = findPath(matrix, row - 1, col - 1, n);
           int opt2 = findPath(matrix, row - 1, col, n);
           int opt3 = findPath(matrix, row - 1, col + 1, n); 
   
           return matrix[row][col] + Math.min(opt1, Math.min(opt2, opt3));
       }
       public static int minFallingPathSum(int[][] matrix) {
           int n = matrix.length;
           int ans = Integer.MAX_VALUE;
           for(int j = 0; j < n; j++){
               ans = Math.min(ans, findPath(matrix, n - 1, j, n));
           }
           return ans;
       }
    */

    /*
       // Memoization
       public static int findPath(int[][] matrix, int row, int col, int n, int[][] dp){
           if(col < 0 || col >= n) return Integer.MAX_VALUE;
           if(row == 0) return matrix[row][col];
           
           if(dp[row][col] != -1) return dp[row][col];
   
           int opt1 = findPath(matrix, row - 1, col - 1, n, dp);
           int opt2 = findPath(matrix, row - 1, col, n, dp);
           int opt3 = findPath(matrix, row - 1, col + 1, n, dp); 
   
           return dp[row][col] = matrix[row][col] + Math.min(opt1, Math.min(opt2, opt3));
       }
       public static int minFallingPathSum(int[][] matrix) {
           int n = matrix.length;
           int ans = Integer.MAX_VALUE;
           int[][] dp = new int[n][n];
           for(int[] it : dp) Arrays.fill(it, -1);
           for(int j = 0; j < n; j++){
               ans = Math.min(ans, findPath(matrix, n - 1, j, n, dp));
           }
           return ans;
       }
    */

    /*
       // Tabulation
       public static int minFallingPathSum(int[][] matrix) {
           int n = matrix.length;
           int[][] dp = new int[n][n];
           for(int i = 0; i < n; i++){
               for(int j = 0; j < n; j++){
                   if(i == 0) dp[i][j] = matrix[i][j];
                   else{
                       int opt1 = Integer.MAX_VALUE, opt2 = Integer.MAX_VALUE, opt3 = Integer.MAX_VALUE;
                       if(i - 1 >= 0 && j - 1 >= 0) opt1 = dp[i - 1][j - 1];
                       if(i - 1 >= 0) opt2 = dp[i - 1][j];
                       if(i - 1 >= 0 && j + 1 < n) opt3 = dp[i - 1][j + 1];
               
                       dp[i][j] = matrix[i][j] + Math.min(opt1, Math.min(opt2, opt3));
                   }
               }
           }
           int min = Integer.MAX_VALUE;
           for(int j = 0; j < n; j++){
               min = Math.min(min, dp[n - 1][j]);
           }
           return min;
       }
    */
    
    // Space Optimization
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] prev = new int[n];
        int[] curr = new int[n];
        for(int j=0; j<n; j++){
            prev[j] = matrix[0][j];
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                int opt1, opt2, opt3;
                opt1 = opt2 = opt3 = Integer.MAX_VALUE;
                if(j - 1 >= 0) opt1 = prev[j - 1];
                opt2 = prev[j];
                if(j + 1 < n) opt3 = prev[j + 1];
        
                curr[j] = matrix[i][j] + Math.min(opt1, Math.min(opt2, opt3));
            }
            prev = curr.clone();
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            min = Math.min(min, prev[j]);
        }
        return min;
    }
    public static void main(String[] args) {
        int[][]  matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(matrix));
    }
}

// Q. Maximum path sum in matrix
// Practice link: https://practice.geeksforgeeks.org/problems/path-in-matrix3805/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=path-in-matrix

class Solution{
    public static int findPath(int[][] matrix, int row, int col, int n, int[][] dp){
        if(col < 0 || col >= n) return Integer.MIN_VALUE;
        if(row == 0) return matrix[row][col];
        
        if(dp[row][col] != -1) return dp[row][col];

        int opt1 = findPath(matrix, row - 1, col - 1, n, dp);
        int opt2 = findPath(matrix, row - 1, col, n, dp);
        int opt3 = findPath(matrix, row - 1, col + 1, n, dp); 

        return dp[row][col] = matrix[row][col] + Math.max(opt1, Math.max(opt2, opt3));
    }
    static int maximumPath(int n, int matrix[][])
    {
        int ans = Integer.MIN_VALUE;
        int[][] dp = new int[n][n];
        for(int[] it : dp) Arrays.fill(it, -1);
        for(int j = 0; j < n; j++){
            ans = Math.max(ans, findPath(matrix, n - 1, j, n, dp));
        }
        return ans;
    }
}
