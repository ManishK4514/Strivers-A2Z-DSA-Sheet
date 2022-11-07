public class Check_if_a_number_is_power_of_2_or_not {
    public static boolean checkPower(int n){
        /* 
            // Solution 1:
            double temp = 0;
            int i = 0;
            while(temp < n){
                temp = Math.pow(2, i);
                if(temp == n){
                    return true;
                }
                i++;
            }
            return false;
        */
        /* 
            // Solution 2:
            while(n > 0){
                if(n == 1){
                  return true;
                }
                if((n&1) == 1){
                    return false;
                }
                n = n>>1;
            }
            return false;
        */

        // Optimized Approach: Time Complexity: O(1) & Space Complexity: O(1).
        if((n&n-1) == 0 && n > 0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int n = 64;
        System.out.println(checkPower(n));
    }
}
