/*
   Detect cycle in an undirected graph Using DFS
   Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. Graph is in the form of adjacency list where adj[i] contains all the nodes ith node is having edge with.
   
   Example 1:
   
   Input:  
   V = 5, E = 5
   adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}} 
   Output: 1
   Explanation: 
   
   1->2->3->4->1 is a cycle.
   Example 2:
   
   Input: 
   V = 4, E = 2
   adj = {{}, {2}, {1, 3}, {2}}
   Output: 0
   Explanation: 
   
   No cycle in the graph.


   Ex: Input:
   ①────────────②
   │            │ ╲
   │            │  ⑤
   │            │ ╱
   ③────────────④ 

   Output: True (Yes, there is a cycle in this graph)

*/

import java.util.ArrayList;

public class Cycle_Detection_in_undirected_Graph_using_dfs {
     /*
     * Time Complexity: O(N + 2E) + O(N)  ----> For every node four directions
     * Space Complexity: O(N) + O(N) ≅ O(N)
     */
    public static boolean dfs(int src, int parent, int n, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[src] = true;
        for(int it : adj.get(src)){
            if(vis[it] == false){
                if(dfs(it, src, n, adj, vis)) return true;
            }
            else if(it != parent) return true;
        }
        return false;
    }
    public static boolean isCycle(int n, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[n];
        int parent = -1;
        for(int i = 0; i < n; i++){
            if(vis[i] == false){
                if(dfs(i, parent, n, adj, vis)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(4);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(1);
        adj.get(4).add(3);
        System.out.println(isCycle(5, adj));
    }
}
