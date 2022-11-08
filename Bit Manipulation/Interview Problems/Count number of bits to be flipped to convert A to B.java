/*
   A bit flip of a number x is choosing a bit in the binary representation of x and flipping it from either 0 to 1 or 1 to 0.

   For example, for x = 7, the binary representation is 111 and we may choose any bit (including any leading zeros not shown) and flip it. We can flip the first bit from the right to get 110, flip the second bit from the right to get 101, flip the fifth bit from the right (a leading zero) to get 10111, etc.
   Given two integers start and goal, return the minimum number of bit flips to convert start to goal.
   
   Example 1:
   
   Input: start = 10, goal = 7
   Output: 3
   Explanation: The binary representation of 10 and 7 are 1010 and 0111 respectively. We can convert 10 to 7 in 3 steps:
   - Flip the first bit from the right: 1010 -> 1011.
   - Flip the third bit from the right: 1011 -> 1111.
   - Flip the fourth bit from the right: 1111 -> 0111.
   It can be shown we cannot convert 10 to 7 in less than 3 steps. Hence, we return 3.

   Example 2:   
   Input: start = 3, goal = 4
   Output: 3
   Explanation: The binary representation of 3 and 4 are 011 and 100 respectively. We can convert 3 to 4 in 3 steps:
   - Flip the first bit from the right: 011 -> 010.
   - Flip the second bit from the right: 010 -> 000.
   - Flip the third bit from the right: 000 -> 100.
   It can be shown we cannot convert 3 to 4 in less than 3 steps. Hence, we return 3.
*/


public class Count_number_of_bits_to_be_flipped_to_convert_A_to_B {
    public static int minBitFlips(int start, int goal) {
        /* 
            // BruteForce Approach: Time Complexity: O(N) & Space Complexity: O(1).
            String str1 = Integer.toBinaryString(start);
            String str2 = Integer.toBinaryString(goal);
            if(str1.length() < str2.length()){
                int n = str2.length() - str1.length();
                for(int i = 0; i < n; i++){
                    str1 = 0 + str1;
                }
            }
            else{
                int n = str1.length() - str2.length();
                for(int i = 0; i < n; i++){
                    str2 = 0 + str2;
                }
            }
            int count = 0;
            for(int i = 0; i < str1.length(); i++){
                if(str1.charAt(i) != str2.charAt(i)){
                    count++;
                }
            }
            return count;
        */

        // Optimized Appraoch: 
        int xor = start ^ goal;
        int count = 0;
        while(xor != 0){
            xor = (xor&(xor - 1));
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int start = 10, goal = 7;
        System.out.println(minBitFlips(start, goal));
    }
}
