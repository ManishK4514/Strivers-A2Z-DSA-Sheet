/*
    Q. 3-d DP : Ninja and his friends (DP-13)
    Practice : https://practice.geeksforgeeks.org/problems/chocolates-pickup/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=chocolates-pickup

    // This solution and example (Chocolates Pickup on gfg) is the same problem as Ninja and his friends

    You are given an r rows and c cols matrix grid representing a field of cherries where grid[i][j] represents the number of chocolates that you can collect from the (i, j) cell.

    You have two robots that can collect chocolates for you:
    
    Robot #1 is located at the top-left corner (0, 0), and
    Robot #2 is located at the top-right corner (0, cols - 1).
    Return the maximum number of chocolates collection using both robots by following the rules below:
    
    From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
    When any robot passes through a cell, It picks up all chocolates, and the cell becomes an empty cell.
    When both robots stay in the same cell, only one takes the chocolates.
    Both robots cannot move outside of the grid at any moment.
    Both robots should reach the bottom row in grid.
    Example:
    
    Input:
    r = 3, c = 4
    grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
    Output:
    24
    Explanation:
    Path of robot #1 and #2 are described in color green and blue respectively. Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12. Cherries taken by Robot #2, (1 + 5 + 5 + 1) = 12. Total of cherries: 12 + 12 = 24.
*/

import java.util.Arrays;

public class Ninja_and_his_friends {
    /*
       // Recursion
       public static int helper(int row, int col1, int col2, int[][] grid, int n, int m){
           if(col1 < 0 || col1 >= m || col2 < 0 || col2 >= m) return (int) -1e8;
           if(row == n - 1){
               if(col1 == col2) return grid[row][col1];
               return grid[row][col1] + grid[row][col2];
           }
           
           int max = Integer.MIN_VALUE;
           for(int dcol1 = -1; dcol1 <= 1; dcol1++){
               for(int dcol2 = -1; dcol2 <= 1; dcol2++){
                   int curr = 0;
                   if(col1 == col2) curr = grid[row][col1];
                   else curr = grid[row][col1] + grid[row][col2];
                   
                   curr += helper(row + 1, col1 + dcol1, col2 + dcol2, grid, n, m);
                   max = Math.max(max, curr);
               }
           }
           
           return max;
       }
       public static int solve(int n, int m, int grid[][]){
           return helper(0, 0, m - 1, grid, n, m);
       }
    */

    /*
       // Memoization
       public static int helper(int row, int col1, int col2, int[][] grid, int n, int m, int[][][] dp){
           if(col1 < 0 || col1 >= m || col2 < 0 || col2 >= m) return (int) -1e8;
           if(row == n - 1){
               if(col1 == col2) return grid[row][col1];
               return grid[row][col1] + grid[row][col2];
           }
           
           if(dp[row][col1][col2] != -1) return dp[row][col1][col2];
           
           int max = Integer.MIN_VALUE;
           for(int dcol1 = -1; dcol1 <= 1; dcol1++){
               for(int dcol2 = -1; dcol2 <= 1; dcol2++){
                   int curr = 0;
                   if(col1 == col2) curr = grid[row][col1];
                   else curr = grid[row][col1] + grid[row][col2];
                   
                   curr += helper(row + 1, col1 + dcol1, col2 + dcol2, grid, n, m, dp);
                   max = Math.max(max, curr);
               }
           }
           
           return dp[row][col1][col2] = max;
       }
       public static int solve(int n, int m, int grid[][]){
           int[][][] dp = new int[n + 1][m + 1][m + 1];
           for(int[][] row1 : dp) for(int[] row2 : row1) Arrays.fill(row2, -1);
           return helper(0, 0, m - 1, grid, n, m, dp);
       }
    */

    /*
       // Tabulation
       public static int solve(int n, int m, int grid[][]){
           int[][][] dp = new int[n + 1][m + 1][m + 1];
           
           // Base Case
           for(int j1 = 0; j1 < m; j1++){
               for(int j2 = 0; j2 < m; j2++){
                   if(j1 == j2) dp[n - 1][j1][j2] = grid[n - 1][j1];
                   else dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
               }
           }
           
           for(int row = n - 2; row >= 0; row--){
               for(int col1 = 0; col1 < m; col1++){
                   for(int col2 = 0; col2 < m; col2++){
                       int max = Integer.MIN_VALUE;
                       for(int dcol1 = -1; dcol1 <= 1; dcol1++){
                           for(int dcol2 = -1; dcol2 <= 1; dcol2++){
                               int curr = 0;
                               if(col1 == col2) curr = grid[row][col1];
                               else curr = grid[row][col1] + grid[row][col2];
                               
                               if(col1 + dcol1 >= 0 && col1 + dcol1 < m && col2 + dcol2 >= 0 && col2 + dcol2 < m)
                                curr += dp[row + 1][col1 + dcol1][col2 + dcol2];
                               else curr += (int) -1e8; 
                               max = Math.max(max, curr);
                           }
                       }
                       
                       dp[row][col1][col2] = max;
                   }
               }
           }
           return dp[0][0][m - 1];
       }
    */
    
    // Space Optimization
    public static int solve(int n, int m, int grid[][]){
        int[][] front = new int[m][m];
        int[][] curr = new int[m][m];
        
        // Base Case
        for(int j1 = 0; j1 < m; j1++){
            for(int j2 = 0; j2 < m; j2++){
                if(j1 == j2) front[j1][j2] = grid[n - 1][j1];
                else front[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }
        
        for(int row = n - 2; row >= 0; row--){
            for(int col1 = 0; col1 < m; col1++){
                for(int col2 = 0; col2 < m; col2++){
                    int max = Integer.MIN_VALUE;
                    for(int dcol1 = -1; dcol1 <= 1; dcol1++){
                        for(int dcol2 = -1; dcol2 <= 1; dcol2++){
                            int value = 0;
                            if(col1 == col2) value = grid[row][col1];
                            else value = grid[row][col1] + grid[row][col2];
                            
                            if(col1 + dcol1 >= 0 && col1 + dcol1 < m && col2 + dcol2 >= 0 && col2 + dcol2 < m)
                             value += front[col1 + dcol1][col2 + dcol2];
                            else value += (int) -1e8; 
                            max = Math.max(max, value);
                        }
                    }
                    
                    curr[col1][col2] = max;
                }
            }

            // front = curr (in java we can't do directly)
            for (int i = 0; i < m; i++) {
                front[i] = Arrays.copyOf(curr[i], m);
            }
        }
        return front[0][m - 1];
    }
    public static void main(String[] args) {
        int n = 4, m = 3;
        int[][] grid = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        System.out.println(solve(n, m, grid));
    }
}
