/*
 * Nth Root of a Number using Binary Search
   Problem Statement: Given two numbers N and M, find the Nth root of M.
   
   The nth root of a number M is defined as a number X when raised to the power N equals M.
   
   Example 1:
   Input: N=3 M=27
   Output: 3
   Explanation: The cube root of 27 is 3.
   
   Example 2:
   Input: N=2 M=16
   Output: 4
   Explanation: The square root of 16 is 4
   
   Example 3:
   Input: N=5 M=243
   Output: 3
   Explaination: The 5th root of 243 is 3
*/


public class Find_Nth_root_of_a_number_in_log_n {
    static double multiply(double number, int n){
        double ans = 1.0;
        for(int i = 0; i < n; i++){
            ans *= number;
        }
        return ans;
    }
    public static double getNthRoot(int n, int m){
        double low = 1;
        double high = m;
        double eps = 1e-6;
        while((high - low) > eps){
            double mid = (low + high)/2.0;
            if(multiply(mid, n) < m){
                low = mid;
            }
            else{
                high = mid;
            }
        }
        return low; // or we can return high 
    }
    public static void main(String[] args) {
        int n = 2, m = 5;
        double ans = getNthRoot(n, m);
        System.out.println(ans);
    }
}
