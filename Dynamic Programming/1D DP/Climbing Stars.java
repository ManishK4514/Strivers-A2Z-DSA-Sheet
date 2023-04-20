/*
    Q Climbing Stairs : Dynamic Programming 
    Practice : https://practice.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=count-ways-to-reach-the-nth-stair-1587115620
    How to write 1-D Recurrence relation / Climbing Stairs
    In this article, we will learn to write 1-D Recurrence relations using the problem “Climbing Stairs”
    
    Problem Statement: Given a number of stairs. Starting from the 0th stair we need to climb to the “Nth” stair. At a time we can climb either one or two steps. We need to return the total number of distinct ways to reach from 0th to Nth stair.
  
    There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top (order does matter).
  
    Example 1:
    
    Input:
    n = 4
    Output: 5
    Explanation:
    You can reach 4th stair in 5 ways. 
    Way 1: Climb 2 stairs at a time. 
    Way 2: Climb 1 stair at a time.
    Way 3: Climb 2 stairs, then 1 stair
    and then 1 stair.
    Way 4: Climb 1 stair, then 2 stairs
    then 1 stair.
    Way 5: Climb 1 stair, then 1 stair and
    then 2 stairs.
    Example 2:
    
    Input:
    n = 10
    Output: 89 
    Explanation: 
    There are 89 ways to reach the 10th stair.
*/

// import java.util.Arrays;

public class Climbing_Stars {
    /* 
        // Recursion
        public static int count(int idx){
            if(idx == 0) return 1;
            if(idx < 0) return 0;
            return count(idx - 1) + count(idx - 2);
        }
        public static int climbStairs(int n) {
            return count(n);
        }
    */
    
    /* 
        // Memorization
        public static int count(int idx, int[] dp){
            if(idx == 0) return 1;
            if(idx < 0) return 0;
            if(dp[idx] != -1) return dp[idx];
            return dp[idx] = count(idx - 1, dp) + count(idx - 2, dp);
        }
        public static int climbStairs(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            return count(n, dp);
        }
    */
    
    /* 
        // Tabulation
        public static int climbStairs(int n) {
            int[] dp = new int[n + 1];
            // initial step 
            dp[0] = 1; dp[1] = 1;
            for(int i = 2; i < n + 1; i++){
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    */

    // Space Optimization
    public static int climbStairs(int n) {
        if(n < 2) return 1;
        int curr = 0, prev1 = 1, prev2 = 1;
        for(int i = 2; i <= n; i++){
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
    public static void main(String[] args) {
        int n = 2;
        System.out.println(climbStairs(n));
    }    
}
