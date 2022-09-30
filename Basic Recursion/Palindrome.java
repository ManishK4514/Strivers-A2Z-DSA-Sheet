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
    public static boolean palindrome(String str, int start, int end){
        if(start >= end){
            return true;
        }
        else{
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            return palindrome(str, start + 1, end - 1);
        }
    }
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        str = str.replaceAll("[^a-zA-Z0-9]", "");
        str = str.toLowerCase();
        System.out.println(palindrome(str, 0, str.length() - 1));
    }
}
