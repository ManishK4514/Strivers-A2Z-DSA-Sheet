/*
   Question : https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=distance-from-the-source-bellman-ford-algorithm
   Bellman Ford Algorithm: G-41
   Problem Statement: Given a weighted, directed and connected graph of V vertices and E edges, Find the shortest distance of all the vertices from the source vertex S.
   
   Note: If the Graph contains a negative cycle then return an array consisting of only -1.
   
   Example 1:
   
   Input Format: 
   V = 6, 
   E = [[3, 2, 6], [5, 3, 1], [0, 1, 5], [1, 5, -3], [1, 2, -2], [3, 4, -2], [2, 4, 3]], 
   S = 0
   
   Result: 0 5 3 3 1 2
   Explanation: Shortest distance of all nodes from the source node is returned.
   Example 2:
   
   Input Format: V = 2, E = [[0,1,9]],  S = 0
   
   Result: 0 9
   Explanation: Shortest distance of all nodes from the source node is returned.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Bellman_Ford_Algorithm {
    // Time Compleixty: O(V * E)
    public static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int)(1e8));
        dist[S] = 0;
        for(int i = 0; i < V - 1; i++){
            for(ArrayList<Integer> it : edges){
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if(dist[u] != 1e8 && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }
        for(ArrayList<Integer> it : edges){
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if(dist[u] != 1e8 && dist[u] + wt < dist[v]){
                return new int[]{-1};
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int V = 6;
        int S = 0;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
                add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
                add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
            }
        };

        int[] dist = bellman_ford(V, edges, S);
        System.out.println(Arrays.toString(dist));
    }
}
