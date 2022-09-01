import java.util.Arrays;

public class Rearrange_Array_Elements_by_Sign_Positive_Negative {
    public static int[] rearrangeArray(int[] nums) {
        /*
         * Brute Force Solution: Time Complexity: O(N) & Space complexity: O(N)
         * int[] ans = new int[nums.length];
           int k = 0;
           for(int i = 0; i < nums.length; i++){
               if(nums[i] > 0){
                   ans[k] = nums[i];
                   k+=2;
               }
           }
           int m = 1;
           for(int i = 0; i < nums.length; i++){
               if(nums[i] < 0){
                   ans[m] = nums[i];
                   m+=2;
               }
           }
           return ans;
        */

        // Solution 2: Using one loop: Time Complexity: O(N) & Space complexity: O(N)
        int[] ans = new int[nums.length];
        int k = 0;
        int j = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                ans[k] = nums[i];
                k+=2;
            }
            else{
                ans[j] = nums[i];
                j+=2;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        int[] ans = rearrangeArray(nums);
        System.out.println(Arrays.toString(ans));
    }
}
