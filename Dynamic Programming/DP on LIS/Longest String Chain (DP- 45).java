/*
    Q. Longest String Chain | (DP- 45)

    Practice : https://leetcode.com/problems/longest-string-chain/

    You are given an array of words where each word consists of lowercase English letters.

    wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.
    
    For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
    A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
    
    Return the length of the longest possible word chain with words chosen from the given list of words.
    
    Example 1:
    
    Input: words = ["a","b","ba","bca","bda","bdca"]
    Output: 4
    Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
    Example 2:
    
    Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
    Output: 5
    Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
    Example 3:
    
    Input: words = ["abcd","dbqca"]
    Output: 1
    Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
    ["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.
*/

import java.util.Arrays;

public class Longest_String_Chain {
    public static boolean isValid(String s1, String s2){
        if(s2.length() - s1.length() != 1) return false;

        int i = 0, j = 0, diff = 0;

        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) != s2.charAt(j)){
                diff++;
                j++;
            }
            else{
                i++; j++;
            }
        }
        // we can also check i == s1.length() && j == s2.length()
        return diff <= 1;
    }
    public static int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b)->{return a.length() - b.length();});
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        int max = 1;

        for(int i = 0; i < n; i++){
            for(int prevIdx = 0; prevIdx < i; prevIdx++){
                String s1 = words[prevIdx];
                String s2 = words[i];
                
                if(isValid(s1, s2) && dp[i] < dp[prevIdx] + 1){
                    dp[i] = dp[prevIdx] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
    public static void main(String[] args) {
        String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        System.out.println(longestStrChain(words));
    }
}
