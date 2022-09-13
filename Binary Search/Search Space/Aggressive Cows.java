/*
 * Aggressive Cows : Detailed Solution
   Problem Statement: There is a new barn with N stalls and C cows. The stalls are located on a straight line at positions x1,….,xN (0 <= xi <= 1,000,000,000). We want to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
   
   Examples:
   
   Input: No of stalls = 5 
          Array: {1,2,8,4,9}
          And number of cows: 3
   
   Output: One integer, the largest minimum distance 3

*/
import java.util.Arrays;

public class Aggressive_Cows {
    public static boolean isCompatible(int[] inp, int dist, int cows){
        int n = inp.length;
        int k = inp[0];
        cows--;
        for(int i = 1; i < n; i++){
            if(inp[i] - k >= dist){
                cows--;
                if(cows == 0){
                    return true;
                }
                k = inp[i];
            }            
        }
        return false;
    }
    public static void main(String[] args) {
        int n = 5, m = 3;
        int inp[] = {1,2,8,4,9};
        Arrays.sort(inp);
        int maxD = inp[n - 1] - inp[0];
        int ans = Integer.MIN_VALUE;
        /*
         * BruteForce Appraoch: Using Two loop -> Time compelxity: O(N^2) & Space complexity: O(1).
         * for (int d = 1; d <= maxD; d++) {
               boolean possible = isCompatible(inp, d, m);
               if (possible) {
                   ans = Math.max(ans, d);
               }
           }
           System.out.println("The largest minimum distance is " + ans);
        */
        
        // Optimized Solution: Using Binary Search -> Time complexity: O(N*logN) & Space complexity: O(1).
        int start = 1, end = maxD;
        while(start <= end){
            int mid = start + (end - start)/2;
            boolean possible = isCompatible(inp, mid, m);
            if(possible){
                ans = Math.max(ans, mid);
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        System.out.println("The largest minimum distance is " + ans);
    }
}
