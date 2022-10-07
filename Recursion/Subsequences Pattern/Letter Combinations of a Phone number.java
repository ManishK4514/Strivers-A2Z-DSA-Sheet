/*
   Leetcode 17. Letter Combinations of a Phone Number
 
   Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
   
   A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
     
   Example 1:   
   Input: digits = "23"
   Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

   Example 2:   
   Input: digits = ""
   Output: []

   Example 3:   
   Input: digits = "2"
   Output: ["a","b","c"]
*/


import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class Letter_Combinations_of_a_Phone_Number {
    public static void findCombination(int idx, String digits, List<String> ans, StringBuilder sb, HashMap<Character, String> map){
        if(idx == digits.length()){
            ans.add(sb.toString());
            return;
        }
        String curr = map.get(digits.charAt(idx));
        for(int k = 0; k < curr.length(); k++){
            sb.append(curr.charAt(k));
            findCombination(idx + 1, digits, ans, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0){
            return ans;
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        findCombination(0, digits, ans, new StringBuilder(), map);
        return ans;
    }
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
