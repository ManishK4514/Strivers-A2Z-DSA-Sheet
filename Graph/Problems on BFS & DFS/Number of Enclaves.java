/*
    1020. Number of Enclaves
    You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
    
    A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
    
    Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
    
     
    
    Example 1:
    
    
    Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]

    0 | 0 | 0 | 0                   
    1 | 0 | 1 | 0      ------>    Output: 3
    0 | 1 | 1 | 0                   
    0 | 0 | 0 | 0    

    
    Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.

    Example 2:

    Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]

    0 | 1 | 1 | 0                   
    0 | 0 | 1 | 0      ------>    Output: 0
    0 | 0 | 1 | 0                   
    0 | 0 | 0 | 0 

    Explanation: All 1s are either on the boundary or can reach the boundary.
*/

import java.util.Queue;
import java.util.LinkedList;

class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Number_of_Enclaves { 
    /*
       Time Complexity: O(N*M) 
       Space Complexity: O(N*M)
    */   
    
    /*
        // Using DFS
        public static void dfs(int row, int col, int n, int m, int[][] vis, int[][] grid, int[] delRow, int[] delCol){
            vis[row][col] = 1;
            for(int i = 0; i < 4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    dfs(nrow, ncol, n, m, vis, grid, delRow, delCol);
                }
            }
        }
        public static int numEnclaves(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int[][] vis = new int[n][m];
            int[] delRow = {0, -1, 0, 1};
            int[] delCol = {-1, 0, 1, 0};
            for(int i = 0; i < m; i++){
                if(vis[0][i] == 0 && grid[0][i] == 1){
                    dfs(0, i, n, m, vis, grid, delRow, delCol);
                }
                if(vis[n - 1][i] == 0 && grid[n - 1][i] == 1){
                    dfs(n - 1, i, n, m, vis, grid, delRow, delCol);
                }
            }
            for(int i = 0; i < n; i++){
                if(vis[i][0] == 0 && grid[i][0] == 1){
                    dfs(i, 0, n, m, vis, grid, delRow, delCol);
                }
                if(vis[i][m - 1] == 0 && grid[i][m - 1] == 1){
                    dfs(i, m - 1, n, m, vis, grid, delRow, delCol);
                }
            }
            int count = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(vis[i][j] == 0 && grid[i][j] == 1){
                        count++;
                    }
                }
            }
            return count;
        } 
    */

    // Using BFS
    public static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0 || i == n - 1 || j == m - 1){
                    if(grid[i][j] == 1){
                        q.add(new Pair(i, j));
                        vis[i][j] = 1;
                    }
                }
            }
        }

        int[] delRow = {0, -1, 0, 1};
        int[] delCol = {-1, 0, 1, 0};
        
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();

            for(int i = 0; i < 4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(numEnclaves(grid));
    }    
}
