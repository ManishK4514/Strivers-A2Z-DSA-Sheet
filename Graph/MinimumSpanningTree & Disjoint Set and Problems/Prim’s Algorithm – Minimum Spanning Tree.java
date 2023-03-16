/*
   Question : https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-spanning-tree
   Prim’s Algorithm – Minimum Spanning Tree – C++ and Java: G-45
   Problem Statement: Given a weighted, undirected, and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.
   (Sometimes it may be asked to find the MST as well, where in the MST the edge-informations will be stored in the form {u, v}(u = starting node, v = ending node).)
   
   Example 1:
   
   Input Format: 
   V = 5, edges = { {0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {4, 2, 7}}
   
   Result: 16
   Explanation: 
   The minimum spanning tree for the given graph is drawn below:
   MST = {(0, 1), (0, 3), (1, 2), (1, 4)}
   
   Example 2:
   
   Input Format: 
   V = 5, edges = { {0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}}
   
   Result: 5
   Explanation: 
   The minimum spanning tree is drawn below:
   
   MST = {(0, 2), (1, 2), (2, 3), (3, 4)}
   
*/

import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair{
    int node;
    int distance;
    Pair(int node, int distance){
        this.node = node;
        this.distance = distance;
    }
}

public class Prims_Algorithm {
    public static int spanningTree(int V, int E, int edges[][]){
	    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	    for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
	    for(int i = 0; i < E; i++){
	        adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
	        adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
	    }
	    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->{return a.distance - b.distance;});
	    int[] vis = new int[V];
	    pq.add(new Pair(0, 0));
	    int sum = 0;
	    while(!pq.isEmpty()){
	        int wt = pq.peek().distance;
	        int node = pq.peek().node;
	        pq.remove();
	        
	        if(vis[node] == 1) continue;
	        vis[node] = 1;
	        sum += wt;
	        for(Pair it : adj.get(node)){
	            int adjNode = it.node;
	            int adjW = it.distance;
	            
	            if(vis[adjNode] == 0){
	                pq.add(new Pair(adjNode, adjW));
	            }
	        }
	    }
	    return sum;
	}
    public static void main(String[] args) {
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
        int sum = spanningTree(5, 6, edges);
        System.out.println("The sum of all the edge weights: "+ sum);
    }
}
