/*
    Q. Minimum cost to cut the stick| (DP-50)

    Practice : https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/

    Given a wooden stick of length n units. The stick is labelled from 0 to n. For example, a stick of length 6 is labelled as follows:

    Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.
    
    You should perform the cuts in order, you can change the order of the cuts as you wish.
    
    The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts. When you cut a stick, it will be split into two smaller sticks (i.e. the sum of their lengths is the length of the stick before the cut). Please refer to the first example for a better explanation.
    
    Return the minimum total cost of the cuts.

    Example 1:    
    Input: n = 7, cuts = [1,3,4,5]
    Output: 16
    Explanation: Using cuts order = [1, 3, 4, 5] as in the input leads to the following scenario:
    
    The first cut is done to a rod of length 7 so the cost is 7. The second cut is done to a rod of length 6 (i.e. the second part of the first cut), the third is done to a rod of length 4 and the last cut is to a rod of length 3. The total cost is 7 + 6 + 4 + 3 = 20.
    Rearranging the cuts to be [3, 5, 1, 4] for example will lead to a scenario with total cost = 16 (as shown in the example photo 7 + 4 + 3 + 2 = 16).

    Example 2:    
    Input: n = 9, cuts = [5,6,1,4,2]
    Output: 22
    Explanation: If you try the given cuts ordering the cost will be 25.
    There are much ordering with total cost <= 25, for example, the order [4, 6, 5, 2, 1] has total cost = 22 which is the minimum possible.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Minimum_cost_to_cut_the_stick {
    /*
       // Recursion
       public static int helper(int i, int j, ArrayList<Integer> newCuts){
           if(i > j) return 0;
   
           int min = (int)(1e9);
           for(int k = i; k <= j; k++){
               int cost = (newCuts.get(j + 1) - newCuts.get(i - 1)) + helper(i, k - 1, newCuts) + helper(k + 1, j, newCuts);
               min = Math.min(min, cost); 
           }
   
           return min;
       }
   
       public static int minCost(int n, int[] cuts) {
           Arrays.sort(cuts);
           ArrayList<Integer> newCuts = new ArrayList<>();
           // add 0 at the starting
           newCuts.add(0);
           // now add rest of the elements of cuts
           for(int it : cuts) newCuts.add(it);
           // now add n in the last
           newCuts.add(n);
   
           // Adding 0 to start and n to end will help in finding length by last - first
           return helper(1, cuts.length, newCuts);
       }
    */
   
    /*
       // Memoization
       public static int helper(int i, int j, ArrayList<Integer> newCuts, int[][] dp){
           if(i > j) return 0;
   
           if(dp[i][j] != -1) return dp[i][j];
   
           int min = (int)(1e9);
           for(int k = i; k <= j; k++){
               int cost = (newCuts.get(j + 1) - newCuts.get(i - 1)) + helper(i, k - 1, newCuts, dp) + helper(k + 1, j, newCuts, dp);
               min = Math.min(min, cost); 
           }
   
           return dp[i][j] = min;
       }
       
       public static int minCost(int n, int[] cuts) {
           Arrays.sort(cuts);
           ArrayList<Integer> newCuts = new ArrayList<>();
           // add 0 at the starting
           newCuts.add(0);
           // now add rest of the elements of cuts
           for(int it : cuts) newCuts.add(it);
           // now add n in the last
           newCuts.add(n);
   
           int m = cuts.length;
   
           int[][] dp = new int[m + 2][m + 2];
           for(int[] it : dp) Arrays.fill(it, -1);
               
           // Adding 0 to start and n to end will help in finding length by last - first
           return helper(1, m, newCuts, dp);
       }
    */

    // Tabulation
    public static int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        ArrayList<Integer> newCuts = new ArrayList<>();
        // add 0 at the starting
        newCuts.add(0);
        // now add rest of the elements of cuts
        for(int it : cuts) newCuts.add(it);
        // now add n in the last
        newCuts.add(n);
        // Adding 0 to start and n to end will help in finding length by last - first

        int m = cuts.length;

        int[][] dp = new int[m + 2][m + 2];
        
        for(int i = m; i >= 1; i--){
            for(int j = i; j <= m; j++){
                int min = (int)(1e9);
                for(int k = i; k <= j; k++){
                    int cost = (newCuts.get(j + 1) - newCuts.get(i - 1)) + dp[i][k - 1] + dp[k + 1][j];
                    min = Math.min(min, cost); 
                }

                dp[i][j] = min;
            }
        }

        return dp[1][m];
    }

    public static void main(String[] args) {
        int n = 7;
        int[] cuts = {1,3,4,5};
        System.out.println(minCost(n, cuts));
    }
}
