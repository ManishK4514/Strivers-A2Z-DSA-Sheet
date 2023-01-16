/*
    Q. Bipartite Graph
    Given an adjacency list of a graph adj  of V no. of vertices having 0 based index. Check whether the graph is bipartite or not.
     
    
    Example 1:
    
    Input: 

           0
        /  |  \
       2   3   1
       |
       4
    
    Output: true
    Explanation: The given graph can be colored 
    in two colors so, it is a bipartite graph.

    Example 2:

    Input:
    1────────────2
    │            │ ╲
    │            │  5
    │            │ ╱
    3────────────4 
    
    Output: false
    Explanation: The given graph cannot be colored 
    in two colors such that color of adjacent 
    vertices differs. 

    Example 3: 

    1────────────2
    │            │ 
    │            │  
    │            │ 
    3────────────4 

    output: true
*/

import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.ArrayList;


public class Bipartite_Graph {
    /*
     * Time Complexity: O(N + 2E)
     * Space Complexity: O(N)
     */



    // DFS - Depth First Search

    /*
       public static boolean dfs(int start, int n, ArrayList<ArrayList<Integer>>adj, int[] color, int currCol){        
           color[start] = currCol;
           for(int node : adj.get(start)){
               if(color[node] == -1){
                   if(dfs(node, n, adj, color, 1 - currCol) == false){
                       return false;
                   }
               }
               else if(color[node] == currCol) return false;
           }
           return true;
       }
       public static boolean isBipartite(int n, ArrayList<ArrayList<Integer>>adj) {
           int[] color = new int[n];
           Arrays.fill(color, -1);
           for(int i = 0; i < n; i++){
               if(color[i] == -1){
                   if(dfs(i, n, adj, color, 0) == false){
                       return false;
                   }
               }
           }
           return true;
       }
    */

    // BFS - Breadth First Search
    
    public static boolean check(int start, int n, ArrayList<ArrayList<Integer>>adj, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            for(int it : adj.get(node)){
                if(color[it] == -1){
                    color[it] = 1 - color[node];
                    q.add(it);
                }
                else if(color[it] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isBipartite(int n, ArrayList<ArrayList<Integer>>adj) {
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for(int i = 0; i < n; i++){
            if(color[i] == -1){
                if(check(i, n, adj, color) == false){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(3);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(0);
        adj.get(3).add(2);

        System.out.println(isBipartite(adj.size(), adj));
    }
}
