/*
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

   Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

   Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
   
   Return the minimum integer k such that she can eat all the bananas within h hours.

   Example 1:
   Input: piles = [3,6,7,11], h = 8
   Output: 4
   
   Example 2:
   Input: piles = [30,11,23,4,20], h = 5
   Output: 30
   
   Example 3:
   Input: piles = [30,11,23,4,20], h = 6
   Output: 23
   
*/


public class Koko_Eating_Bananas {
    static long findTime(int[] piles, int i){
        long time = 0;
        for(int j = 0; j < piles.length; j++){
            if(piles[j] % i != 0){
                time += (piles[j]/i) + 1;
            }
            else{
                time += piles[j]/i;
            }
        }
        return time;
    }
    public static int minEatingSpeed(int[] piles, int h) {
        /*
         * BruteForce Approach: O(maxElement * N) & Space complexity: O(1).
         * int max = Integer.MIN_VALUE;
           for(int i = 0; i < piles.length; i++){
               max = Math.max(max, piles[i]);
           }
           for(int i = 1; i <= max; i++){
               long time = 0;
               for(int j = 0; j < piles.length; j++){
                   if(piles[j] > i && piles[j] % i != 0){
                       time += (piles[j]/i) + 1;
                   }
                   else if(piles[j] < i){
                       time += 1;
                   }
                   else{
                       time += piles[j]/i;
                   }
               }
               if(time <= h){
                   return i;
               }
           }
           return -1;
        */

        // Optimized Approach: Using Binary Search -> Time complexity: O(N + logN) & Space complexity: O(1).

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++){
            max = Math.max(max, piles[i]);
        }
        int start = 1;
        int end = max;
        int ans = Integer.MAX_VALUE;
        while(start <= end){
            int mid = start + (end - start)/2;
            long time = findTime(piles, mid);
            if(time <= h){
                ans = mid;
                end = mid - 1;
            }
            else if(time > h){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }        
        return ans;
    }
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int h = 5;
        System.out.println(minEatingSpeed(piles, h));
    }
}
