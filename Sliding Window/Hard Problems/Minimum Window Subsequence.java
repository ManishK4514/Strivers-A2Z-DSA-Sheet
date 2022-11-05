/*
   Minimum Window Subsequence
   Given strings str1 and str2, find the minimum (contiguous) substring W of str1, so that str2 is a subsequence of W.
   
   If there is no such window in str1 that covers all characters in str2, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.
    
   
   Example 1:
   
   Input: 
   str1: geeksforgeeks
   str2: eksrg
   Output: 
   eksforg
   Explanation: 
   Eksforg satisfies all required conditions. str2 is its subsequence and it is longest and leftmost among all possible valid substrings of str1.
   Example 2:
   
   Input: 
   str1: abcdebdde
   str2: bde
   Output: 
   bcde
   Explanation: 
   "bcde" is the answer and "deb" is not a smaller window because the elements of T in the window must occur in order.
*/


public class Minimum_Window_Subsequence {
    public static boolean findMinSizeSubsequence(String str1, String str2){
        int m = str2.length();
        int j = 0;
        for(int i = 0; i < str1.length(); i++){
            if(j < m && str1.charAt(i) == str2.charAt(j)){
                j++;
            }
        }
        if(j == m){
            return true;
        }
        return false;
    }
    public static String minWindow(String str1, String str2)
    {
        String res = "";
        for(int i = 0; i < str1.length(); i++){
            StringBuilder sb = new StringBuilder();
            for(int j = i; j < str1.length(); j++){
                sb.append(str1.charAt(j));
                if(findMinSizeSubsequence(sb.toString(), str2)){
                    if(res.length() == 0 || res.length() > sb.length()){
                        res = sb.toString();
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String str1 = "geeksforgeeks";
        String str2 = "eksrg";
        System.out.println(minWindow(str1, str2));
    }
}
