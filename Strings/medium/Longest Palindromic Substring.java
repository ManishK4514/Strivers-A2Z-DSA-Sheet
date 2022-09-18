/*
 * Given a string s, return the longest palindromic substring in s.

   A string is called a palindrome string if the reverse of that string is the same as the original string.
   
   Example 1:
   
   Input: s = "babad"
   Output: "bab"
   Explanation: "aba" is also a valid answer.
   Example 2:
   
   Input: s = "cbbd"
   Output: "bb"
*/


public class Longest_Palindromic_Substring {
    public static boolean palindrome(String str){
        // This function will be used in first BruteForce Mehtod
        int i = 0;
        int j = str.length() - 1;
        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++; j--;
        }
        return true;
    }
    public static String longestPalindrome(String s) {
        /*
         * BruteForce Approach: Time complexity: O(N^3) & Space complexity: O(1).
         * int max = Integer.MIN_VALUE;
           StringBuilder ans = new StringBuilder("temp");
           for(int i = 0; i < s.length(); i++){
               for(int j = i; j < s.length(); j++){
                   boolean possible = palindrome(s.substring(i, j + 1));
                   if(possible){
                       if(max < ((j - i) + 1)){
                           max = ((j - i) + 1);
                           ans.replace(0, ans.length(), s.substring(i, j + 1));
                       }
                   }
               }
           }
           return ans.toString();
        */
        int start = 0;
        int maxLen = 1;
        int l, r;
        for(int i = 0; i < s.length(); i++){
            // even
            l=i-1;
            r=i ; 
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if(r-l+1>maxLen){
                    maxLen=r-l+1;
                    start=l;
                }
                l-=1;
                r+=1;
            }            
            // odd    
            l=i-1;
            r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if( r-l+1>maxLen){
                    maxLen=r-l+1;
                    start=l;
                }    
                l-=1;
                r+=1;  
            }            
        }  
        return s.substring(start, start + maxLen);
    }
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
