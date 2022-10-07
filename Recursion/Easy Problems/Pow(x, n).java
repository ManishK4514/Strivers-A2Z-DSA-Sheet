/*
 * Pow(x, n)
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
   Example 1:
   
   Input: x = 2.00000, n = 10
   Output: 1024.00000
   Example 2:
   
   Input: x = 2.10000, n = 3
   Output: 9.26100
   Example 3:
   
   Input: x = 2.00000, n = -2
   Output: 0.25000
   Explanation: 2-2 = 1/22 = 1/4 = 0.25
 
 */

public class PowXtoThePowerN {
    public static double myPow(double x, int n) {
        return myPow(x, 1L * n);
    }
    private static double myPow(double x, long n) {
        if(n == 0)
        return 1;
        if(n < 0){
            return myPow(1/x, -n);
        }    
        return n % 2 == 0 ? myPow(x * x, n/2) : x * myPow(x * x, n / 2);
    }
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x, n));
    }
}
