/*
 * Rotate Image by 90 degree
   Problem Statement: Given a matrix, your task is to rotate the matrix 90 degrees clockwise.
   
   Note: Rotate matrix 90 degrees anticlockwise
   
   Examples:
   
   Example 1:
   Input: [[1,2,3],[4,5,6],[7,8,9]]
   Output: [[7,4,1],[8,5,2],[9,6,3]]
   Explanation: Rotate the matrix simply by 90 degree clockwise and return the matrix.
   
   Example 2:
   Input: [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
   Output:[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
   Explanation: Rotate the matrix simply by 90 degree clockwise and return the matrix
 */


public class Rotate_Image_by_90_degree {
    public static void rotate(int[][] matrix) {
        /*
         * BruteForce Approach: we will insert our each row of original array in the temp array from last column to first and then finally we will copy the temp array into the original array.
         * Time complexity: O(N^2) & Space complexity: O(N^2)
         * 
         * int m = matrix.length;
           int n = matrix[0].length;
           int[][] temp = new int[m][n];
           int row = 0;
           int k = n - 1;
           while(row < m){
               for(int i = 0; i < m; i++){
                   temp[i][k] = matrix[row][i];
               }
               row++;
               k--;
           }
           for(int i = 0; i < m; i++){
               for(int j = 0; j < n; j++){
                   matrix[i][j] = temp[i][j];
               }
           }
        */
        // Solution 2: Time complexity: O(N^2) & Space complexity: O(1)
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[row].length; col++){
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
