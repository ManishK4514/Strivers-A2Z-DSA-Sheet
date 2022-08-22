/*
 * Q. Given a number N. Count the number of digits in N which evenly divides N.
 * 
 * Example: 
 * Input:
   N = 12
   Output:
   2
   Explanation:
   1, 2 both divide 12 evenly
 */

public class CountDigits {
    static int evenlyDivides(int N){
        // Storing N value in other Index so that we can't lose initial value of N
        int preN = N;
        int count = 0;
        int digit = 0;
        while(N > 0){
            digit = N % 10;
            // To resolve divide by zero exception
            if(digit != 0){
                if(preN % digit == 0){
                count++;
              }
            }
            N = N/10;
        }
        return count;
    }
    public static void main(String[] args) {
        int x = 22074;
        System.out.println(evenlyDivides(x));
    }
}
