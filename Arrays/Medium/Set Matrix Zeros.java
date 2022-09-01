/*
 * Set Matrix Zero
   Problem Statement: Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix.
   
   Examples:
   
   Examples 1:
   Input: matrix=[[1,1,1],[1,0,1],[1,1,1]]
   Output: [[1,0,1],[0,0,0],[1,0,1]]
   Explanation: Since matrix[2][2]=0.Therfore the 2nd column and 2nd row wil be set to 0.
    
   Examples 2:
   Input: matrix=[[0,1,2,0],[3,4,5,2],[1,3,1,5]]
   Output:[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
   Explanation:Since matrix[0][0]=0 and matrix[0][3]=0. Therefore 1st row, 1st column and 4th column will be set to 0
 */


public class Set_Matrix_Zeroes {
    public static void setZeroes(int[][] matrix) {
        /*
         * BruteForce Approach: Using Extra matrix which is the copy of original matrix.
         * Time Complexity: O((N*M)*(N + M)). O(N*M)) & Space complexity: O(m * n)
         * int m = matrix.length;
           int n = matrix[0].length;
           int[][] temp = new int[m][n];
           for(int row = 0; row < matrix.length; row++){
               for(int col = 0; col < matrix[row].length; col++){
                   temp[row][col] = matrix[row][col];
               }
           }
           for(int row = 0; row < matrix.length; row++){
               for(int col = 0; col < matrix[row].length; col++){
                   if(matrix[row][col] == 0){
                       int ind = row - 1;
                       while(ind >= 0){
                           if(matrix[ind][col] != 0){
                               temp[ind][col] = 0;
                           }
                           ind--;
                       }
                       ind = row + 1;
                       while(ind < matrix.length){
                           if(matrix[ind][col] != 0){
                               temp[ind][col] = 0;
                           }
                           ind++;
                       }
                       ind = col - 1;
                       while(ind >= 0){
                           if(matrix[row][ind] != 0){
                               temp[row][ind] = 0;
                           }
                           ind--;
                       }
                       ind = col + 1;
                       while(ind < matrix[row].length){
                           if(matrix[row][ind] != 0){
                               temp[row][ind] = 0;
                           }
                           ind++;
                       }
                   }
               }
           }
           for(int row = 0; row < matrix.length; row++){
               for(int col = 0; col < matrix[row].length; col++){
                   if(matrix[row][col] == -1){
                       matrix[row][col] = 0;
                   }
               }
           }
           for(int row = 0; row < matrix.length; row++){
               for(int col = 0; col < matrix[row].length; col++){
                   matrix[row][col] = temp[row][col];
               }
           }
        */

        // Optimized Approach: Time complexity: O(2*(N*M)) & Space complexity: O(1)
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 1;
        int y = 1;
        for(int j = 0; j < n; j++){
            if(matrix[0][j] == 0){
                x = 0;
            }
        }
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                y = 0;
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int j = 1; j < n; j++){
            if(matrix[0][j] == 0){
                for(int i = 0; i < m; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i = 1; i < m; i++){
            if(matrix[i][0] == 0){
                for(int j = 0; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        if(y == 0){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
        if(x == 0){
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[row].length; col++){
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
