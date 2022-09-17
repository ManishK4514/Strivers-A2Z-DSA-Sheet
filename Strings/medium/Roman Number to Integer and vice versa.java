/*
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

   Symbol       Value
   I             1
   V             5
   X             10
   L             50
   C             100
   D             500
   M             1000
   For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
   
   Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
   
   I can be placed before V (5) and X (10) to make 4 and 9. 
   X can be placed before L (50) and C (100) to make 40 and 90. 
   C can be placed before D (500) and M (1000) to make 400 and 900.
   Given a roman numeral, convert it to an integer.
   
    
   
   Example 1:
   
   Input: s = "III"
   Output: 3
   Explanation: III = 3.
   Example 2:
   
   Input: s = "LVIII"
   Output: 58
   Explanation: L = 50, V= 5, III = 3.
   Example 3:
   
   Input: s = "MCMXCIV"
   Output: 1994
   Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/



import java.util.HashMap;

public class Roman_Number_to_Integer_and_vice_versa {
    public static int romanToInt(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        /*
         * BruteForce Approach: Time complexity: O(N) & Space complexity: O(1). *
         * if(str.length() == 1){
               return map.get(str.charAt(0));
           }
           int num = 0;
           for(int i = 0; i < str.length() - 1; i++){
               if((str.charAt(i) == 'I' && (str.charAt(i + 1) == 'X' || str.charAt(i + 1) == 'V'))|| (str.charAt(i) == 'X' && (str.charAt(i + 1) == 'L' || str.charAt(i + 1) == 'C'))|| (str.charAt(i) == 'C' && (str.charAt(i + 1) == 'D' || str.charAt(i + 1) == 'M'))){
                   num += map.get(str.charAt(i + 1)) - map.get(str.charAt(i));
                   i++;
                   if(i == str.length() - 1){
                       return num;
                   }
               }
               else{
                   num+= map.get(str.charAt(i));
               }
           }
           int i = str.length() - 1;
           if((str.charAt(i - 1) == 'I' && (str.charAt(i) == 'X' || str.charAt(i) == 'V'))|| (str.charAt(i - 1) == 'X' && (str.charAt(i) == 'L' || str.charAt(i) == 'C'))|| (str.charAt(i - 1) == 'C' && (str.charAt(i) == 'D' || str.charAt(i) == 'M'))){
               num -= map.get(str.charAt(i - 1));
               num += map.get(str.charAt(i)) - map.get(str.charAt(i - 1));
           }
           else{
               num += map.get(str.charAt(i));
           }
           return num;
        */
        
        // Same Approach in a little Optimized way. Time complexity: O(N) & Space complexity: O(1).
        
        int num = map.get(str.charAt(str.length() - 1));
        for(int i = str.length() - 2; i >= 0; i--){
            if(map.get(str.charAt(i)) < map.get(str.charAt(i + 1))){
                num -= map.get(str.charAt(i));
            }
            else{
                num += map.get(str.charAt(i));
            }
        }
        return num;
    }
    public static void main(String[] args) {
        String str = "MCMXCIV";
        System.out.println(romanToInt(str));
    }
}
