/*
   Given a non-negative number N. The problem is to set the rightmost unset bit in the binary representation of N. If there are no unset bits, then just leave the number as it is.

   Example 1:
   
   Input:
   N = 6
   Output:
   7
   Explanation:
   The binary representation of 6 is 110.
   After setting right most bit it becomes
   111 which is 7.
   Example 2:
   
   Input:
   N = 15
   Output:
   15
   Explanation:
   The binary representation of 15 is 1111.
   As there is no unset bit it remains the
   same.
*/

public class Set_the_rightmost_unset_bit {
    public static int setBit(int n){
        // int count = 0;
        // while(n != 0){
        //     if((n&1) == 0){
        //         break;
        //     }
        //     count++;
        //     n = n>>1;
        // }
        // return n^(1<<count);

        // Solution 2:
        if((n & (n+1)) == 0) return n;
        return (n | (n+1));
    }
    public static void main(String[] args) {
        int n = 1279;
        System.out.println(setBit(n));
    }
}
