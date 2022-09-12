/*
   Q. 1482. Leetcode(https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/)
 * You are given an integer array bloomDay, an integer m and an integer k.

   You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
   
   The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
   
   Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

 
 */


public class Minimum_days_to_make_M_bouquets {
    public static int minDays(int[] bloomDay, int m, int k) {
        /*
         * BruteForce Apporach: Time complexity: O(N * MaxElementOfArray) & Space complexity: O(1).
         * if(bloomDay.length < (m * k)){
               return -1;
           }
           int min = Integer.MAX_VALUE;
           int max = Integer.MIN_VALUE;
           for(int val: bloomDay){
               min = Math.min(min, val);
               max = Math.max(max, val);
           }
           for(int i = min; i <= max; i++){
               int curr = 0, adj = 0;
               for(int j = 0; j < bloomDay.length; j++){
                   if(i < bloomDay[j]){
                       adj = 0;
                   }
                   else{
                       adj += 1;
                       if(adj == k){
                           adj = 0;
                           curr++;
                       }
                   }
                   if(curr >= m){
                       return i;
                   }
               }
           }
           return -1;
        */
        

        // Optimized Approach: Time complexity: O(N + logN) & Space complexity: O(1).

        if(bloomDay.length < (m * k)){
            return -1;
        } 
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < bloomDay.length; i++){
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }
        int mid, curr, adj;
        while(min < max){
            mid = min + (max - min)/2;
            curr = 0; adj = 0;
            for(int i = 0; i < bloomDay.length; i++){
                if(bloomDay[i] > mid) {
                    adj = 0;
                }
                else{
                    adj++;
                    if(adj == k){
                        adj = 0;
                        curr += 1;
                    }
                }
                if(curr >= m){
                    break;
                }
            }
            if(curr < m){
                min = mid + 1;
            }
            else{
                max = mid;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int[] bloomDay = {7,7,7,7,12,7,7};
        int m = 2;
        int k = 3;
        System.out.println(minDays(bloomDay, m, k));
    }
}
