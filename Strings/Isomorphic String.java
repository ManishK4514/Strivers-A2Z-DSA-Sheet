/*
 * Given two strings s and t, determine if they are isomorphic.

   Two strings s and t are isomorphic if the characters in s can be replaced to get t.
   
   All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
   
    
   
   Example 1:
   
   Input: s = "egg", t = "add"
   Output: true
   Example 2:
   
   Input: s = "foo", t = "bar"
   Output: false
   Example 3:
   
   Input: s = "paper", t = "title"
   Output: true
*/


import java.util.HashMap;

public class Isomorphic_Strings {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Boolean> map2 = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            
            if(map1.containsKey(ch1)){
               if(map1.get(ch1) != ch2){
                   return false;
               }
            }
            else{
                if(map2.containsKey(ch2)){
                    return false;
                }
                else{
                    map1.put(ch1, ch2);
                    map2.put(ch2, true);
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s, t));
    }
}
