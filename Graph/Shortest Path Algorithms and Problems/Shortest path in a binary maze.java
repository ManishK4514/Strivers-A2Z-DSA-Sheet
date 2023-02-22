// ------------------------------------------------------------- LEETCODE VERSION ------------------------------------------------------------

/*
   Question : https://leetcode.com/problems/shortest-path-in-binary-matrix/
   1091. Shortest Path in Binary Matrix
   Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
   
   A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
   
   All the visited cells of the path are 0.
   All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
   The length of a clear path is the number of visited cells of this path.

   Example 1:


   Input: grid = [[0,1],[1,0]]
   Output: 2
   Example 2:
   
   
   Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
   Output: 4
   Example 3:
   
   Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
   Output: -1
*/

import java.util.Queue;
import java.util.LinkedList;

class Touple{
    int row;
    int col;
    int dis;
    Touple(int row, int col, int dis){
        this.row = row;
        this.col = col;
        this.dis = dis;
    }
}

public class Shortest_path_in_a_binary_maze {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0) return -1;
        else if(grid[0][0] == 0 && grid.length == 1) return 1;

        int n = grid.length;
        
        Queue<Touple> q = new LinkedList<>();
        int[][] dist = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dist[i][j] = (int)(1e9);
            }
        }

        dist[0][0] = 1;

        q.add(new Touple(0, 0, 1));
        dist[0][0] = 1;

        int[] delRow = {0, 0, 1, -1, 1, -1, -1, 1};
        int[] delCol = {1, -1, 0, 0, -1, 1, -1, 1};

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int dis = q.peek().dis;
            q.remove();
                                  
            for(int i = 0; i < 8; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];                
                
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && dist[nrow][ncol] > dis + 1 && grid[nrow][ncol] == 0){
                    dist[nrow][ncol] = dis + 1;
                    if(nrow == n - 1 && ncol == n - 1) return dis + 1;
                    q.add(new Touple(nrow, ncol, dis + 1));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}



// ------------------------------------------------------------- GFG VERSION ------------------------------------------------------------




/*
   Question : https://practice.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-a-binary-maze
   G-36: Shortest Distance in a Binary Maze
   Problem Statement: 
   
   Given an n * m matrix grid where each element can either be 0 or 1. You need to find the shortest distance between a given source cell to a destination cell. The path can only be created out of a cell if its value is 1. 
   
   If the path is not possible between the source cell and the destination cell, then return -1.
   
   Note: You can move into an adjacent cell if that adjacent cell is filled with element 1. Two cells are adjacent if they share a side. In other words, you can move in one of four directions, Up, Down, Left, and Right.
   
   Examples:
   
   Example 1:
   
   Input:
   grid[][] = {{1, 1, 1, 1},
               {1, 1, 0, 1},
               {1, 1, 1, 1},
               {1, 1, 0, 0},
               {1, 0, 0, 1}}
   source = {0, 1}
   destination = {2, 2}
   Output:
   3
   
   Explanation: 
   
   1 1 1 1
   1 1 0 1
   1 1 1 1
   1 1 0 0
   1 0 0 1
   The highlighted part in the above matrix denotes the shortest path from source to destination cell.
   
   Example 2:
   
   Input:
   grid[][] = {{1, 1, 1, 1, 1},
               {1, 1, 1, 1, 1},
               {1, 1, 1, 1, 0},
               {1, 0, 1, 0, 1}}
   source = {0, 0}
   destination = {3, 4}
   Output:
   -1 
   Explanation: 
   Since, there is no path possible between the source cell and the destination cell, hence we return -1.
*/

import java.util.Queue;
import java.util.LinkedList;

class Touple{
    int row;
    int col;
    int dis;
    Touple(int row, int col, int dis){
        this.row = row;
        this.col = col;
        this.dis = dis;
    }
}

public class Shortest_path_in_a_binary_maze {
    public static int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length;
        int m = grid[0].length;
		Queue<Touple> q = new LinkedList<>();
		int[][] dist = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dist[i][j] = (int)(1e9);
            }
        }
        
		q.add(new Touple(source[0], source[1], 0));
		dist[source[0]][source[1]] = 0;
		
		int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        
		while(!q.isEmpty()){
		    int row = q.peek().row;
		    int col = q.peek().col;
		    int dis = q.peek().dis;
		    q.remove();
		    
		    if(row == destination[0] && col == destination[1]) return dis;
		    
		    for(int i = 0; i < 4; i++){
		        int nrow = row + delRow[i];
		        int ncol = col + delCol[i];
		        
		        if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && dist[nrow][ncol] > dis + 1 && grid[nrow][ncol] == 1){
		            grid[nrow][ncol] = 0;
		            dist[nrow][ncol] = dis + 1;
		            q.add(new Touple(nrow, ncol, dis + 1));
		        }
		    }
		}
		return -1;
    }
    public static void main(String[] args) {
        
        int[] source={0,1};
        int[] destination={2,2};
        
        int[][] grid={{1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 1}};
        
        System.out.println(shortestPath(grid, source, destination));    
    }
}
