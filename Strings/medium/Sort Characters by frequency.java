/*
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

   Return the sorted string. If there are multiple answers, return any of them.
   
   Example 1:
   
   Input: s = "tree"
   Output: "eert"
   Explanation: 'e' appears twice while 'r' and 't' both appear once.
   So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

   Example 2:
   
   Input: s = "cccaaa"
   Output: "aaaccc"
   Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
   Note that "cacaca" is incorrect, as the same characters must be together.

   Example 3:
   
   Input: s = "Aabb"
   Output: "bbAa"
   Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
   Note that 'A' and 'a' are treated as two different characters.
*/


import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class Sort_Characters_by_frequency {
    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();        
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
            else{
                map.put(s.charAt(i), 1);
            }
        }
        List<Character>[] bucket = new List[s.length() + 1];
        for(Character key : map.keySet()){
            int frequency = map.get(key);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = bucket.length - 1; i >= 0; i--){
            if(bucket[i] != null){
                for(char c : bucket[i]){
                    for(i = 0; i < map.get(c); i++){
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();           
    }
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }
}
