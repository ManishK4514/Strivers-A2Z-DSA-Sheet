/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

   Example 1:
   
   Input: n = 3
   Output: ["((()))","(()())","(())()","()(())","()()()"]
   Example 2:
   
   Input: n = 1
   Output: ["()"]
*/


import java.util.List;
import java.util.ArrayList;

public class Generate_Parentheses {
    public static void generate(List<String> ans, int open, int close, String str){
        if(open == 0 && close == 0){
            ans.add(str);
            return;
        }
        if(open != 0){
            generate(ans, open - 1, close, str + "(");
        }
        if(close > open){
            generate(ans, open, close - 1, str + ")");
        }
    }
    public static List<String> generateParenthesis(int n) {
        int open = n, close = n;
        List<String> ans = new ArrayList<>();
        generate(ans, open, close, "");
        return ans;
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
}
