/*
 * Q. Check weather a given number is armstrong or not.
 * For a given 3 digit number, find whether it is armstrong number or not. An Armstrong number of three digits is an integer such that the sum of the cubes of its digits is equal to the number itself. Return "Yes" if it is a armstrong number else return "No".
    NOTE: 371 is an Armstrong number since 33 + 73 + 13 = 371

    Example 1:
    Input: N = 153
    Output: "Yes"
    Explanation: 153 is an Armstrong number
    since 13 + 53 + 33 = 153.
    Hence answer is "Yes".
 */

public class ArmstrongNumber {
    static String armstrongNumber(int n){
        int preN = n;
        int sum = 0;
        while(n > 0){
            sum += (n % 10) * (n % 10) * (n % 10);
            n = n/10;
        }
        if(sum == preN){
            return "Yes";
        }
        else{
            return "No";
        }
    }
    public static void main(String[] args) {
        int n = 153;
        System.out.println(armstrongNumber(n));
    }
}
