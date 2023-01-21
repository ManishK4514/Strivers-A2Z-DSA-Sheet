/*
   Shortest Path in Undirected Graph with unit distance: G-28
   Given an Undirected Graph having unit weight, find the shortest path from the source to all other nodes in this graph. In this problem statement, we have assumed the source vertex to be ‘0’. If a vertex is unreachable from the source node, then return -1 for that vertex.
   
   Example 1:
   
   
   Input:
   n = 9, m = 10
   edges = [[0,1],[0,3],[3,4],[4 ,5],[5, 6],[1,2],[2,6],[6,7],[7,8],[6,8]]
   src=0 
   
   Output: 0 1 2 1 2 3 3 4 4
   
   Explanation:
   The above output array shows the shortest path to all 
   the nodes from the source vertex (0), Dist[0] = 0, 
   Dist[1] = 1 , Dist[2] = 2 , …. Dist[8] = 4 
   Where Dist[node] is the shortest path between src and 
   the node. For a node, if the value of Dist[node]= -1, 
   then we conclude that the node is unreachable from 
   the src node.
   Example 2:
   
   
   Input:
   n = 8, m = 10
   Edges =[[1,0],[2,1],[0,3],[3,7],[3,4],[7,4],[7,6],[4,5],[4,6],[6,5]]
   src=0
   
   Output: 0 1 2 1 2 3 3 2
   
   Explanation: 
   The above output list shows the shortest path to all the 
   nodes from the source vertex (0),  Dist[0] = 0, 
   Dist[1] = 1, Dist[2] = 2,.....Dist[7] = 2
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
 
public class Shortest_path_in_Undirected_Graph_having_unit_distance {
    public static int[] shortestPath(int[][] edges,int n,int m ,int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] dist = new int[n];
        for(int i = 0; i < n; i++) dist[i] = Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src] = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            for(int it : adj.get(node)){
                if(dist[node] + 1 < dist[it]){
                    dist[it] = dist[node] + 1;
                    q.add(it);
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int n=9, m=10;
        int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};
        System.out.println(Arrays.toString(shortestPath(edge, n, m, 0)));
    }
}
