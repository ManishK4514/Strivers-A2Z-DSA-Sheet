/*
   45. Jump Game II
   You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
   
   Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
   
   0 <= j <= nums[i] and
   i + j < n
   Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
   
   Example 1:
   
   Input: nums = [2,3,1,1,4]
   Output: 2
   Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
   Example 2:
   
   Input: nums = [2,3,0,1,4]
   Output: 2
*/


public class Jump_Game_2 {
    public static int jump(int[] arr) {
        /*
           // This Approach has a logic to identify non-possible case that means when we can't reach to the end by jumping.

           int l = 0;
           int r = 0;
           
           int res = 0;           
           while(r < arr.length - 1 && l <= r) {
               int farthest = 0;
               
               for(int i=l;i<=r;i++) {
                   farthest = Math.max(farthest, i + arr[i]);
               }
               
               l = r + 1;
               r = farthest;
               res++;
           }
           
           if(l > r) {
               return -1;
           }
           
           return res;
        */

        int farthest = 0, jumps = 0, curr = 0;        
        for(int i = 0; i < arr.length - 1; i++){
            farthest = Math.max(farthest, i + arr[i]);
            if(i == curr){
                curr = farthest;
                jumps++;
            }
        }
        return jumps;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        System.out.println(jump(arr));
    }
}
