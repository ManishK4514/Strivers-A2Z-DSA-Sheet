/*
 * Spiral Traversal of Matrix
   Problem Statement: Given a Matrix, print the given matrix in spiral order.
   
   Examples:
   
   Example 1:
   Input: Matrix[][] = { { 1, 2, 3, 4 },
   		              { 5, 6, 7, 8 },
   		              { 9, 10, 11, 12 },
   	                  { 13, 14, 15, 16 } }
   
   Outhput: 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10.
   Explanation: The output of matrix in spiral form.
   
   Example 2:
   Input: Matrix[][] = { { 1, 2, 3 },
   	                  { 4, 5, 6 },
   		              { 7, 8, 9 } }
   			    
   Output: 1, 2, 3, 6, 9, 8, 7, 4, 5.
   Explanation: The output of matrix in spiral form.
 */

import java.util.ArrayList;
import java.util.List;

public class Print_the_matrix_in_spiral_manner {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int dir = 0;
        List<Integer> ans = new ArrayList<>();
        while(top <= bottom && left <= right){
            if(dir == 0){
                for(int i = left; i <= right; i++){
                    ans.add(matrix[top][i]);
                }
                top++;
            }
            else if(dir == 1){
                for(int i = top; i <= bottom; i++){
                    ans.add(matrix[i][right]);
                }
                right--;
            }
            else if(dir == 2){
                for(int i = right; i >= left; i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            else if(dir == 3){
                for(int i = bottom; i >= top; i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
            dir = (dir + 1) % 4;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> ans = spiralOrder(matrix);
        System.out.println(ans);
    }
}
