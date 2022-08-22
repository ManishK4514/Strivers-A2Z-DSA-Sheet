/*
 * Given a positive integer N., The task is to find the value of    \sum_{i=1}^{i=n} F(i)  where function F(i) for the number i be defined as the sum of all divisors of ‘i‘.
 * 
 * Example 1:

   Input:
   N = 4
   Output:
   15
   Explanation:
   F(1) = 1
   F(2) = 1 + 2 = 3
   F(3) = 1 + 3 = 4
   F(4) = 1 + 2 + 4 = 7
   ans = F(1) + F(2) + F(3) + F(4)
       = 1 + 3 + 4 + 7
       = 15
 */

public class Sum_of_all_divisors_from_1_to_n {
    static long sumOfDivisors(int N){
        long sum = 0;
        for(int i = 1; i <= N; i++){
            int temp = 0;
            for(int j = 1; j <= i; j++){
                if(i % j == 0){
                    temp += j;
                }
            }
            sum += temp;
        }
        return sum;
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(sumOfDivisors(n));
    }
}
