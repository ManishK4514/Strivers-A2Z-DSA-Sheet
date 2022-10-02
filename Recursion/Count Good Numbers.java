/*
 * Q. Count Good Number.
 * A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).

   For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
   Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.
   
   A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.
   
   Example 1:
   
   Input: n = 1
   Output: 5
   Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".
   Example 2:
   
   Input: n = 4
   Output: 400
   Example 3:
   
   Input: n = 50
   Output: 564908303
*/


public class Count_Good_numbers {
    public static int countGoodNumbers(long n) {
        int MOD = 1_000_000_007;
        long result = n % 2 == 0 ? 1 : 5;
        long x = 20;
        result *= myPow(x, n/2, MOD);
        return (int)result;
    }
    private static double myPow(double x, long n, int MOD) {
        if(n == 0){
            return 1;
        }  
        return n % 2 == 0 ? myPow(x * x, n/2, MOD) % MOD: x * myPow(x * x, n/2, MOD) % MOD;
    }
    public static void main(String[] args) {
        long n = 4;
        System.out.println(countGoodNumbers(n));
    }
}
