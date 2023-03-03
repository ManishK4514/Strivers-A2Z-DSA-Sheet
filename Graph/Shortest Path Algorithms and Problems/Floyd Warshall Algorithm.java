/*
   Question : https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implementing-floyd-warshall2042
   Floyd Warshall Algorithm: G-42
   Problem Statement: The problem is to find the shortest distances between every pair of vertices in a given edge-weighted directed graph. The graph is represented as an adjacency matrix of size n*n. Matrix[i][j] denotes the weight of the edge from i to j. If Matrix[i][j]=-1, it means there is no edge from i to j.
   
   Do it in place.
   
   Example 1:
   
   Input Format: 
   matrix[][] = { {0, 2, -1, -1},
           {1, 0, 3, -1},{-1, -1, 0, -1},{3, 5, 4, 0} }
   
   Result:
   0 2 5 -1 
   1 0 3 -1 
   -1 -1 0 -1 
   3 5 4 0 
   Explanation: In this example, the final matrix 
   is storing the shortest distances. For example, matrix[i][j] is 
   storing the shortest distance from node i to j.
   Example 2:
   
   Input Format: 
   matrix[][] = {{0,25},
                 {-1,0}}
   
   Result:   
   0 25  
   -1 0﻿
   Explanation: In this example, the shortest distance 
   is already given (if it exists).
*/

import java.util.Arrays;

public class Floyd_Warshall_Algorithm {
    // Time Complexity: O(N^3)
    public static void shortest_distance(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == -1) matrix[i][j] = (int) (1e9);
                if(i == j) matrix[i][j] = 0;
            }
        }
        
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        
        // To Detect negative cycle
        for(int i = 0; i < n; i++){
            if(matrix[i][i] < 0){
                System.out.println("Negative Cycle");
                return;
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 1e9) matrix[i][j] = -1;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{0,1,43},{1,0,6},{-1,-1,0}};
        shortest_distance(matrix);
        for(int[] mat : matrix){
            System.out.println(Arrays.toString(mat));
        }
    }
}
