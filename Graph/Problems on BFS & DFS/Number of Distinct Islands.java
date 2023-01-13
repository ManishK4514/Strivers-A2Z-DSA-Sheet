/*
    Q. Number of Distinct Islands.
    Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. Two islands are considered to be distinct if and only if one island is not equal to another (not rotated or reflected).

    Example 1:
    
    Input:
    grid[][] = {{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}}
    Output:
    1
    Explanation:
    grid[][] = {{1, 1, 0, 0, 0}, 
                {1, 1, 0, 0, 0}, 
                {0, 0, 0, 1, 1}, 
                {0, 0, 0, 1, 1}}
    Same colored islands are equal.
    We have 2 equal islands, so we 
    have only 1 distinct island.
    
    Example 2:
    
    Input:
    grid[][] = {{1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}}
    Output:
    3
    Explanation:
    grid[][] = {{1, 1, 0, 1, 1}, 
                {1, 0, 0, 0, 0}, 
                {0, 0, 0, 0, 1}, 
                {1, 1, 0, 1, 1}}
    Same colored islands are equal.
    We have 4 islands, but 2 of them
    are equal, So we have 3 distinct islands.
*/

import java.util.HashSet;
import java.util.ArrayList;

public class Number_of_Distinct_Islands {
    /*
        Time Complexity: N * M * log (N * M) + (N * M * 4) ≅ O(N*M)
        Space Complexity: O(N*M) 
    */
    public static String toString(int row, int col) {
        return Integer.toString(row) + " " + Integer.toString(col);
    }

    public static void dfs(int row, int col, int n, int m, int[][] vis, int[][] grid, int[] delRow, int[] delCol,
            ArrayList<String> vec, int row0, int col0) {
        vis[row][col] = 1;
        vec.add(toString(row - row0, col - col0));
        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, n, m, vis, grid, delRow, delCol, vec, row0, col0);
            }
        }
    }

    public static int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        HashSet<ArrayList<String>> set = new HashSet<>();

        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    ArrayList<String> vec = new ArrayList<>();
                    dfs(i, j, n, m, vis, grid, delRow, delCol, vec, i, j);
                    set.add(vec);
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        int grid[][] = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 1 } };
        System.out.println(countDistinctIslands(grid));
    }
}
