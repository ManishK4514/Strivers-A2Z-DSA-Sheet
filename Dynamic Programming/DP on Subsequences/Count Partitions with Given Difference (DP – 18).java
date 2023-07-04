/*
    Q. Count Partitions with Given Difference (DP – 18)
    Practice : https://practice.geeksforgeeks.org/problems/partitions-with-given-difference/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=partitions-with-given-difference

    Given an array arr, partition it into two subsets(possibly empty) such that their union is the original array. Let the sum of the element of these two subsets be S1 and S2. 

    Given a difference d, count the number of partitions in which S1 is greater than or equal to S2 and the difference S1 and S2 is equal to d. since the answer may be large return it modulo 109 + 7.
    
    Example 1:
    
    Input:
    n = 4, d = 3
    arr[] =  { 5, 2, 6, 4}
    Output:
    1
    Explanation:
    There is only one possible partition of this array. Partition : {6, 4}, {5, 2}. The subset difference between subset sum is: (6 + 4) - (5 + 2) = 3.
    Example 2:
    
    Input:
    n = 4, d = 0 arr[] = {1, 1, 1, 1} Output: 6 
*/

// import java.util.Arrays;

public class Count_Partitions_with_Given_Difference {
    /*
       // Recursion
       static int mod = (int) (1e9 + 7);
       public static int helper(int i, int targetSum, int[] arr){
           // base case
           if(i == 0){
               if(targetSum == 0 && arr[0] == 0) return 2;
               if(targetSum == arr[i] || targetSum == 0) return 1;
               return 0;
           }
           
           // take
           int take = 0;
           if(targetSum >= arr[i]) take = helper(i - 1, targetSum - arr[i], arr);
           
           // not take
           int notTake = helper(i - 1, targetSum, arr);
           
           return (take + notTake) % mod;
       }
       public static int countPartitions(int n, int d, int arr[]){
           int totalSum = 0;
           for(int i = 0; i < n; i++) totalSum += arr[i];
           
           if(totalSum - d < 0 || ((totalSum - d) % 2) != 0) return 0;
   
           return helper(n - 1, (totalSum - d)/2, arr);
       }
    */

    /*
       // Memoization
       static int mod = (int) (1e9 + 7);
       public static int helper(int i, int targetSum, int[] arr, int[][] dp){
           // base case
           if(i == 0){
               if(targetSum == 0 && arr[0] == 0) return 2;
               if(targetSum == arr[i] || targetSum == 0) return 1;
               return 0;
           }
           
           if(dp[i][targetSum] != -1) return dp[i][targetSum];
           
           // take
           int take = 0;
           if(targetSum >= arr[i]) take = helper(i - 1, targetSum - arr[i], arr, dp);
           
           // not take
           int notTake = helper(i - 1, targetSum, arr, dp);
           
           return dp[i][targetSum] =  (take + notTake) % mod;
       }
       public static int countPartitions(int n, int d, int arr[]){
           int totalSum = 0;
           for(int i = 0; i < n; i++) totalSum += arr[i];
           
           if(totalSum - d < 0 || ((totalSum - d) % 2) != 0) return 0;
           
           int[][] dp = new int[n][totalSum + 1];
           for(int[] it : dp) Arrays.fill(it, -1);
           return helper(n - 1, (totalSum - d)/2, arr, dp);
       }
    */

    /*
       // Tabulation
       public static int countPartitions(int n, int d, int arr[]){
           int totalSum = 0, mod = (int) (1e9 + 7);
           for(int i = 0; i < n; i++) totalSum += arr[i];
           
           if(totalSum - d < 0 || ((totalSum - d) % 2) != 0) return 0;
           
           int targetSum = (totalSum - d)/2;
           
           int[][] dp = new int[n][targetSum + 1];
           
           if(arr[0] == 0) dp[0][0] = 2;
           else dp[0][0] = 1;
           
           if(arr[0] != 0 && arr[0] <= targetSum) dp[0][arr[0]] = 1;
           
           for(int i = 1; i < n; i++){
               for(int sum = 0; sum <= targetSum; sum++){
                   // take
                   int take = 0;
                   if(sum >= arr[i]) take = dp[i - 1][sum - arr[i]];
                   
                   // not take
                   int notTake = dp[i - 1][sum];
                   
                   dp[i][sum] =  (take + notTake) % mod;
               }
           }
           return dp[n - 1][targetSum];
       }
    */

    // Space Optimization
    
    public static int countPartitions(int n, int d, int arr[]){
        int totalSum = 0, mod = (int) (1e9 + 7);
        for(int i = 0; i < n; i++) totalSum += arr[i];
        
        if(totalSum - d < 0 || ((totalSum - d) % 2) != 0) return 0;
        
        int targetSum = (totalSum - d)/2;
        
        int[] prev = new int[targetSum + 1];
        int[] curr = new int[targetSum + 1];
        
        if(arr[0] == 0) prev[0] = 2;
        else prev[0] = 1;
        
        if(arr[0] != 0 && arr[0] <= targetSum) prev[arr[0]] = 1;
        
        for(int i = 1; i < n; i++){
            for(int sum = 0; sum <= targetSum; sum++){
                // take
                int take = 0;
                if(sum >= arr[i]) take = prev[sum - arr[i]];
                
                // not take
                int notTake = prev[sum];
                
                curr[sum] =  (take + notTake) % mod;
            }
            prev = curr.clone();
        }
        return prev[targetSum];
    }
    public static void main(String[] args) {
        int n = 4, d = 3;
        int[] arr =  { 5, 2, 6, 4};
        System.out.println(countPartitions(n, d, arr));
    }
}
