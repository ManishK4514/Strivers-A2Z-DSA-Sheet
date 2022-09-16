/*
 * You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.

   A substring is a contiguous sequence of characters within a string.

   Example 1:
   
   Input: num = "52"
   Output: "5"
   Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.
   Example 2:
   
   Input: num = "4206"
   Output: ""
   Explanation: There are no odd numbers in "4206".
   Example 3:
   
   Input: num = "35427"
   Output: "35427"
   Explanation: "35427" is already an odd number.
*/

public class Largest_Odd_Number_in_String {
    public static String largestOddNumber(String nums) {
        // Time complexity: O(N) & Space complexity: O(1).
        String ans = "";
        for(int i = nums.length() - 1; i >= 0; i--){
            char c = nums.charAt(i);
            if(c % 2 != 0){
                ans = nums.substring(0, i + 1);
                return ans;
            }
        }
        return "";
    }
    public static void main(String[] args) {
        String str = "52";
        System.out.println(largestOddNumber(str));
    }
}
