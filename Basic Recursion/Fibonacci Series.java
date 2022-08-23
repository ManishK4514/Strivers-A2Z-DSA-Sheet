/*
   Q. Write a program to print fibonacci series of nth index.
   
   fibbonacci series = 0, 1, 1, 2, 3, 5, 8, 13, .......
 * F(0) = 0, F(1) = 1
   F(n) = F(n - 1) + F(n - 2), for n > 1.

   Example 1:
   Input: n = 2
   Output: 1
   Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

   Example 2:
   Input: n = 3
   Output: 2
   Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.

   Example 3:
   Input: n = 4
   Output: 3
   Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 */

public class FibonacciSeries {
    // recursive method
    public static int fib(int n){
        if(n == 0 || n == 1){
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
    public static void main(String[] args) {
        int n = 3; 
        /*
         * // by Iteration
                 if(n == 0 || n == 1){
                  return n;
              }
              int ans = 0;
              int a = 0;
              int b = 1;
              for(int i = 2; i <= n; i++){
                  ans = a + b;
                  a = b;
                  b = ans;
              }
              return ans;
         */
        int ans = fib(n);
        System.out.println(ans);
    }
}
