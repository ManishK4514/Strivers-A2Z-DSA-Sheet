/*
 * Intersection of two sorted arrays
   Problem Statement: Find the intersection of two sorted arrays. OR in other words, Given 2 sorted arrays, find all the elements which occur in both the arrays.
   
   Examples:
   
   Example 1:
   Input: 
   A: [1 2 3 3 4 5 6]
   , B: [3 3 5]
   Output: 3,3,5
   Explanation: We are given two arrays A and B. 
   The elements present in both the arrays  
   are 3,3 and 5.
   
   Example 2:
   Input: 
   A: [1 2 3 3 4 5 6]
   , B: [3 5]
   Output: 3,5
   Explanation: We are given two arrays A and B. 
   The elements present in both the arrays are 3 and 5.

*/

public class Search_In_2D_Array {
    public static boolean searchMatrix(int[][] matrix, int target) {
        /*
         * Solution: 01 --> Time complexity: o(N*M) where N is row and M is column & Space complexity: O(1). 
         * for(int row = 0; row < matrix.length; row++){
               for(int col = 0; col < matrix[row].length; col++){
                   if(matrix[row][col] == target){
                       return true;
                   }
               }
           }
           return false;
        */
        
        // solution 2: Time Complexity: (M * N).
        int i = 0, j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }
            else if(matrix[i][j] > target){
                j--;
            }
            else{
                i++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 16;
        System.out.println(searchMatrix(matrix, target));
    }
}
