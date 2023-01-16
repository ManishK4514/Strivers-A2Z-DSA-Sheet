/*
    Find Eventual Safe States
    A directed graph of V vertices and E edges is given in the form of an adjacency list adj. Each node of the graph is labelled with a distinct integer in the range 0 to V - 1.
    
    A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node.
    
    You have to return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
    
    Example 1:
    
    Input:
    
    0 --->1
    │ ╲  │
    │  ╲ │ 6
    ↓   ╲↓
    2    3
    │
    ↓
    5<---4
    
    Output:
    2 4 5 6
    Explanation:
    The given graph is shown above.
    Nodes 5 and 6 are terminal nodes as there are no 
    outgoing edges from either of them. 
    Every path starting at nodes 2, 4, 5, and 6 all 
    lead to either node 5 or 6.

    Example 2:
    
    Input:
    0
    
    Output:
    3
    Explanation:
    Only node 3 is a terminal node, and every path 
    starting at node 3 leads to node 3.
*/

import java.util.List;
import java.util.ArrayList;

public class find_Eventual_Safe_States {
     /*
     * Time Complexity: O(N + E)
     * Space Complexity: O(N)
     */

    // DFS - Depth First Search
    public static boolean dfs(int node, List<List<Integer>> adj, int[] vis, int[] pathVis, int[] check){
        vis[node] = 1;
        pathVis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                if(dfs(it, adj, vis, pathVis, check) == true) return true;
            }
            else if(pathVis[it] == 1) return true;
        }
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }
    public static List<Integer> eventualSafeNodes(int n, List<List<Integer>> adj) {
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        int[] check = new int[n];
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                dfs(i, adj, vis, pathVis, check);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(check[i] == 1){
                res.add(i);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int n = 12;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(2).add(4);
        adj.get(3).add(4);
        adj.get(3).add(5);
        adj.get(4).add(6);
        adj.get(5).add(6);
        adj.get(6).add(7);
        adj.get(8).add(1);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);
        adj.get(11).add(9);
        
        System.out.println(eventualSafeNodes(n, adj));
    }
}
