/*
   Number of Islands – II – Online Queries – DSU: G-51
   practice link (gfg) -> https://practice.geeksforgeeks.org/problems/number-of-islands/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-islands
   Problem Statement: You are given an n, m which means the row and column of the 2D matrix, and an array of size k denoting the number of operations. Matrix elements are 0 if there is water or 1 if there is land. Originally, the 2D matrix is all 0 which means there is no land in the matrix. The array has k operator(s) and each operator has two integers A[i][0], A[i][1] means that you can change the cell matrix[A[i][0]][A[i][1]] from sea to island. Return how many islands are there in the matrix after each operation. You need to return an array of size k.
   
   Note: An island means a group of 1s such that they share a common side.
   
   Pre-requisite: Disjoint Set data structure
   
   Example 1:
   
   Input Format: n = 4 m = 5 k = 4 A = {{1,1},{0,1},{3,3},{3,4}} Output: 1 1 2 2 Explanation: The following illustration is the representation of the operation:
   
   Example 2:
   
   Input Format: n = 4 m = 5 k = 12 A = {{0,0},{0,0},{1,1},{1,0},{0,1},{0,3},{1,3},{0,4}, {3,2}, {2,2},{1,2}, {0,2}} Output: 1 1 2 1 1 2 2 2 3 3 1 1 Explanation: If we follow the process like in example 1, we will get the above result.
  
*/

import java.util.List;
import java.util.ArrayList;

class DisjointSet{
    int[] size, parent;
    // Constructor
    DisjointSet(int n){
        size = new int[n + 1];
        parent = new int[n + 1];
        for(int i = 0; i <= n; i++){
            size[i] = 1;
            parent[i] = i;
        }
    }

    // find Ultimate Parent
    public int findUPar(int node){
        if(node == parent[node]) return node;
        return parent[node] = findUPar(parent[node]);
    }

    // Union by Size
    public void unionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v) return;
        if(size[ulp_u] < size[ulp_v]){
            parent[ulp_u] = parent[ulp_v];
            size[ulp_v] += size[ulp_u];
        }
        else{
            parent[ulp_v] = parent[ulp_u];
            size[ulp_u] += size[ulp_v];
        }
    }
}

public class Number_Of_Islands_II {
    public static List<Integer> numOfIslands(int n, int m, int[][] operators) {
        DisjointSet ds = new DisjointSet(n * m);
        int[][] vis = new int[n][m];
        int cnt = 0;
        List<Integer> res = new ArrayList<>();
        for(int[] it : operators){
            int row = it[0];
            int col = it[1];
            
            if(vis[row][col] == 1) {
                res.add(cnt);
                continue;
            }
            
            vis[row][col] = 1;
            cnt++;
            
            int[] delRow = {-1, 0, 1, 0};
            int[] delCol = {0, 1, 0, -1};
            
            for(int i = 0; i < 4; i++){
                int adjRow = row + delRow[i];
                int adjCol = col + delCol[i];
                
                if(adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < m){
                    // now check for the island also
                    if(vis[adjRow][adjCol] == 1){
                        /* 
                          current rowNo. = row * m + col --> (formula)
                          
                          {0, 1, 2, 3}
                          {4, 5, 6, 7}
                          {8, 9, 10, 11}
                          
                          m = no. of cols
                          eg:- node no. of [2, 1] --> 2 * m + 1 --> 2 * 4 + 1 = 9
                          
                        */
                        
                        int nodeNo = row * m + col;
                        int adjNodeNo = adjRow * m + adjCol;
                        if(ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)){
                            // if they do not belong to the same components
                            // so we are making connections between two adjacent node, reduce cnt
                            cnt--;
                            ds.unionBySize(nodeNo, adjNodeNo);
                        }
                    }
                }
            }
            res.add(cnt);
        }
        return res;
    }
    public static void main(String[] args) {
        int n = 4, m = 5;
        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1},
            {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}
        };
        System.out.println(numOfIslands(n, m, operators));
    }
}
