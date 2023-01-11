/*
  Q. 0/1 Matrix (Bfs Problem)
   Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

   The distance between two adjacent cells is 1.
   
    
   
   Example 1:
   
   
   
   Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
   
   ────────────                  ────────────
   │ 0, 0, 0  │                  │ 0, 0, 0  │
   │ 0, 1, 0  │      ----->      │ 0, 1, 0  │
   │ 0, 1, 0  │                  │ 0, 0, 0  │
   ────────────                  ────────────
   
   Output: [[0,0,0],[0,1,0],[0,0,0]]
   Example 2:
   
   
   Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
   
   ────────────                  ────────────
   │ 0, 0, 0  │                  │ 0, 0, 0  │
   │ 0, 1, 0  │      ----->      │ 0, 1, 0  │
   │ 1, 1, 1  │                  │ 1, 2, 1  │
   ────────────                  ────────────
   
   Output: [[0,0,0],[0,1,0],[1,2,1]]

*/

import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

class Pair{
    int row;
    int col;
    int steps;
    Pair(int row,int col, int steps){
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}

public class Q_01_Matrix {
    /*
     * Time Complexity: O(N*M)  ----> For every node four directions
     * Space Complexity: O(N*M)
     */
    public static int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }
        
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int steps = q.peek().steps;
            dist[row][col] = steps;

            q.remove();
            for(int i = 0; i < 4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol, steps + 1));
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] dist = updateMatrix(mat);
        for(int[] nums : dist){
            System.out.println(Arrays.toString(nums));
        }
    }
}


-----------------------------------------------------------------------------------------------
  
 Gfg version of this Problem
 
 /*
 Given a binary grid of n*m. Find the distance of the nearest 1 in the grid for each cell.
The distance is calculated as |i1  - i2| + |j1 - j2|, where i1, j1 are the row number and column number of the current cell, and i2, j2 are the row number and column number of the nearest cell having value 1.
 

Example 1:

Input: grid = {{0,1,1,0},{1,1,0,0},{0,0,1,1}}
Output: {{1,0,0,1},{0,0,1,1},{1,1,0,0}}
Explanation: The grid is-
0 1 1 0 
1 1 0 0 
0 0 1 1 
0's at (0,0), (0,3), (1,2), (1,3), (2,0) and
(2,1) are at a distance of 1 from 1's at (0,1),
(0,2), (0,2), (2,3), (1,0) and (1,1)
respectively.


Example 2:

Input: grid = {{1,0,1},{1,1,0},{1,0,0}}
Output: {{0,1,0},{0,0,1},{0,1,2}}
Explanation: The grid is-
1 0 1
1 1 0
1 0 0
0's at (0,1), (1,2), (2,1) and (2,2) are at a 
distance of 1, 1, 1 and 2 from 1's at (0,0),
(0,2), (2,0) and (1,1) respectively.

*/


class Pair{
    int row;
    int col;
    int steps;
    Pair(int row,int col, int steps){
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}

class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] mat)
    {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 1){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }
        
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int steps = q.peek().steps;
            dist[row][col] = steps;

            q.remove();
            for(int i = 0; i < 4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol, steps + 1));
                }
            }
        }
        return dist;
    }
}
