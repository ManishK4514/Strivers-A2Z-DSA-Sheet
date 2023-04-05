/*
   Articulation Point in Graph: G-56
   Question link (gfg) -> https://shorturl.ac/gfg_articulation_point_1
   Problem Statement: Given an undirected connected graph with V vertices and adjacency list adj. You are required to find all the vertices removing which (and edges through it) disconnect the graph into 2 or more components.
   
   Note: Indexing is zero-based i.e nodes numbering from (0 to V-1). There might be loops present in the graph.
   
   Pre-requisite: Bridges in Graph problem & DFS algorithm.
   
   Example 1:
   
   Input Format:
   
   Result: {0, 2}
   Explanation: If we remove node 0 or node 2, the graph will be divided into 2 or more components.
   
   Example 2:
   
   Input Format:
   
   Result: {1, 4}
   Explanation: If we remove either node 1 or node 4, the graph breaks into multiple components.

*/

import java.util.ArrayList;

public class Articulation_Point_I {
    static int timer = 1;
    public static void dfs(int node, int parent, int[]vis, ArrayList<ArrayList<Integer>> adj, int[] tin, int[] low, int[] mark){
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        int child = 0;
        for(int it : adj.get(node)){
            if(it == parent) continue;
            if(vis[it] == 0){
                dfs(it, node, vis, adj, tin, low, mark);
                low[node] = Math.min(low[node], low[it]);
                // node --- it
                if(low[it] >= tin[node] && parent != -1){
                    mark[node] = 1;
                }
                child++;
            }
            else{
                low[node] = Math.min(low[node], tin[it]);
            }
        }
        if(child > 1 && parent == -1){
            mark[node] = 1;
        }
    }

    //Function to return Breadth First Traversal of given graph.
    public static ArrayList<Integer> articulationPoints(int n,ArrayList<ArrayList<Integer>> adj){
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        int[] mark = new int[n];
        
        dfs(0, -1, vis, adj, tin, low, mark);
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(mark[i] == 1){
                ans.add(i);
            }
        }
        if(ans.size() == 0) ans.add(-1);
        return ans;
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
            {0, 1}, {1, 4},
            {2, 4}, {2, 3}, {3, 4}
        };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            int u = edges[i][0], v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.println(articulationPoints(n, adj));
    }
}
