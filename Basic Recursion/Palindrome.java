/*
   for more Solution: Leetcode: https://leetcode.com/problems/valid-palindrome/submissions/ (125)
 * Q. Write a program to check whether a given string is palindrome or not.
 * Example:
 * input: str = "malylam"
 * output: true
 * 
 * Example:
 * input: str = "manish"
 * output: false
 */

public class palindrome {
    /*
     * Recursion Solution for simple problem.
     */
    public static boolean checkPalindrome(String str, int start, int end){
        if(start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            checkPalindrome(str, start + 1, end - 1);
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        str = str.replaceAll("[^a-zA-Z0-9]", "");
        str = str.toLowerCase();
        System.out.println(checkPalindrome(str, 0, str.length() - 1));
    }
}
