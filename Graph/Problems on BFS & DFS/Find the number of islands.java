/*
   Find the number of islands
   Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of '0's (Water) and '1's(Land). Find the number of islands.
   
   Note: An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.
   
   Example 1:
   
   Input:
   grid = {{0,1},{1,0},{1,1},{1,0}}
   Output:
   1
   Explanation:
   The grid is-
   0 1
   1 0
   1 1
   1 0
   All lands are connected.
   Example 2:
   
   Input:
   grid = {{0,1,1,1,0,0,0},{0,0,1,1,0,1,0}}
   Output:
   2
   Expanation:
   The grid is-
   0 1 1 1 0 0 0
   0 0 1 1 0 1 0 
   There are two islands :- one is colored in blue 
   and other in orange.   
   
   Example:

   0 1 1 0
   0 1 1 0
   0 0 1 0
   0 0 0 0
   1 1 0 1

   for this example there are three disConncected Components i.e 3 islands so the answer is 3.
*/

import java.util.Queue;
import java.util.LinkedList;

class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

public class Find_the_number_of_islands {
    /*
     * Time Complexity: O(9 * N^2) ≅ O(N^2)
     * Space Complexity: O(N^2 + N^2) ≅ O(N^2)
     */


    // DFS
    public static void dfs(int ro, int co, char[][] grid, int[][] vis){
        vis[ro][co] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro, co));
        int n = grid.length;
        int m = grid[0].length;
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            
            // Traverse in the Neighbours and mark them if it's a land
            // We can also move in all Eight Direction seprately or we can also use this logic this will also do the same.
            for(int delrow = -1; delrow <= 1; delrow++){
                for(int delcol = -1; delcol <= 1; delcol++){
                    int nrow = row + delrow;
                    int ncol = col + delcol;
                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0){
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
    // Function to find the number of islands.
    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(vis[row][col] == 0 && grid[row][col] == '1'){
                    dfs(row, col, grid, vis);
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        char[][] grid = {{'0','1'},{'1','0'},{'1','1'},{'1','0'}};
        System.out.println(numIslands(grid));
    }
}
