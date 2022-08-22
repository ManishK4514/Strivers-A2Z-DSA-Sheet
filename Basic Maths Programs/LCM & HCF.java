/*
   Q. Given two numbers A and B. The task is to find out their LCM and GCD.
   
 * Example 1:
   Input: num1 = 4, num2 = 8
   Output: 4
   Explanation: Since 4 is the greatest number which divides both num1 and num2.
   
   Example 2:
   Input: num1 = 3, num2 = 6
   Output: 3
   Explanation: Since 4 is the greatest number which divides both num1 and num2.

 */

import java.util.Arrays;

public class LCM_And_HCF {
    static Long[] lcmAndHcf(long A , long B) {
        Long[] ans = new Long[2];
        findLcm(A, B, ans);
        findHcf(A, B, ans);
        return ans;
    }
    public static void findHcf(Long a, Long b, Long[] ans){
        if(a % b == 0){
            ans[1] = a;
            return;
        }
        Long c = a % b;
        findHcf(c, a, ans);
    }
    public static void findLcm(Long a, Long b, Long[] ans){
        Long max = Math.max(a, b);
        Long min = Math.min(a, b);
        Long tempMax = max;
        int temp = 1;
        for(int i = 0; i < 3; i++){
            if(tempMax % min == 0){
                ans[0] = tempMax;
            }
            else{
                temp++;
                tempMax = max * temp;
                i = -1;
            }
        }
    }
    /*
     * optimized:
     * static Long[] lcmAndGcd(Long A , Long B) {
        Long[] ans = new Long[2];
        Long hcf = findHcf(A, B);
        Long lcm = (A * B)/hcf;
        ans[0] = lcm;
        ans[1] = hcf;
        return ans;
    }
    public static Long findHcf(Long a, Long b){
        if(b == 0){
            return a;
        }
        return findHcf(b, a % b);
    } 
     */
    public static void main(String[] args) {
        long a = 5;
        long b = 10;
        Long [] ans = lcmAndHcf(a, b);
        System.out.println(Arrays.toString(ans));
    }
}
