/*
   Number of Operations to Make Network Connected – DSU: G-49.
   Problem Statement: You are given a graph with n vertices and m edges. You can remove one edge from anywhere and add that edge between any two vertices in one operation. Find the minimum number of operations that will be required to make the graph connected. If it is not possible to make the graph connected, return -1.
   
   Pre-requisite: Disjoint Set data structure
   
   Example 1:
   
   Input Format: N = 4, M = 3, Edge[] =[ [0,  1], [ 0, 2], [1, 2]]
   
   Result: 1
   Explanation: We need a minimum of 1 operation to make the two components connected. We can remove the edge (1,2) and add the edge between node 2 and node 3 like the following:
   
   Example 2:
   
   Input Format: N = 9, M = 8, Edge[] = [[0,1],[0,2],[0,3],[1,2],[2,3],[4,5],[5,6],[7,8]]
   
   Result: 2
   Explanation: We need a minimum of 2 operations to make the two components connected. We can remove the edge (0,2) and add the edge between node 3 and node 4 and we can remove the edge (0,3) and add it between nodes 6 and 8 like the following:
  
*/

import java.util.ArrayList;

public class Number_of_operations_to_make_network_connected {
    /*
       // BFS -> Breadth First Search

       class Solution {
           public int makeConnected(int n, int[][] connections) {
               if(connections.length < n - 1) return -1;
               ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
               for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
               for(int i = 0; i < connections.length; i++){
                   adj.get(connections[i][0]).add(connections[i][1]);
                   adj.get(connections[i][1]).add(connections[i][0]);
               }
               int[] vis = new int[n];
               int ans = 0;
               Queue<Integer> q = new LinkedList<>();
               for(int i = 0; i < n; i++){
                   if(vis[i] == 0){
                       ans++;
                       q.add(i);
                       while(!q.isEmpty()){
                           int node = q.remove();
                           vis[node] = 1;
                           for(int it : adj.get(node)){
                               if(vis[it] == 0) q.add(it);
                           }
                       }
                   }
               }
               return ans - 1;
           }
       }
    */

    // DFS -> Depth First Search

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int node){
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0) dfs(adj, vis, it);
        }
     }
     public static int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) return -1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < connections.length; i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }
        int[] vis = new int[n];
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(vis[i] == 0) {
                ans++;
                dfs(adj, vis, i);
            }
        }
        return ans - 1;
     }
    public static void main(String[] args) {
        int V = 9;
        int[][] edge = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {2, 3}, {4, 5}, {5, 6}, {7, 8}};
        System.out.println(makeConnected(V, edge));
    }
}
