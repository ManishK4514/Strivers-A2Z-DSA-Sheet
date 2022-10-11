/*
    Check for Balanced Parentheses
    Problem Statement: Check Balanced Parentheses. Given string str containing just the characters ‘(‘, ‘)’, ‘{‘, ‘}’, ‘[‘ and ‘]’, check if the input string is valid and return true if the string is balanced otherwise return false.
    
    Note: string str is valid if:
    
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

    Example 1:    
    Input: str = “( )[ { } ( ) ]”    
    Output: True
    
    Explanation: As every open bracket has its corresponding 
    close bracket. Match parentheses are in correct order 
    hence they are balanced.

    Example 2:    
    Input: str = “[ ( )”    
    Output: False
    
    Explanation: As ‘[‘ does not have ‘]’ hence it is 
    not valid and will return false.
*/


import java.util.Stack;

public class Valid_Parentheses {
    public static boolean isValid(String str) {
        
        /* 
            // Solution 1:

            Stack<Character> s = new Stack<>();
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '['){
                    s.push(str.charAt(i));
                }
                else{
                    if(s.empty()) return false;
                    char c = s.pop();
                    if((str.charAt(i) == ')' && c == '(') || (str.charAt(i) == '}' && c == '{') || str.charAt(i) == ']' && c == '['){
                        continue;
                    }
                    else{
                        return false;
                    }
                }
            }
            return s.empty();
        */
        
        // Solution 2:

        Stack<Character> stack = new Stack<Character>();
	    for (int i = 0; i < str.length(); i++){
	    	if (str.charAt(i) == '('){
                stack.push(')');
            }	    		
	    	else if (str.charAt(i) == '{'){
                stack.push('}');
            }	    		
	    	else if (str.charAt(i) == '['){
                stack.push(']');
            }	    		
	    	else if (stack.isEmpty() || stack.pop() != str.charAt(i)){
                return false;
            }
	    }
	    return stack.isEmpty();
    }
    public static void main(String[] args) {
        String str = "(){}[]";
        System.out.println(isValid(str));
    }
}
