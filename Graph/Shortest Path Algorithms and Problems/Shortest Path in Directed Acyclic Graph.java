/*
   Shortest path in Directed Acyclic Graph
   Given a Directed Acyclic Graph of N vertices from 0 to N-1 and a 2D Integer array(or vector) edges[ ][ ] of length M, where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i, 0<=i
   
   Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex.
   
   Example:
   
   Input:
   n = 6, m= 7
   edge=[[0,1,2],[0,4,1],[4,5,4]
   ,[4,2,2],[1,2,3],[2,3,6],[5,3,1]]
   
   Output:
   0 2 3 6 1 5
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
 
class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

public class Shortest_path_in_Directed_Acyclic_Graph {
    public static void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int[] vis, Stack<Integer> st){
        vis[node] = 1;
        for(int i = 0; i < adj.get(node).size(); i++){
            int v = adj.get(node).get(i).first;
            if(vis[v] == 0){
                topoSort(v, adj, vis, st);
            }
        }
        st.push(node);
    }
	public static int[] shortestPath(int n,int m, int[][] edges) {
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i = 0; i < n; i++){
		    adj.add(new ArrayList<Pair>());
		}
		for(int i = 0; i < m; i++){
		    int u = edges[i][0];
		    int v = edges[i][1];
		    int wt = edges[i][2];
		    adj.get(u).add(new Pair(v, wt));
		}
		int[] vis = new int[n];
		Stack<Integer> st = new Stack<>();
		for(int i = 0; i < n; i++){
		    if(vis[i] == 0){
		        topoSort(i, adj, vis, st);
		    }
		}
		int[] dist = new int[n];
		for(int i = 0; i < n; i++) dist[i] = (int)(1e9);
		dist[0] = 0;
		while(!st.isEmpty()){
		    int node = st.pop();
		    for(Pair it : adj.get(node)){
		        int v = it.first;
		        int wt = it.second;
		        
		        if(dist[node] + wt < dist[v]){
		            dist[v] = dist[node] + wt;
		        }
		    }
		}
		for (int i = 0; i < n; i++) {
            if (dist[i] == 1e9) dist[i] = -1;
        }
		return dist;
	}
    public static void main(String[] args) {
        int n = 6, m = 7;
        int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        System.out.println(Arrays.toString(shortestPath(n, m, edge)));
    }
}
