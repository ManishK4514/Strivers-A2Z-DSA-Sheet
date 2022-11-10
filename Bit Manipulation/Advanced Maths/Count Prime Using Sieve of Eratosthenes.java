/*
   Given an integer n, return the number of prime numbers that are strictly less than n.

   Example 1:

   Input: n = 10
   Output: 4
   Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
   Example 2:

   Input: n = 0
   Output: 0
   Example 3:

   Input: n = 1
   Output: 0
*/
public class Sieve_of_Eratosthenes {
    public static void createSieve(){        
        int n = 1000000;
        boolean[] sieve = new boolean[1000001];
        for(int i = 2; i <= n; i++){
            sieve[i] = true;
        }
        for(int i = 2; i*i <= n; i++){
            if(sieve[i] == true){
                for(int j = i*i; j <= n; j+=i){
                    sieve[j] = false;
                }
            }
        }
    }
    public static void countPrimes(int n) {
        createSieve();
    }
    public static void main(String[] args) {
        int n = 100;
        countPrimes(n);
    }
}
