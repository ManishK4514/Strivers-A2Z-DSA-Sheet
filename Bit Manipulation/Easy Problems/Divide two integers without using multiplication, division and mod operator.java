/*
   Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

   The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
   
   Return the quotient after dividing dividend by divisor.
   
   Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
   
   Example 1:
   
   Input: dividend = 10, divisor = 3
   Output: 3
   Explanation: 10/3 = 3.33333.. which is truncated to 3.

   Example 2:
   
   Input: dividend = 7, divisor = -3
   Output: -2
   Explanation: 7/-3 = -2.33333.. which is truncated to -2.
*/


public class Divide_two_integers_without_using_multiplication_division_and_mod_operator {
    public static int divide(int dividend, int divisor) {
        if (dividend == 1<<31 && divisor == -1) return Integer.MAX_VALUE;
        boolean sign = (dividend>=0) == (divisor>=0) ? true:false;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int result = 0;
        while(dividend - divisor >= 0){
            int count = 0;
            while(dividend - (divisor << 1 << count) >= 0){
                count++;
            }
            result += 1 << count;
            dividend -= divisor << count;
        }
        return sign?result:-result;
    }
    public static void main(String[] args) {
        int dividend = 10, divisor = 3;
        System.out.println(divide(dividend, divisor));
    }
}
