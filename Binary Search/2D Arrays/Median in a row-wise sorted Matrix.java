/*
 * Given a row wise sorted matrix of size RxC where R and C are always odd, find the median of the matrix.

   Example 1:
   
   Input:
   R = 3, C = 3
   M = [[1, 3, 5], 
        [2, 6, 9], 
        [3, 6, 9]]
   
   Output: 5
   
   Explanation:
   Sorting matrix elements gives us 
   {1,2,3,3,5,6,6,9,9}. Hence, 5 is median. 
*/


// import java.util.Arrays;

public class Median_in_a_row_wise_sorted_Matrix {
    static int countSmallerThanMiddle(int[] nums, int middle){
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while(start <= end){
            mid = start + (end - start)/2;
            if(nums[mid] <= middle){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return start;
    }
    static int median(int matrix[][], int r, int c) {
        /* 
         * BruteForce Approach Time Complexity: O(r*c log(r*c)) & Space complexity: O(r * c)
         * 
         * int[] arr = new int[r * c];
           int k = 0;
           for(int row = 0; row < r; row++){
               for(int col = 0; col < c; col++){
                   arr[k++] = matrix[row][col];
               }
           }
           Arrays.sort(arr);
           return arr[arr.length/2];
        */
        int start = 1;
        int end = 2000;
        while(start <= end){
            int mid = start + (end - start)/2;
            int count = 0;
            for(int i = 0; i < r; i++){
                count += countSmallerThanMiddle(matrix[i], mid);
            }
            if(count <= (r * c)/2){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        System.out.println(median(matrix, matrix.length, matrix[0].length));
    }
}
