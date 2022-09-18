/*
 * Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

   A shift on s consists of moving the leftmost character of s to the rightmost position.
   
   For example, if s = "abcde", then it will be "bcdea" after one shift.
    
   
   Example 1:
   
   Input: s = "abcde", goal = "cdeab"
   Output: true
   Example 2:
   
   Input: s = "abcde", goal = "abced"
   Output: false
*/


public class check_whether_one_string_is_a_rotation_of_another {
    public static boolean rotateString(String s, String goal) {
        /*
           BruteForce Appraoch: Time complexity: O(N^2) & Space complexity: O(1)

           if(s.length() != goal.length()){
               return false;
           }
           for(int i = 0; i < s.length(); i++){
               char lastIdx = goal.charAt(goal.length() - 1);
               for(int j = goal.length() - 2; j >= 0; j--){
                   char c = goal.charAt(j);
                   goal = goal.substring(0, j + 1) + c + goal.substring(j + 2);
               }
               goal = goal.substring(0, 0) + lastIdx + goal.substring(1);
               boolean flag = true;
               for(int j = 0; j < goal.length(); j++){
                   if(s.charAt(j) != goal.charAt(j)){
                       flag = false;
                   }
               }
               if(flag){
                   return true;
               }
           }
           return false;
        */
        
        // optimized Appraoch: Time complexity: O(1) & Space complexity: O(1)

        if(s.length() == goal.length() && (s + s).contains(goal)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        System.out.println(rotateString(s, goal));
    }
}
