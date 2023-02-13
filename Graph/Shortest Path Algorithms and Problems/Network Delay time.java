/*
   743. Network Delay Time
   You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
   
   We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
   
   Example 1:
   Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
   Output: 2
   
   Example 2:
   Input: times = [[1,2,1]], n = 2, k = 1
   Output: 1
   
   Example 3:
   Input: times = [[1,2,1]], n = 2, k = 2
   Output: -1
*/

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

public class Network_Delay_time {
    public static int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < times.length; i++){
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }
        
        int maxDist = -1;

        int[] dist = new int[n + 1];
        for(int i = 1; i <= n; i++){
            dist[i] = (int)(1e9);
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(k, 0));
        dist[k] = 0;

        while(!q.isEmpty()){
            int node = q.peek().first;
            int dis = q.peek().second;
            q.remove();

            for(Pair it : adj.get(node)){
                int adjNode = it.first;
                int adjWeight = it.second;

                if(dis + adjWeight < dist[adjNode]){
                    dist[adjNode] = dis + adjWeight;
                    q.add(new Pair(adjNode, dis + adjWeight));
                }
            }
        }
        
        // System.out.println(Arrays.toString(dist));

        for(int i = 1; i <= n; i++){
            if(dist[i] == 1e9) return -1;
            maxDist = Math.max(maxDist, dist[i]);
        }
        return maxDist;
    }
    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4, k = 2;
        System.out.println(networkDelayTime(times, n, k));
    }
}
