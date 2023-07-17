/*
    Q. Evaluate Boolean Expression to True | Partition DP: DP 52

    Practice : https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

    Given a boolean expression S of length N with following symbols.
    Symbols
        'T' ---> true
        'F' ---> false
    and following operators filled between symbols
    Operators
        &   ---> boolean AND
        |   ---> boolean OR
        ^   ---> boolean XOR
    Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.
    
     
    
    Example 1:
    
    Input: N = 7
    S = T|T&F^T
    Output: 4
    Explaination: The expression evaluates 
    to true in 4 ways ((T|T)&(F^T)), 
    (T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).
    Example 2:
    
    Input: N = 5
    S = T^F|F
    Output: 2
    Explaination: ((T^F)|F) and (T^(F|F)) are the 
    only ways.
     
    
    Your Task:
    You do not need to read input or print anything. Your task is to complete the function countWays() which takes N and S as input parameters and returns number of possible ways modulo 1003.
*/

// import java.util.*;

/* 

class Pair{
    long first;
    long second;
    Pair(long first, long second){
        this.first = first;
        this.second = second;
    }
}

*/

public class Evaluate_Boolean_Expression_to_True {
    /*
       // My Initial Approach

        private static HashMap<String, Pair> cache;
    
        public static Pair helper(int i, int j, char[] arr){
            String key = i + "-" + j;
            if (cache.containsKey(key)) {
                return cache.get(key);
            }
            
            if(i == j) {
                int t = arr[i] - '0';
                Pair result = (t == 0) ? new Pair(0, 1) : new Pair(1, 0);
                cache.put(key, result);
                return result;
            }
            
            long t = 0, f = 0;
            for(int k = i; k < j; k++){
                if(arr[k] == '&' || arr[k] == '|' || arr[k] == '^'){
                    Pair left = helper(i, k - 1, arr);
                    Pair right = helper(k + 1, j, arr);
                    
                    if(arr[k] == '&') {
                        t += left.first * right.first;
                        f += left.first * right.second;
                        f += left.second * (right.first + right.second);
                    } else if(arr[k] == '|') {
                        t += left.second * right.first;
                        t += left.first * (right.first + right.second);
                        f += left.second * right.second;
                    } else {
                        t += left.first * right.second;
                        t += left.second * right.first;
                        f += left.first * right.first;
                        f += left.second * right.second;
                    }
                }
            }
            
            Pair result = new Pair(t, f);
            cache.put(key, result);
            return result;
        }
        
        public static int countWays(int n, String s){
            char[] arr = s.toCharArray();
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == 'T') arr[i] = '1';
                else if(arr[i] == 'F') arr[i] = '0';
            }
            
            cache = new HashMap<>();
            return (int)(helper(0, s.length() - 1, arr).first % 1003);
        }
    */

    /*
       // Recursion

        static int mod = 1003;
        public static int helper(int i, int j, boolean isTrue, String s){
            if(i > j) return 0;
            
            if(i == j){
                if(isTrue) return  s.charAt(i) == 'T' ? 1 : 0;
                else return  s.charAt(i) == 'F' ? 1 : 0;
            }
            
            int ways = 0;
            
            // iterating on operators only
            
            for(int k = i + 1; k < j; k+=2){
                int LT = helper(i, k - 1, true, s);
                int LF = helper(i, k - 1, false, s);
                int RT = helper(k + 1, j, true, s);
                int RF = helper(k + 1, j, false, s); 
                
                if(s.charAt(k) == '&') {
                    
                    if(isTrue) ways = (ways + (LT * RT) % mod) % mod;
                    else ways = (ways + (LT * RF) % mod + (LF * RT) % mod + (LF * RF) % mod) % mod;
                    
                } 
                else if(s.charAt(k) == '|') {
                    
                    if(isTrue) ways = (ways + (LT * RT) % mod + (LT * RF) % mod + (LF * RT) % mod) % mod;
                    else ways = (ways + (LF * RF) % mod) % mod;
                    
                } 
                else {
                    
                    if(isTrue) ways = (ways + (LT * RF) % mod + (LF * RT) % mod) % mod;
                    else ways = (ways + (LT * RT) % mod + (LF * RF) % mod) % mod;
                    
                }
            }
            
            return ways % mod;
        }
    */

