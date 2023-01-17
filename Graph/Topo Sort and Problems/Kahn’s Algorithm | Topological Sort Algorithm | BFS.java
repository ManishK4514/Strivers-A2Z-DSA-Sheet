/*
    Kahn’s Algorithm | Topological Sort Algorithm | BFS: G-21
    Problem Statement: Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.
    
    Note: In topological sorting, node u will always appear before node v if there is a directed edge from node u towards node v(u -> v).
    
    Example 1:
    
    Input: V = 6, E = 6
    5 ---> 0 <-- 4
    │            │
    │            │ 
    ↓            ↓
    2 ---> 3 <-- 1

    Output: 5, 4, 2, 3, 1, 0

    Explanation: A graph may have multiple topological sortings. 
    The result is one of them. The necessary conditions 
    for the ordering are:
    According to edge 5 -> 0, node 5 must appear before node 0 in the ordering.
    According to edge 4 -> 0, node 4 must appear before node 0 in the ordering.
    According to edge 5 -> 2, node 5 must appear before node 2 in the ordering.
    According to edge 2 -> 3, node 2 must appear before node 3 in the ordering.
    According to edge 3 -> 1, node 3 must appear before node 1 in the ordering.
    According to edge 4 -> 1, node 4 must appear before node 1 in the ordering.
    
    The above result satisfies all the necessary conditions. 
    [4, 5, 2, 3, 1, 0] is also one such topological sorting 
    that satisfies all the conditions.

    Example 2:
    
    Input: V = 4, E = 3
    Result: 3, 2, 1, 0

    Explanation: The necessary conditions for the ordering are:
    For edge 1 -> 0 node 1 must appear before node 0.
    For edge 2 -> 0 node 1 must appear before node 0.
    For edge 3 -> 0 node 1 must appear before node 0.
    
    [2, 3, 1, 0] is also another topological sorting for the graph.
*/

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Kahns_Algorithm_Topological_Sort_BFS {
    /*
     * Time Complexity: O(N + E)
     * Space Complexity: O(N)
     */
    
    // BFS 
    public static int[] topoSort(int n, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            for(int it : adj.get(i)){
                // counting indegree for every node
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int[] ans = new int[n];
        int k = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            ans[k++] = node;
            
            // node is in our topo sort
            // so remove it from indegree
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);
        System.out.println(Arrays.toString(topoSort(n, adj)));
    }
}
