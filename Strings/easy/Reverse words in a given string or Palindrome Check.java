/*
 * Reverse Words in a String
   Problem Statement: Given a string s, reverse the words of the string.
   
   Examples:
   
   Example 1:
   Input: s=”this is an amazing program”
   Output: “program amazing an is this”
   
   Example 2:
   Input: s=”This is decent”
   Output: “decent is This”
*/


public class Reverse_Words_in_a_String {
    public static String reverseWords(String str) {
        String ans = "";
        int i = str.length() - 1;
        while(i >= 0){
            while(i >= 0 && str.charAt(i) == ' '){
                i--;
            }
            int j = i;
            if(i < 0){
                break;
            }
            while(i >= 0 && str.charAt(i) != ' '){
                i--;
            }
            if(ans.isEmpty()){
                ans = ans.concat(str.substring(i+1, j+1));
            }
            else{
                ans = ans.concat(" " + str.substring(i+1, j+1));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String str = "the sky is blue";
        System.out.println(reverseWords(str));
    }
}
