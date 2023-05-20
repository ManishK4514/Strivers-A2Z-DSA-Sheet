/*
    Q. Maximum sum of non-adjacent elements (DP 5)
    Practice : https://practice.geeksforgeeks.org/problems/max-sum-without-adjacents2430/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=max-sum-without-adjacents
    Given an array Arr of size N containing positive integers. Find the maximum sum of a subsequence such that no two numbers in the sequence should be adjacent in the array.

    Example 1:
    
    Input:
    N = 6
    Arr[] = {5, 5, 10, 100, 10, 5}
    Output: 110
    Explanation: If you take indices 0, 3
    and 5, then Arr[0]+Arr[3]+Arr[5] =
    5+100+5 = 110.
    Example 2:
    
    Input:
    N = 4
    Arr[] = {3, 2, 7, 10}
    Output: 13
    Explanation: 3 and 10 forms a non
    continuous  subsequence with maximum
    sum.
*/

// import java.util.Arrays;

public class Maximum_sum_of_non_adjacent_elements {
    /*
       // Recursion
       static int maxSum(int[] arr, int idx){
           if(idx < 0) return 0;
           
           // pick
           int a = arr[idx] + maxSum(arr, idx - 2);
           
           // not pick
           int b = 0 + maxSum(arr, idx - 2);
           
           return Math.max(a, b);
       }
       static int findMaxSum(int arr[], int n) {
           return maxSum(arr, n - 1);
       }
    */

    /*
       // Memoization
       static int maxSum(int[] arr, int idx, int[] dp){
           if(idx < 0) return 0;
           
           if(dp[idx] != -1) return dp[idx];
           
           // pick
           int a = arr[idx] + maxSum(arr, idx - 2, dp);
           
           // not pick
           int b = 0 + maxSum(arr, idx - 1, dp);
           
           return dp[idx] = Math.max(a, b);
       }
       static int findMaxSum(int arr[], int n) {
           int[] dp = new int[n + 1];
           Arrays.fill(dp, -1);
           return maxSum(arr, n - 1, dp);
       }
    */
    
    /*
       // Tabulation
       static int findMaxSum(int arr[], int n) {
           int[] dp = new int[n + 1];
           for(int i = 0; i < n; i++){
               int a = arr[i] + (i - 2 >= 0 ? dp[i - 2] : 0);
               int b = 0 + (i - 1 >= 0 ? dp[i - 1] : 0);
               
               dp[i] = Math.max(a, b);
           }
           return dp[n - 1];
       }
    */

    // Space Optimization
    static int findMaxSum(int arr[], int n) {
        int prev = 0, prev2 = 0;
        for(int i = 0; i < n; i++){
            int a = arr[i] + prev2;
            int b = 0 + prev;
            
            prev2 = b;
            prev = Math.max(a, b);
        }
        return prev;
    }

    public static void main(String[] args) {
        int N = 6;
        int[] Arr = {5, 5, 10, 100, 10, 5};
        System.out.println(findMaxSum(Arr, N));
    }
}
