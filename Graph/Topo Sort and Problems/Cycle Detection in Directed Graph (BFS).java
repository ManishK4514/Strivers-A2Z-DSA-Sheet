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
import java.util.Queue;
import java.util.LinkedList;

public class Detect_cycle_in_a_directed_graph_bfs {
     /*
     * Time Complexity: O(N + E)
     * Space Complexity: O(N)
     */

    // BFS - Breadth First Search

    public static boolean isCyclic(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        int k = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            k++;
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        // we just have to print the wheather it is cycle or not so if it is dag 
        // then the value of k will be n otherwise if there is a cycle then the 
        // value k will be less that n so through this we can decide wheather graph 
        // contains cycle or not
        return k != n;
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
