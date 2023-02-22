/*
   Question : https://leetcode.com/problems/path-with-minimum-effort/description/
   G-37: Path With Minimum Effort
   You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of the cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e.,0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
   
   A route’s effort is the maximum absolute difference in heights between two consecutive cells of the route.
   
   Examples:
   
   Example 1:
   Input:
   heights = [[1,2,2],[3,8,2],[5,3,5]]
   Output:
   2
   Explanation:    
   The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
   
   Example 2:   
   Input:   
   heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
   Output:
   0
   Explanation: 
   The route of [1,1,1,1,1,1,1,1,1,1,1,1,1,1] has a maximum absolute difference of 0 in consecutive cells.This is better than the route of [1,1,1,1,1,1,2,1], where the maximum absolute difference is 1.
*/

import java.util.PriorityQueue;

class Touple{
    int effort;
    int row;
    int col;
    
    Touple(int effort, int row, int col){
        this.effort = effort;
        this.row = row;
        this.col = col;        
    }
}

public class Path_with_minimum_effort {
    public static int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        
        if(n == 1 && m == 1) return 0;

        PriorityQueue<Touple> pq = new PriorityQueue<>((a, b)->{return a.effort - b.effort;});
        
        int[][] efforts = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                efforts[i][j] = (int)(1e9);
            }
        }
        
        pq.add(new Touple(0, 0, 0));
        efforts[0][0] = 0;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        
        while(!pq.isEmpty()){
            int effort = pq.peek().effort;
            int row = pq.peek().row;
            int col = pq.peek().col;
            pq.remove();

            if(row == n - 1 && col == m - 1) return effort;

            for(int i = 0; i < 4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                int neffort = effort;

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m){
                    neffort = Math.max(effort, Math.abs(heights[nrow][ncol] - heights[row][col]));                    
                }

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && efforts[nrow][ncol] > neffort){
                    efforts[nrow][ncol] = neffort;                    
                    pq.add(new Touple(neffort, nrow, ncol));
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[][] heights={{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(minimumEffortPath(heights));
    }
}
