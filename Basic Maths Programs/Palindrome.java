/*
 * Q. Write a program to check wheather a given number is Palindrome or not.
 * 
 * Example 1:
   Input: x = 121
   Output: true
   Explanation: 121 reads as 121 from left to right and from right to left.

   Example 2:
   Input: x = -121
   Output: false
   Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 */

public class Palindrome {
    public static boolean isPalindrome(int x) {
        /* Solution 1: Time complexity: O(NlogN) & Space complexity: O(N)
        String temp = Integer.toString(x);
        int[] nums = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            nums[i] = temp.charAt(i) - '0';
        }
        int si = 0;
        int ei = nums.length - 1;
        while(si < ei){
            if(nums[si] != nums[ei]){
                return false;
            }
            si++;
            ei--;
        }
        return true;
        */

        // Soultion 2: Time complexity: O(NlongN) (Optimized)
        // Storing X value in other Index so that we can't lose initial value of X
        int preX = x;
        if(x < 0 || (x != 0 && x % 10 == 0)){
            return false;
        }
        int rev = 0;
        while(x > 0){
            rev = rev * 10 + x % 10;
            x = x/10;
        }
        return (preX==rev || preX==rev/10);
    }
    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }
}
