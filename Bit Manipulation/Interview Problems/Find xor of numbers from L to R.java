/*
 * Q. Given a Range (L-R), Find the XOR between L-R;
 *    (L ^ l+1 ^ L+2 ^ ....  ^ R-1 ^ R)
 * 
 *  for eg: let l = 3; r = 7;
 *  for range(1-l) = 1 ^ 2 ^ 3;
 *  for range(1-r) = 1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6 ^ 7;
 * 
 *  if we will do xor of l ^ r then 1 - L will be cancel from R and we will get xor of (L-R)
 */

public class Find_xor_of_numbers_from_L_to_R {
    public static int XorOfAnyInteger(int n){
        if(n % 4 == 0){
            return n;
        }
        else if(n % 4 == 1){
            return 1;
        }
        else if(n % 4 == 2){
            return n+1;
        }
        else if(n % 4 == 3){
            return 0;
        }
        else{
            return -1;
        }
    }
    public static int findXorFromLtoR(int l, int r){
        /* 
            // BruteForce Approach: 
            int xor = 0;
            for(int i = l; i <= r; i++){
                xor ^= i;
            }
            return xor;
        */

        // Optimized Approach: Time Complexity: O(1) & Space Complexity: O(1).
        return XorOfAnyInteger(l) ^ XorOfAnyInteger(r); 
    }
    public static void main(String[] args) {
        int l = 3, r = 34;
        System.out.println(findXorFromLtoR(l, r));
    }
}