    /*
       // Memoization

        static int mod = 1003;
        public static int helper(int i, int j, boolean isTrue, String s, int[][][] dp){
            if(i > j) return 0;
            
            if(i == j){
                if(isTrue) return  s.charAt(i) == 'T' ? 1 : 0;
                else return  s.charAt(i) == 'F' ? 1 : 0;
            }
            
            if(dp[i][j][isTrue ? 1 : 0] != -1) return dp[i][j][isTrue ? 1 : 0];
            
            int ways = 0;
            
            // iterating on operators only
            
            for(int k = i + 1; k < j; k+=2){
                int LT = helper(i, k - 1, true, s, dp);
                int LF = helper(i, k - 1, false, s, dp);
                int RT = helper(k + 1, j, true, s, dp);
                int RF = helper(k + 1, j, false, s, dp); 
                
                if(s.charAt(k) == '&') {
                    
                    if(isTrue) ways = (ways + (LT * RT) % mod) % mod;
                    else ways = (ways + (LT * RF) % mod + (LF * RT) % mod + (LF * RF) % mod) % mod;
                    
                } 
                else if(s.charAt(k) == '|') {
                    
                    if(isTrue) ways = (ways + (LT * RT) % mod + (LT * RF) % mod + (LF * RT) % mod) % mod;
                    else ways = (ways + (LF * RF) % mod) % mod;
                    
                } 
                else {
                    
                    if(isTrue) ways = (ways + (LT * RF) % mod + (LF * RT) % mod) % mod;
                    else ways = (ways + (LT * RT) % mod + (LF * RF) % mod) % mod;
                    
                }
            }
            
            return dp[i][j][isTrue ? 1 : 0] = ways % mod;
        }
        
        public static int countWays(int n, String s){
            int[][][] dp = new int[n][n][2];
            for(int[][] it1 : dp) for(int[] it2 : it1) Arrays.fill(it2, -1);
            return helper(0, s.length() - 1, true, s, dp);
        }
    */

    // Tabulation

    public static int countWays(int n, String s){
        int[][][] dp = new int[n][n][2];
        
        int mod = 1003;
        
        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j <= n - 1; j++){
                for(int isTrue = 0; isTrue <= 1; isTrue++){
                    
                    // base case
                    if(i == j){
                        if(isTrue == 1) dp[i][j][1] = s.charAt(i) == 'T' ? 1 : 0;
                        else dp[i][j][0] = s.charAt(i) == 'F' ? 1 : 0;
                        continue;
                    }
                    
                    int ways = 0;
                    
                    for(int k = i + 1; k < j; k+=2){
                        int LT = dp[i][k - 1][1];
                        int LF = dp[i][k - 1][0];
                        int RT = dp[k + 1][j][1];
                        int RF = dp[k + 1][j][0]; 
                        
                        if(s.charAt(k) == '&') {
                            
                            if(isTrue == 1) ways = (ways + (LT * RT) % mod) % mod;
                            else ways = (ways + (LT * RF) % mod + (LF * RT) % mod + (LF * RF) % mod) % mod;
                            
                        } 
                        else if(s.charAt(k) == '|') {
                            
                            if(isTrue == 1) ways = (ways + (LT * RT) % mod + (LT * RF) % mod + (LF * RT) % mod) % mod;
                            else ways = (ways + (LF * RF) % mod) % mod;
                            
                        } 
                        else {
                            
                            if(isTrue == 1) ways = (ways + (LT * RF) % mod + (LF * RT) % mod) % mod;
                            else ways = (ways + (LT * RT) % mod + (LF * RF) % mod) % mod;
                            
                        }
                    }
                    dp[i][j][isTrue] = ways % mod;
                }
            }
        }
        
        return dp[0][n - 1][1];
    }
    
    public static void main(String[] args) {
        String s = "F^F&T&F^T|T^F^T^F^T&F^F^T|F|T|F&F&F|F|T&F|F&F^T&F&F^T|T|T|T^T&T|T^F&T|T^F&T|T^F&T&F|T|T^T&F&T|T&F^F";
        System.out.println(countWays(s.length(), s));
    }
}
