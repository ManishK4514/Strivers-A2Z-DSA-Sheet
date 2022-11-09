/*
 * Q. Write a Program to Print all Divisors of a Number.
 * Eg: n = 36 -> 1, 2, 3, 4, 6, 9, 12, 18, 36
 */

public class All_Divisors_of_a_Number {
    public static void PrintAllDivisors(int n){
        /* 
        // BruteForce Approach: Time Complexity: O(N) & Space Complexity: O(1).
        for(int i = 1; i <= n; i++){
            if(n%i == 0){
                System.out.println(i + " ");
            }
        }
        */

        // Optimized Approach: Time Compelxity: O(Sqrt(n)) & Space Compelxity: O(1).
        for(int i = 1; i*i <= n; i++){
            if(n%i==0){
                System.out.print(i + " ");
                if(n/i != i){
                    System.out.print(n/i + " ");
                }
            }
        }
    }
    public static void main(String[] args) {
        int n = 36;
        PrintAllDivisors(n);
    }
}
