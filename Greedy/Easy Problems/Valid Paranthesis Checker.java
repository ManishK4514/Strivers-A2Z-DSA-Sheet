/*
   678. Valid Parenthesis String
   Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
   
   The following rules define a valid string:
   
   Any left parenthesis '(' must have a corresponding right parenthesis ')'.
   Any right parenthesis ')' must have a corresponding left parenthesis '('.
   Left parenthesis '(' must go before the corresponding right parenthesis ')'.
   '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
    
   Example 1:
   
   Input: s = "()"
   Output: true
   Example 2:
   
   Input: s = "(*)"
   Output: true
   Example 3:
   
   Input: s = "(*))"
   Output: true
*/


import java.util.Stack;

public class Valid_Paranthesis_Checker {
    public static boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();
        if(s.charAt(0) == ')') return false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') open.push(i);
            else if(s.charAt(i) == '*') star.push(i);
            else{
                if(!open.empty()) open.pop();
                else if(!star.empty()) star.pop();
                else return false;
            }
        }
        while(!open.empty()){
            if(!star.empty() && open.peek() > star.peek()) return false;
            else if(!star.empty() && open.peek() <= star.peek()){
                open.pop();
                star.pop();
            }
            else return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "(*))";
        System.out.println(checkValidString(str));
    }
}
