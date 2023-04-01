/*
   Most Stones Removed with Same Row or Column – DSU: G-53

   LeetCode :- (https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/)

   Problem Statement: There are n stones at some integer coordinate points on a 2D plane. Each coordinate point may have at most one stone.
   
   You need to remove some stones. 
   
   A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.
   
   Given an array of stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the maximum possible number of stones that you can remove.
   
   Pre-requisite: Disjoint Set data structure
   
   Example 1:
   
   Input Format: n=6  stones = [[0, 0],[ 0, 1], [1, 0],[1, 2],[2, 1],[2, 2]]
   
   Result: 5
   Explanation: One of the many ways to remove 5 stones is to remove the following stones:
   [0,0], [1,0], [0,1], [2,1], [1,2]
   Example 2:
   
   Input Format: N = 6, stones = {{0, 0}, {0, 2},  {1, 3}, {3, 1}, {3, 2}, {4, 3}};
   
   Result: 4
   Explanation: We can remove the following stones:
   [0,0], [0,2], [1,3], [3,1]
  
*/

import java.util.HashMap;

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

public class Most_stones_removed_with_same_rows_or_columns {
    public static int removeStones(int[][] stones) {
        int maxRow = 0, maxCol = 0, n = stones.length;
        for(int[] it : stones) {
            maxRow = Math.max(maxRow, it[0]);
            maxCol = Math.max(maxCol, it[1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();

        for(int[] it : stones) {
            int nodeRow = it[0];
            int nodeCol = it[1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }

        int count = 0;
        for(int it : stoneNodes.keySet()){
            if(ds.findUPar(it) == it) {
                count++;
            }
        }
        return n - count;
    }
    public static void main(String[] args) {
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        System.out.println("The maximum number of stones we can remove is: " + removeStones(stones));
    }
}
