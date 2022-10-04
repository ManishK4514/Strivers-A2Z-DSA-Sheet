/*
 * Power Set: Print all the possible subsequences of the String
   Problem Statement: Given a string, find all the possible subsequences of the string.
   
   * To calculate the total subseques, the formula is 2^n.
   Examples:
   
   Example 1:
   Input: str = "abc"
   Output: a ab abc ac b bc c
   Explanation: Printing all the 7 subsequence for the string "abc".
   
   Example 2:
   Input: str = "aa"
   Output: a a aa 
   Explanation: Printing all the 3 subsequences for the string "aa"
*/

import java.util.List;
import java.util.ArrayList;
public class Print_all_subsequences_OR_Power_Set {
    public static void solve(ArrayList<String> ans, String str, int idx, String res){
        if(idx >= str.length()){
            ans.add(res);
            return;
        }
        // will take
        res += str.charAt(idx);
        solve(ans, str, idx + 1, res);
        res = res.substring(0, res.length() - 1);
        
        // will not take
        solve(ans, str, idx + 1, res);
    }
    public static List<String> AllPossibleStrings(String str)
    {
        ArrayList<String> ans = new ArrayList<>();
        solve(ans, str, 0, "");
        return ans;
    }
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(AllPossibleStrings(str));
    }
}
