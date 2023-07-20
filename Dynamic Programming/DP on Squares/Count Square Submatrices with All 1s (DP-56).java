/*
    Q. Count Square Submatrices with All 1s | DP on Rectangles : DP 56

    Practice : https://leetcode.com/problems/count-square-submatrices-with-all-ones/

    Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

    Example 1:
    
    Input: matrix =
    [
      [0,1,1,1],
      [1,1,1,1],
      [0,1,1,1]
    ]
    Output: 15
    Explanation: 
    There are 10 squares of side 1.
    There are 4 squares of side 2.
    There is  1 square of side 3.
    Total number of squares = 10 + 4 + 1 = 15.
    Example 2:
    
    Input: matrix = 
    [
      [1,0,1],
      [1,1,0],
      [1,1,0]
    ]
    Output: 7
    Explanation: 
    There are 6 squares of side 1.  
    There is 1 square of side 2. 
    Total number of squares = 6 + 1 = 7.
*/

public class Count_Square_Submatrices_with_All_1s {
    public static int countSquares(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];

        // fill 1st col as it is
        for(int i = 0; i < n; i++) dp[i][0] = matrix[i][0];
        // fill 1st row as it is
        for(int j = 0; j < m; j++) dp[0][j] = matrix[0][j];

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][j] == 0) continue;

                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
            }
        }

        int ans = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans += dp[i][j];
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {0,1,1,1},
            {1,1,1,1},
            {0,1,1,1}
        };

        System.out.println(countSquares(matrix));
    }
}
