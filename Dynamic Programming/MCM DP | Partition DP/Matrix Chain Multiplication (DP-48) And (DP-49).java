/*
    Q. Matrix Chain Multiplication | (DP-48)

    Practice: https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

    Given a sequence of matrices, find the most efficient way to multiply these matrices together. The efficient way is the one that involves the least number of multiplications.

    The dimensions of the matrices are given in an array arr[] of size N (such that N = number of matrices + 1) where the ith matrix has the dimensions (arr[i-1] x arr[i]).
    
    Example 1:
    
    Input: N = 5
    arr = {40, 20, 30, 10, 30}
    Output: 26000
    Explanation: There are 4 matrices of dimension 
    40x20, 20x30, 30x10, 10x30. Say the matrices are 
    named as A, B, C, D. Out of all possible combinations,
    the most efficient way is (A*(B*C))*D. 
    The number of operations is -
    20*30*10 + 40*20*10 + 40*10*30 = 26000.
    
    Example 2:
    
    Input: N = 4
    arr = {10, 30, 5, 60}
    Output: 4500
    Explaination: The matrices have dimensions 
    10*30, 30*5, 5*60. Say the matrices are A, B 
    and C. Out of all possible combinations,the
    most efficient way is (A*B)*C. The 
    number of multiplications are -
    10*30*5 + 10*5*60 = 4500.
*/

// import java.util.Arrays;

public class Matrix_Chain_Multiplication {
    /*
       // Recursion
       public static int helper(int i, int j, int[] arr){
           if(i == j) return 0;
           int min = (int)(1e9);
           
           for(int k = i; k < j; k++){
               int steps = arr[i - 1] * arr[k] * arr[j] + helper(i, k, arr) + helper(k + 1, j, arr);
               min = Math.min(min, steps);
           }
           
           return min;
       }
   
       public static int matrixMultiplication(int N, int arr[]) {
           return helper(1, N - 1, arr);
       }
    */
   
    /*
       // Memoization
       public static int helper(int i, int j, int[] arr, int[][] dp){
           if(i == j) return 0;
           int min = (int)(1e9);
           
           if(dp[i][j] != -1) return dp[i][j];
           
           for(int k = i; k < j; k++){
               int steps = arr[i - 1] * arr[k] * arr[j] + helper(i, k, arr, dp) + helper(k + 1, j, arr, dp);
               min = Math.min(min, steps);
           }
           
           return dp[i][j] = min;
       }
   
       public static int matrixMultiplication(int N, int arr[]) {
           int[][] dp = new int[N][N];
           for(int[] it : dp) Arrays.fill(it, -1);
           return helper(1, N - 1, arr, dp);
       }
    */

    // Tabulation

    public static int matrixMultiplication(int N, int arr[]) {
        int[][] dp = new int[N][N];
        
        // base case: we can skip also as dp is intially filled with zeros
        for(int i = 0; i < N; i++) dp[i][i] = 0;
        
        for(int i = N - 1; i >= 1; i--){
            for(int j = i + 1; j <= N - 1; j++){
                int min = (int)(1e9);
                
                for(int k = i; k < j; k++){
                    int steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
                    min = Math.min(min, steps);
                }
                
                dp[i][j] = min;
            }
        }
        
        return dp[1][N - 1];
    } 

    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        int N = arr.length;
        System.out.println(matrixMultiplication(N, arr));
    }
}
