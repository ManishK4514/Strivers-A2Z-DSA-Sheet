/*
   778. Swim in Rising Water (Leetcode -> https://leetcode.com/problems/swim-in-rising-water/description/?q=dsu&orderBy=most_relevant)
   You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).
   
   The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.
   
   Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).
   
   Example 1:
   Input: grid = [[0,2],[1,3]]
   Output: 3
   Explanation:
   At time 0, you are in grid location (0, 0).
   You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
   You cannot reach point (1, 1) until time 3.
   When the depth of water is 3, we can swim anywhere inside the grid.

   Example 2:
   Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
   Output: 16
   Explanation: The final route is shown.
   We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
  
*/

public class Swim_in_rising_water {
    public static boolean dfs(int[][] grid, int row, int col, int time, int[][] vis){
        int n = grid.length;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        vis[row][col] = 1;   
        
        if (row == n-1 && col == n-1) return true;

        for(int i = 0; i < 4; i++){
            int adjRow = row + delRow[i];
            int adjCol = col + delCol[i];
            if(adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < n && vis[adjRow][adjCol] == 0 && grid[adjRow][adjCol] <= time){
                if(dfs(grid, adjRow, adjCol, time, vis)) return true;
            }
        }
        return false;
    }
    public static int swimInWater(int[][] grid) {
        int n = grid.length;  
        int l = 0, r = (n * n) - 1;
        while(l < r){
            int mid = l + (r - l)/2;
            int[][] vis = new int[n][n];
            if(dfs(grid, 0, 0, mid, vis)){
                r = mid;
            }
            else l = mid + 1;
        }
        return Math.max(grid[0][0], l);
    }
    public static void main(String[] args) {
        int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        System.out.println(swimInWater(grid));
    }
}
