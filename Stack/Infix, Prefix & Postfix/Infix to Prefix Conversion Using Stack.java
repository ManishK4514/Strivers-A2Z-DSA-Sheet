/*
   Infix to Prefix
   Problem Statement: Given an infix expression, Your task is to convert the given infix expression to a prefix expression.
   
   Examples:
   
   Example 1:
   Input: x+y*z/w+u
   Output: ++x/*yzwu
   Explanation: Infix to prefix
   
   Example 2:
   Input: a+b
   Output: +ab
   Explanation: Infix to prefix

   Approach:
   -> change '(' with ')' & ')' with '(' in the expression.
   -> First, reverse the infix expression given in the problem.
   -> convert the expression into Postfix.
   -> convert the expression into Postfix.
   -> Now Again revere the postfix answer to get the Prefix.
*/


import java.util.HashMap;
import java.util.Stack;

public class Infix_To_Prefix_Conversion_Using_Stack {
    public static String infixToPostfix(String exp) {
        // infix to prefix steps
        // 1st: change '(' with ')' & ')' with '('
        // 2nd: reverse the string
        // 3rd: convert the expression into Postfix
        // 4th: Now reverse the answer
        
        StringBuilder sb1 = new StringBuilder();
        for(int i = 0; i < exp.length(); i++){
            if(exp.charAt(i) == '('){
                sb1.append(')');
            }
            else if(exp.charAt(i) == ')'){
                sb1.append('(');
            }
            else{
                sb1.append(exp.charAt(i));
            }
        }
        sb1.reverse();
        exp = sb1.toString();

        // Time complexity: O(N) & Space complexity: O(N).

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
        }
        while (!s.empty()) {
            sb.append(s.pop());
        }
        sb.reverse();
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String str = "a+b*(c^d-e)^(f+g*h)-i";        
        System.out.println(infixToPostfix(str));
    }
}
