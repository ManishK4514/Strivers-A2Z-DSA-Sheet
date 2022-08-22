/*
   Q. Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
   Leetcode(7. Reverse Integer)
 * Example 1:
   Input: x = 123
   Output: 321

   Example 2:
   Input: x = -123
   Output: -321
 */

public class ReverseInteger {
    public static int reverse(int x) {
        int ans = 0;
        while (x != 0)
        {
            int tail = x % 10;
            int newResult = ans * 10 + tail;
            if ((newResult - tail) / 10 != ans){
                return 0;
            }
            ans = newResult;
            x = x / 10;
        }
        return ans;
    } 
    public static void main(String[] args) {
        int n = 123;
        System.out.println(reverse(n));
    }
}
