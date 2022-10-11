/*
    Infix to Postfix
    Problem Statement: Given an infix expression, Your task is to convert the given infix expression to a postfix expression.
    
    Examples:
    
    Example 1:
    Input: a+b*(c^d-e)^(f+g*h)-i
    Output: abcd^e-fgh*+^*+i-
    Explanation: Infix to postfix
    
    Example 2:
    Input: (p+q)*(m-n)
    Output: pq+mn-*
    Explanation: Infix to postfix

    Approach: To convert Infix expression to Postfix
    
    1. Scan the infix expression from left to right. 
    
    2. If the scanned character is an operand, Print it. 
    
    3. Else, 
    
    If the precedence of the scanned operator is greater than the precedence of the operator in the stack or the stack is empty or the stack contains a ‘(‘, push the character into the stack. 
    Else, Pop all the operators from the stack which are greater than or equal to in precedence than that of the scanned operator. After doing that Push the scanned operator to the stack. 
    4. If the scanned character is an ‘(‘, push it into the stack. 
    
    5. If the scanned character is an ‘)’, pop the stack and output it until a ‘(‘ is encountered, and discard both the parenthesis. 
    
    6. Repeat steps 2-5 until the entire infix expression is scanned. 
    
    7. Print the output.
    
    8. Pop and print the output from the stack until it is not empty.
*/

import java.util.HashMap;
import java.util.Stack;

public class Infix_To_Postfix_Conversion_Using_Stack {
    public static String infixToPostfix(String exp) {
        // Time complexity: O(N) & Space complexity: O(1).

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put('^', 3);
        map.put('(', 0);
        map.put(')', 0);

        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '(') {
                s.push(exp.charAt(i));
            } else if (exp.charAt(i) >= 'a' && exp.charAt(i) <= 'z') {
                sb.append(exp.charAt(i));
            } else if (exp.charAt(i) == ')') {
                while (s.peek() != '(') {
                    sb.append(s.pop());
                }
                s.pop();
            } else {
                if (!s.empty()) {
                    if (map.get(exp.charAt(i)) > map.get(s.peek())) {
                        s.push(exp.charAt(i));
                    } else if (map.get(exp.charAt(i)) <= map.get(s.peek())) {
                        while(!s.empty() && map.get(exp.charAt(i)) <= map.get(s.peek())){
                            sb.append(s.pop());
                        }
                        s.push(exp.charAt(i));
                    }
                }
                else{
                    s.push(exp.charAt(i));
                }
            }
            System.out.println(s);
        }
        while (!s.empty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(str));
    }
}
