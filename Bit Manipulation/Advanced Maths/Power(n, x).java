/*
   Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

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


public class Pow_x_to_The_Power_n {
    public static double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n;
        if(nn < 0) nn = nn * -1;
        while(nn > 0){
            if(nn % 2 == 1){
                ans = ans * x;
                nn = nn - 1;
            }
            else{
                x = x * x;
                nn = nn/2;
            }
        }
        if(n < 0) ans = (double)(1.0) / ans;
        return ans;
    }
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        myPow(x, n);
    }
}
