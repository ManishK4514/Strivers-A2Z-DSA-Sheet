public class Count_the_number_of_set_bits {
    public static int countSetBits(int n){
        /* 
            // Solution 1: Time Complexity: O(number of bits) & Space Complexity: O(1).
            int count = 0;
            while(n != 0){
                if((n&1) == 1){
                    count++;
                }
                n = n>>1;
            }
            return count;
        */
        // Solution 2: Time Complexity: O(number of setbits) & Space Complexity: O(1).
        int count = 0;
        while(n != 0){
            n = n&n-1;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int n = 14;
        System.out.println(countSetBits(n));
    }
}
