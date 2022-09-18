/*
   Q. String to Integer (atoi) (leetcode 8).
   
   Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

   The algorithm for myAtoi(string s) is as follows:
   
   Read in and ignore any leading whitespace.
   Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
   Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
   Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
   If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
   Return the integer as the final result.
   Note:
   
   Only the space character ' ' is considered a whitespace character.
   Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
    
   
   Example 1:
   
   Input: s = "42"
   Output: 42
   Explanation: The underlined characters are what is read in, the caret is the current reader position.
   Step 1: "42" (no characters read because there is no leading whitespace)
            ^
   Step 2: "42" (no characters read because there is neither a '-' nor '+')
            ^
   Step 3: "42" ("42" is read in)
              ^
   The parsed integer is 42.
   Since 42 is in the range [-231, 231 - 1], the final result is 42.
   Example 2:
   
   Input: s = "   -42"
   Output: -42
   Explanation:
   Step 1: "   -42" (leading whitespace is read and ignored)
               ^
   Step 2: "   -42" ('-' is read, so the result should be negative)
                ^
   Step 3: "   -42" ("42" is read in)
                  ^
   The parsed integer is -42.
   Since -42 is in the range [-231, 231 - 1], the final result is -42.
   Example 3:
   
   Input: s = "4193 with words"
   Output: 4193
   Explanation:
   Step 1: "4193 with words" (no characters read because there is no leading whitespace)
            ^
   Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
            ^
   Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
                ^
   The parsed integer is 4193.
   Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
*/


public class Implement_Atoi {
    public static int myAtoi(String s) {
        if(s.length() == 0){
            return 0;
        }
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                s = s.substring(i, s.length());
                break;
            }
        }
        
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        
        long ans = 0;
        int sign = 1;
        
        if(s.charAt(0) == '-'){
            sign = -1;
        }
        int i = (s.charAt(0) == '+' || s.charAt(0) == '-') ? 1 : 0;
        while(i < s.length()){
            if(s.charAt(i) == '-' || !Character.isDigit(s.charAt(i))){
                return sign * (int)(ans);
            }
            ans = ans * 10 + (s.charAt(i) - '0');
            if(sign == -1 && -1 * ans < min){
                return min;
            }
            if(sign == 1 && ans > max){
                return max;
            }
            i++;
            
        }
        return sign * (int)(ans);
    }
    public static void main(String[] args) {
        String s = "   -42";
        System.out.println(myAtoi(s));
    }
}
