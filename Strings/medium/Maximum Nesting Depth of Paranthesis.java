/*
 * Q. Write a program to Count Maximum Nesting Depth of the Parentheses.
 * 
 * Example 1:

   Input: s = "(1+(2*3)+((8)/4))+1"
   Output: 3
   Explanation: Digit 8 is inside of 3 nested parentheses in the string.

   Example 2:
   
   Input: s = "(1)+((2))+(((3)))"
   Output: 3
*/

// import java.util.ArrayList;

public class Maximum_Nesting_Depth_of_the_Parentheses {
    public static int maxDepth(String str) {
        /*
         * BruteForce Approach: Time complexity: O(N) & Space complexity: O(N).
         * ArrayList<Integer> temp = new ArrayList<>();
           int j = 0;
           int max = Integer.MIN_VALUE;
           for(int i = 0; i < str.length(); i++){
               if(str.charAt(i) == '('){
                   j++;
                   max = Math.max(max, j);
               }
               if(str.charAt(i) == ')'){
                   j--;
                   if(j == 0){
                       temp.add(max);
                       max = Integer.MIN_VALUE;
                   }
               }
           }
           int ans = 0;
           for(int i = 0; i < temp.size(); i++){
               ans = Math.max(ans, temp.get(i));
           }
           return ans;
        */
        
        // Optimized Approach: Time complexity: O(N) & Space complexity: O(1).
        
        int ans = 0, j = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                j++;
            }
            if(str.charAt(i) == ')'){
                j--;
            }
            ans = Math.max(ans, j);
        }
        return ans;
    }
    public static void main(String[] args) {
        String str = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(str));
    }
}
