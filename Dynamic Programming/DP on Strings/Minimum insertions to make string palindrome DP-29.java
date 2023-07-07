/*
    Q. Minimum insertions to make string palindrome | DP-29

    Practice : https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/

    Given a string s. In one step you can insert any character at any index of the string.

    Return the minimum number of steps to make s palindrome.
    
    A Palindrome String is one that reads the same backward as well as forward.
    
    Example 1:
    
    Input: s = "zzazz"
    Output: 0
    Explanation: The string "zzazz" is already palindrome we do not need any insertions.
    Example 2:
    
    Input: s = "mbadm"
    Output: 2
    Explanation: String can be "mbdadbm" or "mdbabdm".
    Example 3:
    
    Input: s = "leetcode"
    Output: 5
    Explanation: Inserting 5 characters the string becomes "leetcodocteel".
*/

public class Minimum_insertions_to_make_string_palindrome {

    // Longest Common Subsequence
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();

        // shifting 1-index to the right        
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    curr[j] = 1 + prev[j - 1];
                }
                else curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            prev = curr.clone();
        }

        return prev[m];
    }

    // Longest Palindromic Subsequence

    public static int longestPalindromicSubsequence(String str) {
        /*
             Method  (Use lcs -> longest common subsequence to find longest Palindromic Subsequence)
            
            we have String 
            s = "bbabcbcab"
    
            let s1 = "bbabcbcab" and s2 = reverse(s1);
    
            s1 = "bbabcbcab"
            s2 = "bacbcbabb"
    
            find lcs to get the longest Palindrome Subsequences.
            
            Intution: Now the longest subsequnce will be the longest common subsequence 
                      because any other longest subtring will alter after reversing the string
                      except the palindromic substring because palindrom are same after reversing.
    
            code to find the lcs:          
            
            lcs: https://github.com/ManishK4514/Strivers-A2Z-DSA-Sheet/blob/main/Dynamic%20Programming/DP%20on%20Strings/Longest%20Common%20Subsequence.java          
        */

        StringBuilder reversedStr = new StringBuilder(str).reverse();
        String revStr = reversedStr.toString();
        return longestCommonSubsequence(str, revStr);
    }

    //  MAIN QUESTIONS STARTS HERE

    // ____________________________________________________________________________________________________________________________________

    public static int minInsertions(String str) {
        /*
            Method  (Use lps -> longest palindromic subsequence to find min insertion to make a string palindromic Subsequence)
            
            we have String 
            s = "mbadm"
            so we have to make it: s = "mbdadbm"
            that means we have to insert 2 character "bd" to make it palindrome
            and if we see the original string "mbadm" -> "mam" or "mbm" or "mdm" are the longest common substring.
            and whatever we left with -> "bd" or "ad" or "ba" we have to insert another charcter for each of the left character
            to make it palindrome

            
            
            Intution: we have find the longest palindromic substring count and other than the longest palindromic, for each character we have to 
                      insert another character to make it palindrome so the answer will be (totalLengthOfString - longestPalindrome)

            
            Formula:  (totalLengthOfOriginalString - sizeOfLongestPalindromicSubstring)
            ____________________________________________________________________________

            s = "mbadm"
            longest palindrome = "mam" 
            left charcters = "bd"
            after inserting another "bd" --->  "mbdadbm"
            total insertion required = totalLength - longestPalindrome
    
            code to find the lps:          
            
            lps: https://github.com/ManishK4514/Strivers-A2Z-DSA-Sheet/blob/main/Dynamic%20Programming/DP%20on%20Strings/Longest%20Palindromic%20Subsequence.java          
        */

        int ans = str.length() - longestPalindromicSubsequence(str);
        return ans;
    }

    public static void main(String[] args) {
        String str = "leetcode";  
        System.out.println(minInsertions(str));
    }
}
