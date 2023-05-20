/*
    Q. Dynamic Programming : Frog Jump (DP 3) 
    Practice : https://practice.geeksforgeeks.org/problems/geek-jump/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=geek-jump
    Geek Jump
    Geek wants to climb from the 0th stair to the (n-1)th stair. At a time the Geek can climb either one or two steps. A height[N] array is also given. Whenever the geek jumps from stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]), where abs() means the absolute difference. return the minimum energy that can be used by the Geek to jump from stair 0 to stair N-1.
    
    Example:
    Input:
    n = 4
    height = {10 20 30 10}
    Output:
    20
    Explanation:
    Geek jump from 1st to 2nd stair(|20-10| = 10 energy lost).
    Then a jump from the 2nd to the last stair(|10-20| = 10 energy lost).
    so, total energy lost is 20 which is the minimum.
*/

// import java.util.Arrays;

public class Frog_Jump {
    /*
       // Recursion
       public static int helper(int[] arr, int idx){
           if(idx == 0) return 0;
           
           int oneStep = Math.abs(arr[idx] - arr[idx - 1]) + helper(arr, idx - 1);
           int twoStep = idx - 2 >= 0 ? Math.abs(arr[idx] - arr[idx - 2]) + helper(arr, idx - 2) : Integer.MAX_VALUE;
           
           return Math.min(oneStep, twoStep);
       }
       public static int minimumEnergy(int[] arr,int n){
           return helper(arr, n - 1);
       }
    */

    /*
       // Memoization
       public static int helper(int[] arr, int idx, int[] dp){
           if(idx == 0) return 0;
           if(dp[idx] != -1) return dp[idx];
           
           int oneStep = Math.abs(arr[idx] - arr[idx - 1]) + helper(arr, idx - 1, dp);
           int twoStep = idx > 1 ? Math.abs(arr[idx] - arr[idx - 2]) + helper(arr, idx - 2, dp) : Integer.MAX_VALUE;
           
           return dp[idx] = Math.min(oneStep, twoStep);
       }
       public static int minimumEnergy(int[] arr,int n){
           int[] dp = new int[n + 1];
           Arrays.fill(dp, -1);
           return helper(arr, n - 1, dp);
       }
    */
    
    /*
       // Tabulation
       public static int minimumEnergy(int[] arr,int n){
           if(n == 1) return 0;
           int[] dp = new int[n];
           dp[0] = 0; dp[1] = Math.abs(arr[1] - arr[0]);
           for(int i = 2; i < n; i++){
               int oneStep = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
               int twoStep = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
               dp[i] = Math.min(oneStep, twoStep);
           }
           return dp[n - 1];
       }
    */

    // Space Optimization
    public static int minimumEnergy(int arr[],int n){
        if(n == 1) return 0;
        int prev2 = 0, prev = Math.abs(arr[1] - arr[0]);
        for(int i = 2; i < n; i++){
            int oneStep = prev + Math.abs(arr[i] - arr[i - 1]);
            int twoStep = prev2 + Math.abs(arr[i] - arr[i - 2]);
            prev2 = prev;
            prev = Math.min(oneStep, twoStep);
        }
        return prev;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] height = {10, 20, 30, 10};
        System.out.println(minimumEnergy(height, n));
    }
}
