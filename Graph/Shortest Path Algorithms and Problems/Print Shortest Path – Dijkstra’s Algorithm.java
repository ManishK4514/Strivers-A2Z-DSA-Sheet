/*
   G-35 : Print Shortest Path – Dijkstra’s Algorithm
   Problem Statement: 
   
   You are given a weighted undirected graph having n+1 vertices numbered from 0 to n and m edges describing there are edges between a to b with some weight, find the shortest path between the vertex 1 and the vertex n, and if the path does not exist then return a list consisting of only -1.
   
   Note: Please read the G-32 and the G-33 article before reading this article to get a clear understanding of Dijkstra’s Algorithm will form the base for this particular problem.
   
   Examples: 
   
   Example 1:
   
   
   Input:
   n = 5, m= 6
   edges = [[1,2,2], [2,5,5], [2,3,4], [1,4,1],[4,3,3],[3,5,1]]
   Output:
   1 4 3 5
   Explanation: 
   The source vertex is 1. Hence, the shortest distance path 
   of node 5 from the source will be 1->4->3->5 as this is 
   the path with a minimum sum of edge weights from source 
   to destination.
   Example 2:
   
   
   Input:
   V = 4, E = 4
   edges = [[1,2,2], [2,3,4], [1,4,1],[4,3,3]]
   Output: 1 4 
   Explanation: 
   The source vertex is 1. Hence, the shortest distance 
   path of node 4 from the source will be 1->4 as this is 
   the path with the minimum sum of edge weights from 
   source to destination.
*/

import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair{
    int distance;
    int node;
    
    Pair(int distance, int node){
        this.distance = distance;
        this.node = node;
    }
}

public class Dijsktra_Algorithm {
    public static int[] dijkstra(int n, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src){
        int[] dist = new int[n];
        for(int i = 0; i < n; i++) dist[i] = Integer.MAX_VALUE;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->{
            return a.distance - b.distance;
        });
        pq.add(new Pair(0, src));
        dist[src] = 0;
        while(!pq.isEmpty()){
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            
            for(ArrayList<Integer> it : adj.get(node)){
                int adjNode = it.get(0);
                int edgeWeight = it.get(1);
                if(dis + edgeWeight < dist[adjNode]){
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }
}
