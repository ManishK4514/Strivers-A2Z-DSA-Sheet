/*
 * Given a number N. Find its unique prime factors in increasing order.
 
   Example 1:
   
   Input: N = 100
   Output: 2 5
   Explanation: 2 and 5 are the unique prime
   factors of 100.
   
   Example 2:
   
   Input: N = 35
   Output: 5 7
   Explanation: 5 and 7 are the unique prime
   factors of 35.
*/


import java.util.ArrayList;

public class Print_Prime_Factors_of_a_Number {
    public static boolean checkPrime(int n){
        // Program to Check Wheather a Given number is Prime or not.
        int fact = 0;
        for (int j = 1; j * j <= n; j++) {
            if (n % j == 0) {
                fact++;
                if (n / j != j) {
                    fact++;
                }
            }
        }
        if (fact == 2) {
            return true;
        }
        return false;
    }
    public static ArrayList<Integer> findAllPrimeFactors(int n){
        ArrayList<Integer> res = new ArrayList<>();
        // Program to generate all the Factor
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if(checkPrime(i))res.add(i);
                if (n / i != i) {
                    if(checkPrime(n/i)) res.add(n / i);
                }
            }
        }
        return res;
    }  
    public static void main(String[] args) {
        int n = 100;
        System.out.println(findAllPrimeFactors(n));
    }
}
