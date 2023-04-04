/*
   Bridges in Graph – Using Tarjan’s Algorithm of time in and low time: G-55
   Practice link (LeetCode) -> https://leetcode.com/problems/critical-connections-in-a-network/description/
   Problem Statement: There are n servers numbered from 0 to n – 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.
   
   A critical connection is a connection that, if removed, will make some servers unable to reach some other servers.
   
   Return all critical connections in the network in any order.
   
   Note: Here servers mean the nodes of the graph. The problem statement is taken from leetcode.
   
   Pre-requisite: DFS algorithm
   
   Example 1:
   
   Input Format: N = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
   
   Result: [[1, 3]]
   Explanation: The edge [1, 3] is the critical edge because if we remove the edge the graph will be divided into 2 components.
   Example 2:
   
   Input Format:
   
   Result: [[4, 5], [5, 6], [8, 10]]
   Explanation: If we remove any of the three edges, the graph will be divided into 2 or more components.

*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Bridges_in_Graph {
    static int timer = 1;
    public static void dfs(int node, int parent, int[]vis, ArrayList<ArrayList<Integer>> adj, int[] tin, int[] low, List<List<Integer>> bridges){
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        for(int it : adj.get(node)){
            if(it == parent) continue;
            if(vis[it] == 0){
                dfs(it, node, vis, adj, tin, low, bridges);
                low[node] = Math.min(low[node], low[it]);
                // node --- it
                if(low[it] > tin[node]){
                    bridges.add(Arrays.asList(it, node));
                }
            }
            else{
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(List<Integer> it : connections){
            adj.get(it.get(0)).add(it.get(1));
            adj.get(it.get(1)).add(it.get(0));
        }
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, vis, adj, tin, low, bridges);
        return bridges;
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {
            {0, 1}, {1, 2},
            {2, 0}, {1, 3}
        };
        List<List<Integer>> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            connections.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            connections.get(i).add(edges[i][0]);
            connections.get(i).add(edges[i][1]);
        }
        System.out.println(criticalConnections(n, connections));
    }
}
