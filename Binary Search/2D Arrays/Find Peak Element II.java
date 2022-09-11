/*
 * A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.

   Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].
   
   You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

   // Sorrouned by -1 

     -1 -1
   -1 1 4 -1
   -1 3 2 -1
     -1 1-

    
   Input: mat = [[1,4],[3,2]]
   Output: [0,1]
   Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.

   Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
   Output: [1,1]
   Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.
*/


import java.util.Arrays;

public class Find_Peak_Element_II {
    public static int[] findPeakGrid(int[][] matrix) {
        int startRow = 0;
        int endRow = matrix.length - 1;
        
        while(startRow <= endRow){
            int middleRow = startRow + (endRow - startRow)/2;
            
            // will get maximum position for the row
            int rowMax = maxRowElementPostion(matrix[middleRow], matrix[middleRow].length - 1);
            
            // middle row is the first row
            if(middleRow == 0){
                if(matrix[middleRow][rowMax] > matrix[middleRow + 1][rowMax]){
                    return new int[] {middleRow, rowMax};
                }
            }
            
            // middle row is the last row
            if(middleRow == matrix.length - 1){
                if(matrix[middleRow][rowMax] > matrix[middleRow - 1][rowMax]){
                    return new int[] {middleRow, rowMax};
                }
            }
            
            // checking max element of the row with its upper and its lower row
            if(matrix[middleRow][rowMax] > matrix[middleRow + 1][rowMax] && matrix[middleRow][rowMax] > matrix[middleRow - 1][rowMax]){
                return new int[] {middleRow, rowMax};
            }
            
            // if max element is lesser than the next row same column element, will move start row to next row.
            if(matrix[middleRow][rowMax] < matrix[middleRow + 1][rowMax]){
                startRow = middleRow + 1;
            }
            else{
                endRow = middleRow - 1;
            }   
        }
        // if didn't find the pick element
        return new int[] {-1, -1};
    }
    static int maxRowElementPostion(int[] arr, int end){
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > arr[max]){
                max = i;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[][] matrix = {{10,20,15},{21,30,14},{7,16,32}};
        int[] ans = findPeakGrid(matrix);
        System.out.println(Arrays.toString(ans));
    }
}
