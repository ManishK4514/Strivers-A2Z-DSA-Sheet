/*
   LeetCode - (https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/)
   G-43. Find the City With the Smallest Number of Neighbours at a Threshold Distance: 
   Problem Statement: There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi,weighti]  represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distance Threshold. You need to find out a city with the smallest number of cities that are reachable through some path and whose distance is at most Threshold Distance, If there are multiple such cities, our answer will be the city with the greatest number.
   
   Note: that the distance of a path, connecting cities i and j are equal to the sum of the edges’ weights along that path.
   
   Example 1:
   
   Input Format: 
   N=4, M=4, 
   edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], 
   distanceThreshold = 4
   
   Result: 3
   Explanation: 
   The adjacent cities for each city at a distanceThreshold are =
   City 0 →[City 1, City 2]
   City 1 →[City 0, City 2, City 3]
   City 2 →[City 0, City 1, City 3]
   City 3 →[City 1, City 2]
   Here, City 0 and City 3 have a minimum number of cities 
   i.e. 2 within distanceThreshold. So, the result will be the 
   city with the largest number. So, the answer is City 3.
   Example 2:
   
   Input Format: 
   N=3, M=2, edges = [[0,1,3],[1,2,1]], distanceThreshold = 2
   
   Result: 2
   Explanation: 
   City 1 → City 2,
   City 2 → City 1
   Hence, 2 is the answer.
*/

import java.util.Arrays;

public class Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance {
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];
        for(int[] mat : matrix) Arrays.fill(mat, (int)(1e9));
        for(int i = 0; i < edges.length; i++){
            matrix[edges[i][0]][edges[i][1]] = edges[i][2];
            matrix[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        for(int i = 0; i < n; i++) matrix[i][i] = 0;

        // Floyd Warshall
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        int minCntCity = Integer.MAX_VALUE, cityNo = -1;        
        for(int i = 0; i < n; i++){
            int city = 0;
            for(int j = 0; j < n; j++){
                if(matrix[i][j] <= distanceThreshold) city++;
            }
            if(minCntCity >= city){
                minCntCity = city;
                cityNo = i;
            }
        }
        return cityNo;
    }
    public static void main(String[] args) {
        int n = 4, distanceThreshold = 4;
        int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        System.out.println(findTheCity(n, edges, distanceThreshold));
    }
}
