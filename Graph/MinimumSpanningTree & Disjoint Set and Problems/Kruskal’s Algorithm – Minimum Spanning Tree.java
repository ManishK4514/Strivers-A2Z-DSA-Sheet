/*
   Kruskal’s Algorithm – Minimum Spanning Tree : G-47
   Problem Statement: Given a weighted, undirected, and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.
   
   Example 1:
   
   Input Format: 
   V = 5, edges = { {0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {4, 2, 7}}
   
   Result: 16
   Explanation: The minimum spanning tree for the given graph is drawn below:
   MST = {(0, 1), (0, 3), (1, 2), (1, 4)}
   
   Example 2:
   
   Input Format: 
   V = 5, 
   edges = { {0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}}
   
   Result: 5
   Explanation: The minimum spanning tree is drawn below:
   MST = {(0, 2), (1, 2), (2, 3), (3, 4)}
  
*/

import java.util.Arrays;

class DisjointSet{
    int[] rank, parent;
    // Constructor
    DisjointSet(int n){
        rank = new int[n + 1];
        parent = new int[n + 1];
        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }
    }

    // find Ultimate Parent
    public int findUPar(int node){
        if(node == parent[node]) return node;
        return parent[node] = findUPar(parent[node]);
    }

    // Union by Rank
    public void unionByRank(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v) return;
        if(rank[ulp_u] < rank[ulp_v]){
            parent[ulp_u] = parent[ulp_v];
        }
        else if(rank[ulp_u] < rank[ulp_v]){
            parent[ulp_v] = parent[ulp_u];
        }
        else{
            parent[ulp_v] = parent[ulp_u];
            rank[ulp_u]++;
        }
    }
}

public class Kruskals_Algorithm {
    public static int spanningTree(int V, int E, int edges[][]){
	    DisjointSet ds = new DisjointSet(V);
	    Arrays.sort(edges, (a, b)->{
	        return a[2] - b[2];
	    });
	    int ans = 0;
        for(int[] edge : edges){
            if(ds.findUPar(edge[0]) != ds.findUPar(edge[1])){
                ds.unionByRank(edge[0], edge[1]);
                ans += edge[2];
            }
        }
        return ans;
	}
    public static void main(String[] args) {
        int V = 5, E = 6;
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
        System.out.println("The sum of all the edge weights: " + spanningTree(V, E, edges));
    }
}
