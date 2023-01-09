/*
   Q. Flood fill.
   An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

   You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
   
   To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
   
   Return the modified image after performing the flood fill.
      
   Example 1:

   Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2

   [1, 1, 1]                  [2, 2, 2]
   [1, ①, 0]   ------->       [2, 2, 0]
   [1, 0, 1]                  [2, 0, 1]
   
   
   
   Output: [[2,2,2],[2,2,0],[2,0,1]]
   Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
   Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

   Example 2:   
   Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
   Output: [[0,0,0],[0,0,0]]
   Explanation: The starting pixel is already colored 0, so no changes are made to the image.
*/

import java.util.Arrays;

public class Flood_Fill {
    /*
     * Total Nodes = (n * m) = x (let)
     * Time Complexity: (4*x) ≅ O(x) = O(n*m) ----> For every node four directions
     * Space Complexity: O(N*M) (Stack Space)
     */

    public static void dfs(int row, int col, int[][] ans, int[][] image, int newColor, int[] delRow, int[] delCol, int iniColor){
        int n = image.length;
        int m = image[0].length;
        ans[row][col] = newColor;
        for(int i = 0; i < 4; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == iniColor && ans[nrow][ncol] != newColor){
                dfs(nrow, ncol, ans, image, newColor, delRow, delCol, iniColor);
            }
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];
        int[][] ans = image;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        dfs(sr, sc, ans, image, color, delRow, delCol, iniColor);
        return ans;
    }
    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        for(int[] nums : image){
            System.out.println(Arrays.toString(nums));
        }
        floodFill(image, 1, 1, 2);
        for(int[] nums : image){
            System.out.println(Arrays.toString(nums));
        }
    }
}
