/*
    Q. Longest Common Substring | (DP – 27)

    Practice : https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1

    Given two strings. The task is to find the length of the longest common substring.

    Example 1:
    
    Input: S1 = "ABCDGH", S2 = "ACDGHR", n = 6, m = 6
    Output: 4
    Explanation: The longest common substring
    is "CDGH" which has length 4.
    Example 2:
    
    Input: S1 = "ABC", S2 "ACB", n = 3, m = 3
    Output: 1
    Explanation: The longest common substrings
    are "A", "B", "C" all having length 1.
*/

public class Longest_Common_Substring {
    // visualization: https://www.youtube.com/watch?v=_wP9mWNPL5w
    public static int longestCommonSubstr(String s1, String s2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        // don't need to write base case because it is already filled with zeros
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else {
                    // if the character is not same then put 0 to start new string matching from next position
                    dp[i][j] = 0;
                }
            }
        }
        
        int max = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                max = Math.max(max, dp[i][j]);
            }
        }
        
        return max;
    }
    public static void main(String[] args) {
        String S1 = "ABCDGH", S2 = "ACDGHR";
        int n = S1.length(), m = S2.length();
        System.out.println(longestCommonSubstr(S1, S2, n, m));
    }
}
