/*
   Q. 1021. Remove Outermost Parentheses (Leetcode)
   (https://leetcode.com/problems/remove-outermost-parentheses/)

 * A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.

   For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
   A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.
   
   Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
   
   Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
   
    
   
   Example 1:
   
   Input: s = "(()())(())"
   Output: "()()()"
   Explanation: 
   The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
   After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
   
   Example 2:
   
   Input: s = "(()())(())(()(()))"
   Output: "()()()()(())"
   Explanation: 
   The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
   After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".

   Example 3:
   
   Input: s = "()()"
   Output: ""
   Explanation: 
   The input string is "()()", with primitive decomposition "()" + "()".
   After removing outer parentheses of each part, this is "" + "" = "".
*/


public class Remove_Outermost_Parentheses {
    public static String removeOuterParentheses(String str) {
        // Time complexity: O(N) & Space complexity: O(1).
        String ans = "";
        int j = 0;
        for(int i = 0; i < str.length() - 1; i++){
            if(str.charAt(i) == ')'){
                j--;
            }
            if(j != 0){
                ans += str.charAt(i);
            }
            if(str.charAt(i) == '('){
                j++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String str = "(()())(())";
        System.out.println(removeOuterParentheses(str));
    }  
}
