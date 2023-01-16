/*
    Detect cycle in a directed graph
    Stand out from the crowd. Prepare with Complete Interview Preparation  
    
    Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
    
    
    Example 1:
    
    Input:  
     Example 3: 

    1────────────>2
    ↑            │ 
    │            │  
    │            ↓
    3<───────────4 
    
    Output: true
    
    Example 2:
    
    Input:
    1────────────>2
    │            │ ➘
    │            │  5
    ↓            ↓ ➚
    3────────────>4 
    
    Output: false
    Explanation: no cycle in the graph
*/

import java.util.ArrayList;

public class Cycle_Detection_in_Directed_Graph {
    /*
     * Time Complexity: O(N + E)
     * Space Complexity: O(N)
     */

    // DFS - Depth First Search

    public static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis){
        vis[node] = 1;
        pathVis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                if(dfs(it, adj, vis, pathVis) == true) return true;
            }
            else if(pathVis[it] == 1) return true;
        }
        pathVis[node] = 0;
        return false;
    }
    public static boolean isCyclic(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                if(dfs(i, adj, vis, pathVis) == true) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int n = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(5);
        adj.get(4).add(2);

        System.out.println(isCyclic(n, adj));
    }
}
