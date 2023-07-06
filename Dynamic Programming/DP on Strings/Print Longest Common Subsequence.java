/*
    Q. Print Longest Common Subsequence | (DP – 26)
    Problem Statement: 
    
    Print Longest Common Subsequence
    
    In the previous article Longest Common Subsequence, we learned to print the length of the longest common subsequence of two strings. In this article, we will learn to print the actual string of the longest common subsequence. 
    
    Prereq: Longest Common Subsequence
    
    Intuition:
    
    Let us consider the following example:
    
    We will continue from where we left in the article DP-25. There in the tabulation approach, we declared a dp array and dp[n][m] will have the length of the longest common subsequence., i.e dp[n][m] = 3.
    
    Now, with help of two nested loops, if we print the dp array, it will look like this:
    
    
    Here dp[5][5] gives us the length of the longest common subsequence: 3.
    
    Now let us try to form the string itself. We know its length already. We give it the name str.
    
    
    We will use the dp array to form the LCS string. For that, we need to think, about how did the dp array was originally filled. The tabulation approach used 1-based indexing. We also write the characters corresponding to the indexes of the dp array:
    
    
    Now, let us see what were the conditions that we used while forming the dp array:
    
    if(S1[i-1] == S2[j-1]), then return 1 + dp[i-1][j-1]
    if(S1[i-1] != S2[j-1]) , then return 0 + max(dp[i-1][j],dp[i][j-1])
    These two conditions along with the dp array give us all the required information required to print the LCS string.
    
    Approach:
    The algorithm approach is stated below:
    
    -> We will fill the string str from the last by maintaining a pointer. 
    -> We will start from the right-most cell of the dp array, initially i=n and j=m.
    -> At every cell, we will check if S1[i-1] == S2[j-1], if it is then it means this character is a part of the longest common substring. So we will push it to the str (at last). Then we will move to the diagonally top-left(↖)  cell by assigning i to i-1 and j to j-1.
    -> Else, this character is not a part of the longest common subsequence. It means that originally this cell got its value from its left cell (←) or from its top cell (↑). Whichever cell’s value will be more of the two, we will move to that cell.
    -> We will continue till i>0 and j>0, failing it we will break from the loop.
    -> At last we will get our lcs string in “str”.
*/

public class Print_Longest_Common_Subsequence {
    public static void lcs(String s1, String s2){
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
        
        StringBuilder ans = new StringBuilder();
        for(int k = 1; k <= len; k++){
            ans.append("&"); // dummy character
        }

        while(i > 0 && j > 0){
            if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                ans.setCharAt(idx, s1.charAt(i - 1));
                i--; j--; idx--;
            }
            else if(dp[i - 1][j] > dp[i][j - 1]) i--;
            else j--;
        }

        System.out.println(ans);
    }
    public static void main(String[] args) {
        String s1= "abcde";
        String s2= "bdgek";

        lcs(s1, s2);
    }
}
