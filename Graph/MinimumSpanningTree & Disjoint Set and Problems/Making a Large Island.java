/*
   Making a Large Island – DSU: G-52
   Problem Statement: You are given an n x n binary grid. A grid is said to be binary if every value in the grid is either 1 or 0. You can change at most one cell in the grid from 0 to 1. You need to find the largest group of connected  1’s. Two cells are said to be connected if both are adjacent to each other and both have the same value.
   
   Pre-requisite: Disjoint Set data structure
   
   Example 1:
   
   Input Format: The following grid is given:
   
   Result: 20
   Explanation: We can get the largest group of 20 connected 1s if we change the (2,2) to 1. The groups are shown with colored cells.
   
   Example 2:
   
   Input Format: The following grid is given:
   Result: 11 Explanation: We can get the largest group of 11 connected 1s if we change the (3,0) to 1. The groups are shown with colored cells.
  
*/

import java.util.HashSet;

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

public class Making_a_Large_Island {
    public static int largestIsland(int[][] grid) {        
        int n = grid.length;

        DisjointSet ds = new DisjointSet(n * n);

        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 0) continue;
                
                int[] delRow = {-1, 0, 1, 0};
                int[] delCol = {0, 1, 0, -1};
                
                for(int i = 0; i < 4; i++){
                    int adjRow = row + delRow[i];
                    int adjCol = col + delCol[i];
                    
                    if(adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < n && grid[adjRow][adjCol] == 1){
                        int nodeNo = row * n + col;
                        int adjNodeNo = adjRow * n + adjCol;
                        if(ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)){  
                            ds.unionBySize(nodeNo, adjNodeNo);
                        }
                    }
                }
            }
        }
        int ans = 0;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 1) continue;
                
                int[] delRow = {-1, 0, 1, 0};
                int[] delCol = {0, 1, 0, -1};
                
                HashSet<Integer> components = new HashSet<>();

                for(int i = 0; i < 4; i++){
                    int adjRow = row + delRow[i];
                    int adjCol = col + delCol[i];
                    
                    if(adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < n && grid[adjRow][adjCol] == 1){
                        int adjNodeNo = adjRow * n + adjCol;
                        
                        components.add(ds.findUPar(adjNodeNo));
                    }
                }
                
                int totalSize = 0;
                for(int parent : components){
                    totalSize += ds.size[parent];
                }
                ans = Math.max(ans, totalSize + 1);
            }
        }
        for(int i = 0; i < n * n; i++){
            ans = Math.max(ans, ds.size[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 1, 1, 0}, {1, 1, 0, 1, 1, 0},
            {1, 1, 0, 1, 1, 0}, {0, 0, 1, 0, 0, 0},
            {0, 0, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 0}
        };
        
        System.out.println("The largest group of connected 1s is of size: " + largestIsland(grid));
    }
}
