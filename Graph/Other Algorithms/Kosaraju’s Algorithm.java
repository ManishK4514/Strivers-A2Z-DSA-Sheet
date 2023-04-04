/**
   Strongly Connected Components – Kosaraju’s Algorithm: G-54
   Question link (gfg) -> https://shorturl.ac/gfg_kosarajus-algo
   Problem Statement: Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, Find the number of strongly connected components in the graph.
   
   Pre-requisite: DFS algorithm
   
   Example 1:
   
   Input Format:
   
   Result: 3
   Explanation: Three strongly connected components are marked below:
   
   Example 2:
   
   Input Format:
   
   Result: 4
   Explanation: Four strongly connected components are marked below:

*/

import java.util.ArrayList;
import java.util.Stack;

public class Kosarajus_Algorithm {
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> st, int node){
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                dfs(adj, vis, st, it);
            }
        }
        st.push(node);
    }

    //Function to find number of strongly connected components in the graph.
    public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                dfs(adj, vis, st, i);
            }
        }
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i = 0; i < V; i++) adjT.add(new ArrayList<>());
        for(int i = 0; i < V; i++){
            vis[i] = 0;
            for(int it : adj.get(i)){
                // previously:  i -> it
                // Now make it: i <- it | it -> i 
                adjT.get(it).add(i);
            }
        }
        int scc = 0;
        while(!st.isEmpty()){
            int node = st.pop();
            if(vis[node] == 0){
                scc++;
                dfs(adjT, vis, new Stack<>(), node);
            }
        }
        return scc;
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
            {1, 0}, {0, 2},
            {2, 1}, {0, 3},
            {3, 4}
        };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        int ans = kosaraju(n, adj);
        System.out.println("The number of strongly connected components is: " + ans);
    }
}
