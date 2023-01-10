/*
   Q. Rotten Oranges.
   Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
   0 : Empty cell
   1 : Cells have fresh oranges
   2 : Cells have rotten oranges
   
   We have to determine what is the minimum time required to rot all oranges. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. 
    
   
   Example 1:
   
   Input: grid = {{0,1,2},{0,1,2},{2,1,1}}
   Output: 1
   Explanation: The grid is-
   0 1 2
   0 1 2
   2 1 1
   Oranges at positions (0,2), (1,2), (2,0)
   will rot oranges at (0,1), (1,1), (2,2) and 
   (2,1) in unit time.
   Example 2:
   
   Input: grid = {{2,2,0,1}}
   Output: -1
   Explanation: The grid is-
   2 2 0 1
   Oranges at (0,0) and (0,1) can't rot orange at
   (0,3).
*/

import java.util.Queue;
import java.util.LinkedList;

class Pair{
    int first;
    int second;
    int time;
    Pair(int first, int second, int time){
        this.first = first;
        this.second = second;
        this.time = time;
    }
}

public class Rotten_Oranges {
    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0, freshcnt = 0, mt = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(grid[row][col] == 2){
                    q.add(new Pair(row, col, 0)); 
                    vis[row][col] = 2;
                }
                if(grid[row][col] == 1) freshcnt++;
            }
        }
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            int t = q.peek().time;
            mt = Math.max(mt, t);
            q.remove();
            for(int i = 0; i < 4; i++){
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    vis[nrow][ncol] = 2;
                    q.add(new Pair(nrow, ncol, t + 1));
                    cnt++;
                }
            }  
        }   
        if(cnt != freshcnt) return -1;
        return mt;
    }
    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid));
    }
}
