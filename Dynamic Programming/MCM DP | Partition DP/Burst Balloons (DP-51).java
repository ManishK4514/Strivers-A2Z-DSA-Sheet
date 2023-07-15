/*
    Q. Burst Balloons | Partition DP | DP 51

    Practice : https://leetcode.com/problems/burst-balloons/description/

    You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

    If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
    
    Return the maximum coins you can collect by bursting the balloons wisely.
    
    Example 1:
    
    Input: nums = [3,1,5,8]
    Output: 167
    Explanation:
    nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
    coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
    Example 2:
    
    Input: nums = [1,5]
    Output: 10
*/

// import java.util.Arrays;

public class Burst_Balloons {
    /*
       // Recursion
       public static int helper(int i, int j, int[] arr){
           if(i > j) return 0;
   
           int max = 0;
           for(int k = i; k <= j; k++){
               int coins = arr[i - 1] * arr[k] * arr[j + 1] + helper(i, k - 1, arr) + helper(k + 1, j, arr);
               max = Math.max(max, coins);
           }
           return max;
       }
   
       public static int maxCoins(int[] nums) {
           int n = nums.length;
           int[] arr = new int[n + 2];
           for(int i = 0; i < n; i++){
               arr[i + 1] = nums[i];
           }
           // take 1 at the front and 1 and the end for boundary ballons
           arr[0] = 1; arr[arr.length - 1] = 1;
           return helper(1, n, arr);
       }
    */
   
    /*
       // Memoization
       public static int helper(int i, int j, int[] arr, int[][] dp){
           if(i > j) return 0;
   
           if(dp[i][j] != -1) return dp[i][j];
   
           int max = 0;
           for(int k = i; k <= j; k++){
               int coins = arr[i - 1] * arr[k] * arr[j + 1] + helper(i, k - 1, arr, dp) + helper(k + 1, j, arr, dp);
               max = Math.max(max, coins);
           }
           return dp[i][j] = max;
       }
   
       public static int maxCoins(int[] nums) {
           int n = nums.length;
           int[] arr = new int[n + 2];
           for(int i = 0; i < n; i++){
               arr[i + 1] = nums[i];
           }
           // take 1 at the front and 1 and the end for boundary ballons
           arr[0] = 1; arr[arr.length - 1] = 1;
   
           int[][] dp = new int[n + 2][n + 2];
           for(int[] it : dp) Arrays.fill(it, -1);
           
           return helper(1, n, arr, dp);
       }
    */

    // Tabulation
    
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        for(int i = 0; i < n; i++){
            arr[i + 1] = nums[i];
        }
        // take 1 at the front and 1 and the end for boundary ballons
        arr[0] = 1; arr[arr.length - 1] = 1;

        int[][] dp = new int[n + 2][n + 2];

        // no need to write base case as it is already filled with zeros

        for(int i = n; i >= 1; i--){
            for(int j = i; j <= n; j++){
                int max = 0;
                for(int k = i; k <= j; k++){
                    int coins = arr[i - 1] * arr[k] * arr[j + 1] + dp[i][k - 1] + dp[k + 1][j];
                    max = Math.max(max, coins);
                }
                dp[i][j] = max;
            }
        }
        
        return dp[1][n];
    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        System.out.println(maxCoins(nums));
    }
}
