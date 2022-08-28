/*
 * Given a boolean 2D array of n x m dimensions where each row is sorted. Find the 0-based index of the first row that has the maximum number of 1's.

   Example 1:
   Input: 
   N = 4 , M = 4
   Arr[][] = {{0, 1, 1, 1},
              {0, 0, 1, 1},
              {1, 1, 1, 1},
              {0, 0, 0, 0}}
   Output: 2
   Explanation: Row 2 contains 4 1's (0-based
   indexing).

 */

public class Find_the_row_with_maximum_number_of_1s {
    static int rowWithMax1s(int matrix[][]) {
        // Time Complexity: O(N * M) where N is row and M is column & Space Compelxity: O(1)
        int sum = 0, ans = -1;
        for(int row = 0; row < matrix.length; row++){
               int count = 0;
               for(int col = 0; col < matrix[row].length; col++){
                   if(matrix[row][col] == 1){
                       count++;
                   }
               }
               if(sum < count){
                   sum = count;
                   ans = row;
               }
           }
        return ans;   
    }
    public static void main(String[] args) {
        int Arr[][] = {{0, 1, 1, 1},
        {0, 0, 1, 1},
        {1, 1, 1, 1},
        {0, 0, 0, 0}};
        System.out.println(rowWithMax1s(Arr));
    }
}
