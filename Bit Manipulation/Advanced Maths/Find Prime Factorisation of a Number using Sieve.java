/*
 * Q. Print all the Prime Factorisation of a Number using Sieve
 * Eg: 35 - 5, 7
 */

public class Find_Prime_Factorisation_of_a_Number_using_Sieve {
    public static void printFactorisation(int n){
        /* 
            // BruteForce Approach: Time Complexity: O(N) & Space Complexity: O(1).
            for(int i = 2; i <= n; i++){
                while(n % i == 0){
                    System.out.print(i + " ");
                    n = n/i;
                }
            }
        */
        
        /* 
            // Approach 2: Time Complexity: O(Sqrt(n)) & Space Complexity: O(1).
            for(int i = 2; i * i <= n; i++){
                while(n % i == 0){
                    System.out.print(i + " ");
                    n = n/i;
                }
            }
            if(n > 1){
                System.out.print(n);
            }
        */

        // Optimized Approach: Using Sieve(spf- Smallest Prime Factor), Time Complexity: log(logN) 
        int x = 1000000;
        int[] spf = new int[x + 1];
        for(int i = 0; i <= x; i++){
            spf[i] = i;
        }
        for(int i = 2; i * i <= n; i++){
            if(spf[i] == i){
                for(int j = i * i; j <= n; j+=i){
                    if(spf[j] == j){
                        spf[j] = i;
                    }
                }
            }
        }
        
        // O(logN)
        while(n != 1){
            System.out.print(spf[n] + " ");
            n = n/spf[n];
        }
    }
    public static void main(String[] args) {
        int n = 35;
        printFactorisation(n);
    }
}
