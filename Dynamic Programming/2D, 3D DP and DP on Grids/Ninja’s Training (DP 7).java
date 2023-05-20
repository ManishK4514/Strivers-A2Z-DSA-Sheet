/*
    Q. Dynamic Programming: Ninja’s Training (DP 7)
    Practice : https://practice.geeksforgeeks.org/problems/geeks-training/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=geeks-training
    Geek is going for n days training program, he can perform any one of these three activities Running, Fighting, and Learning Practice. Each activity has some point on each day. as Geek wants to improve all his skills, he can't do the same activity on two consecutive days, help Geek to maximize his merit points as we were given a 2D array of n*3 points corresponding to each day and activity.

    Example:
    Input:
    n = 3
    point= [[1,2,5],[3,1,1],[3,3,3]]
    Output:
    11
    Explanation:
    Geek will learn a new move and earn 5 point then on second
    day he will do running and earn 3 point and on third day
    he will do fighting and earn 3 points so, maximum point is 11.
*/

// import java.util.Arrays;

public class Ninjas_Training {
    /*
       // Recursion
       public static int helper(int[][] points, int idx, int prev){
           if(idx < 0) return 0;
           int maxPoint = 0;
           for(int i = 0; i < 3; i++){
               if(i == prev) continue;
               int currPoint = points[idx][i] + helper(points, idx - 1, i);
               maxPoint = Math.max(maxPoint, currPoint);
           }
           
           if(prev == -1) return maxPoint;
           
           return maxPoint;
       }
       public static int maximumPoints(int points[][],int N){
           return helper(points, N - 1, -1);
       }
    */

    /*
       // Memoization
       public static int helper(int[][] points, int idx, int prev, int[][] dp){
           if(idx < 0) return 0;
           if(prev != -1 && dp[idx][prev] != -1) return dp[idx][prev];
           int maxPoint = 0;
           for(int i = 0; i < 3; i++){
               if(i == prev) continue;
               int currPoint = points[idx][i] + helper(points, idx - 1, i, dp);
               maxPoint = Math.max(maxPoint, currPoint);
           }
           
           if(prev == -1) return maxPoint;
           
           return dp[idx][prev] = maxPoint;
       }
       public static int maximumPoints(int points[][],int N){
           int[][] dp = new int[N + 1][4];
           for(int[] it : dp) Arrays.fill(it, -1);
           return helper(points, N - 1, -1, dp);
       }
    */

    // Tabulation
    public static int maximumPoints(int points[][],int N){
        int[][] dp = new int[N][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        for(int day = 1; day < N; day++){
            for(int last = 0; last < 4; last++){
                for(int task = 0; task < 3; task++){
                    if(task != last){
                        int point = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }
        return dp[N - 1][3];
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] point= {{1,2,5},{3,1,1},{3,3,3}};

        System.out.println(maximumPoints(point, n));
    }
}
