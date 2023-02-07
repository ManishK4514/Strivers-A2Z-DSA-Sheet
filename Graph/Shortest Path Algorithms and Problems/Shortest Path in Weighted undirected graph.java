/*
   Q. Shortest Path in Weighted undirected graph
   Struggling with Cracking Interviews? Click here to end your problems!
   
   You are given a weighted undirected graph having n+1 vertices numbered from 0 to n and m edges describing there are edges between a to b with some weight, find the shortest path between the vertex 1 and the vertex n and if path does not exist then return a list consisting of only -1.
   
   Example:
   Input:
   n = 5, m= 6
   edges = [[1,2,2], [2,5,5], [2,3,4], [1,4,1],[4,3,3],[3,5,1]]
   Output:
   1 4 3 5
   Explaination:
   Shortest path from 1 to n is by the path 1 4 3 5
*/

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;

class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

public class Shortest_Path_in_Weighted_undirected_graph {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->{return a.first - b.first;});
        int[] parent = new int[n + 1];
        int[] dist = new int[n + 1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
            dist[i] = (int)1e9;
        }
        dist[1] = 0;
        
        pq.add(new Pair(0, 1));
        while(!pq.isEmpty()){
            int dis = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();
            
            for(Pair it : adj.get(node)){
                int adjNode = it.first;
                int edgeWeight = it.second;
                if(dis + edgeWeight < dist[adjNode]){
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                    parent[adjNode] = node;
                }
            }
        }
        
        List<Integer> path = new ArrayList<>();
        if(dist[n] == 1e9){
            path.add(-1);
            return path;
        }
        
        int node = n;
        while(parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }
    public static void main(String[] args) {
        int V = 5, E = 6;

        int[][] edges = {{1,2,2},{2,5,5},{2,3,4},{1,4,1},{4,3,3},{3,5,1}};
        System.out.println(shortestPath(V, E, edges));
    }
}
