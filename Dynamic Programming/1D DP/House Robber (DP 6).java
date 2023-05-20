/*
    Q. Dynamic Programming: House Robber (DP 6)
    Practice : https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=stickler-theif-
    Stickler the thief wants to loot money from a society having n houses in a single line. He is a weird person and follows a certain rule when looting the houses. According to the rule, he will never loot two consecutive houses. At the same time, he wants to maximize the amount he loots. The thief knows which house has what amount of money but is unable to come up with an optimal looting strategy. He asks for your help to find the maximum money he can get if he strictly follows the rule. Each house has a[i]amount of money present in it.

    Example 1:
    
    Input:
    n = 6
    a[] = {5,5,10,100,10,5}
    Output: 110
    Explanation: 5+100+5=110
    Example 2:
    
    Input:
    n = 3
    a[] = {1,2,3}
    Output: 4
    Explanation: 1+3=4
*/

// import java.util.Arrays;

public class House_Robber {
    /*
       // Recursion
       static int maxSum(int[] arr, int idx){
           if(idx < 0) return 0;
           
           // pick
           int a = arr[idx] + maxSum(arr, idx - 2);
           
           // not pick
           int b = 0 + maxSum(arr, idx - 1);
           
           return Math.max(a, b);
       }
       static public int FindMaxSum(int arr[], int n){
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
       static public int FindMaxSum(int arr[], int n)
       {
           int[] dp = new int[n + 1];
           Arrays.fill(dp, -1);
           return maxSum(arr, n - 1, dp);
       }
    */
    
    /*
       // Tabulation
       public static int FindMaxSum(int arr[], int n)
        {
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

    public static int FindMaxSum(int arr[], int n){
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
        int n = 6;
        int[] a = {5,5,10,100,10,5};
        
        System.out.println(FindMaxSum(a, n));
    }
}
