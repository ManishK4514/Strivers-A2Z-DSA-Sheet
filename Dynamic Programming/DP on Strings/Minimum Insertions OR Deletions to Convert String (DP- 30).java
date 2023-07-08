/*
    Q. Minimum Insertions/Deletions to Convert String | (DP- 30)

    Practice : https://leetcode.com/problems/delete-operation-for-two-strings/description/

    Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

    In one step, you can delete exactly one character in either string.
    
    Example 1:
    
    Input: word1 = "sea", word2 = "eat"
    Output: 2
    Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

    Example 2:
    
    Input: word1 = "leetcode", word2 = "etco"
    Output: 4
*/

public class Minimum_Insertions_OR_Deletions_to_Convert_String {

    // Longest Common Subsequnce 
    // lcs: https://github.com/ManishK4514/Strivers-A2Z-DSA-Sheet/blob/main/Dynamic%20Programming/DP%20on%20Strings/Longest%20Common%20Subsequence.java

    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
   
        // shifting 1-index to the right        
        int[][] dp = new int[n + 1][m + 1];
   
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
   
        return dp[n][m];
    }

    public static int minDistance(String word1, String word2) {

        /*
           Method 
           _________________________________________________________________
    
           We have,
           s1 = "leetcode"
           s2 = "etco"

           we have to delete minimum character from s1 and s2 to make it same string
           that means we have to leave the common characters that are in a sequnce from both the string and rest we have to delete from both
           so that if we find the longest common subsequence from both the string then 

           the no. of character we have to delete is: (s1.length + s2.length) - (lcs from s1 + lcs from s2)
                                                ----> (s1.length + s2.length) - (2 * lcs of s1 & s2)

           and this is the count of the minimum character that we have to delete      
           
           minDeletion = (s1.length + s2.length) - (2 * lcs of s1 & s2)
    
        */

        int n = word1.length();
        int m = word2.length();

        return (n + m) - (2 * longestCommonSubsequence(word1, word2));
    }
    public static void main(String[] args) {
        String word1 = "leetcode", word2 = "etco";
        System.out.println(minDistance(word1, word2));
    }
}
