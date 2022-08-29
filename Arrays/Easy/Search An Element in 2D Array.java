// Q. Write a program to search an elment in the 2D Array.

      ⊛ To search an element in 2D Array We can search in each row of 2D matrix through Binary Search as each row of 2D array itself a Array.
      ⊛  The Best Optimized way to search an element from 2D Array is treat entire 2D array as a Single 1D Array by using two pointer and Apply Binary search.
      ⊛ Time Complexity: O(N * logM) & Space Complexity: O(1).



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
        
        /* solution 2: Time Complexity: (M * N).
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

        */
        
        /*
         * Solution 3: Using Binary Search --> Time Complexity: O(N*logM) & Space Complexity: O(1)
         * int row = 0;
           while(row < matrix.length){
               int start = 0;
               int end = matrix[row].length - 1;
               while(start <= end){
                   int mid = start + (end - start)/2;
                   if(matrix[row][mid] == target){
                       return true;
                   }
                   else if(matrix[row][mid] > target){
                       end = mid - 1;
                   }
                   else{
                       start = mid + 1;
                   }
               }
               row++;
           }
           return false;

        */
        // Optimized Solution: Time Complexity: O(log(m*n)) & Space complexity: O(1)
        // In this Solution we treat entire 2D Array as a single Array and search by the index.
        int n = matrix.length;
        int m = matrix[0].length;
        int start = 0;
        int end = (n * m) - 1;
        while(start <= end){
            int mid = (start + (end - start)/2);
            if(matrix[mid/m][mid%m] == target){
                return true;
            }
            if(matrix[mid/m][mid%m] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
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
