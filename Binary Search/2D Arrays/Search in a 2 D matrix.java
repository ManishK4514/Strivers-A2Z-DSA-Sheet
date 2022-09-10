/*
 * Q. Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

   Integers in each row are sorted from left to right.
   The first integer of each row is greater than the last integer of the previous row.
    
   
   Example 1:
   Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
   Output: true
   
   Example 2:
   Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
   Output: false
*/


public class Search_In_a_2D_Array {
    public static boolean searchMatrix(int[][] matrix, int target) {
        /*
         * BruteForce Approach: Time complexity: O(row * Col) & Space complexity: O(1).
         * for(int i = 0; i < matrix.length; i++){
               for(int j = 0; j < matrix[i].length; j++){
                   if(matrix[i][j] == target){
                       return true;
                   }
               }
           }
           return false;
        */

        /*
         * Solution 2: using binary search at every row:
         * Time complexity: O(row * logN) & Space complexity: O(1).
         * for(int[] nums : matrix){
               int start = 0;
               int end = nums.length - 1;
               int mid = 0;
               while(start <= end){
                   mid = start + (end - start)/2;
                   if(nums[mid] == target){
                       return true;
                   }
                   else if(nums[mid] > target){
                       end = mid - 1;
                   }
                   else{
                       start = mid + 1;
                   }
               }
           }
           return false;
        */
        
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = (m * n) - 1;
        int mid = 0;
        while(start <= end){
            mid = start + (end - start)/2;
            if(matrix[mid / n][mid % n] == target){
                return true;
            }
            else if(matrix[mid / n][mid % n] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix  = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }    
}
