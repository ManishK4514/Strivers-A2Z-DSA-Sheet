/*
    Q. Shortest Common Supersequence | (DP – 31)

    Practice : https://leetcode.com/problems/shortest-common-supersequence/

    Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.

    A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.
    
    Example 1:
    
    Input: str1 = "abac", str2 = "cab"
    Output: "cabac"
    Explanation: 
    str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
    str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
    The answer provided is the shortest such string that satisfies these properties.
    
    Example 2:
    
    Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
    Output: "aaaaaaaa"
*/


public class Shortest_Common_Supersequence {
    /*
       Method 1 (MY METHOD)

       * First store the index of the of each charcter of longest common
       * subsequences int pair(i, j) from both the string and the form the shortest
       * common supersequence by iterating the both string and
       * take common characters of lcs once for both the string and 
       * other charcters seprately for the string s1 and string s2 in 
       * a order such that we the s1 is present as subsequnce and also
       * s2 is present as subsequence in supersequence
       _________________________________________________________________

       class Pair{
           int first, second;
           Pair(int first, int second){
               this.first = first;
               this.second = second;
           }
       }
        
       public static Pair[] lcs(String s1, String s2){
            int n = s1.length(), m = s2.length();
    
            int[][] dp = new int[n + 1][m + 1];
    
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    }
                    else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
    
            int len = dp[n][m];
            int i = n, j = m, idx = len - 1;
            
            Pair[] ans = new Pair[len];
    
            while(i > 0 && j > 0){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    ans[idx] = new Pair(i - 1, j - 1);
                    i--; j--; idx--;
                }
                else if(dp[i - 1][j] > dp[i][j - 1]) i--;
                else j--;
            }
    
            return ans;
        }
        public static String shortestCommonSupersequence(String str1, String str2) {
            int[] map1 = new int[26];
            int[] map2 = new int[26];
    
            for(int i = 0; i < str1.length(); i++) map1[str1.charAt(i) - 'a']++;
            for(int i = 0; i < str2.length(); i++) map2[str2.charAt(i) - 'a']++;
            
            Pair[] lcs = lcs(str1, str2);
            int pi = 0, pj = 0;
            StringBuilder sb = new StringBuilder();
    
            for (Pair it : lcs) {
                int i = it.first, j = it.second;
    
                while(pi < i) sb.append(str1.charAt(pi++));
                while(pj < j) sb.append(str2.charAt(pj++));
    
                sb.append(str1.charAt(i));
    
                pi = i + 1;
                pj = j + 1;
            }
    
            while(pi < str1.length()) sb.append(str1.charAt(pi++));
            while(pj < str2.length()) sb.append(str2.charAt(pj++));
    
            return sb.toString();
        }

    */

    /*
       Method 2: visualization: https://www.youtube.com/watch?v=xElxAuBcvsU
       similar to my approach with a consize way
    */

    public static String shortestCommonSupersequence(String s1, String s2) {
        int n = s1.length(), m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        int lcs = dp[n][m];

        /* 
            length of the Shortest Common Supersequence will be:
            we have: 
            s1 = "abac"
            s2 = "cab"

            lcs = "ab"

            so if we will take lcs once for both the string and rest charcter seprately
            for the s1 and s2 then the string will be
            Shortest Common Supersequence --> "cabac"
            which is of minimum size

            and the length is: (s1.length + s2.length) - (length of lcs that will be attached once)

            len = (n + m) - (length of lcs)

        */

        int len = (n + m) - lcs;

        int i = n, j = m, idx = len - 1;
        
        StringBuilder ans = new StringBuilder();
        for(int k = 1; k <= len; k++){
            ans.append("&"); // dummy character
        }

        while(i > 0 && j > 0){
            if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                // add common charcter once for both the strings
                ans.setCharAt(idx, s1.charAt(i - 1));
                i--; j--; idx--;
            }
            else if(dp[i - 1][j] > dp[i][j - 1]) {
                ans.setCharAt(idx, s1.charAt(i - 1));
                i--; idx--;
            }
            else {
                ans.setCharAt(idx, s2.charAt(j - 1));
                j--; idx--;
            }
        }

        while(i > 0) {
            ans.setCharAt(idx, s1.charAt(i - 1));
            idx--; i--;
        }
        while(j > 0) {
            ans.setCharAt(idx, s2.charAt(j - 1));
            idx--; j--;
        }
        
        // the answer will intially be reverse order because we are forming string from last and we have to reverse once to make it original answer

        return ans.reverse().toString();
    }
    public static void main(String[] args) {
        String str1 = "abac", str2 = "cab";
        System.out.println(shortestCommonSupersequence(str1, str2));
    }
}
