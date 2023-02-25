/*
   Question : https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/
   G-40: Number of Ways to Arrive at Destination
   You are in a city that consists of n intersections numbered from 0 to n – 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.
   
   You are given an integer n and a 2D integer array ‘roads’ where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n – 1 in the shortest amount of time.
   
   Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.
   
   Example 1:   
   Input:
   n=7, m=10
   edges= [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
   Output:
   4
   Explanation: 
   The four ways to get there in 7 minutes (which is the shortest calculated time) are:
   - 0  6
   - 0  4  6
   - 0  1  2  5  6
   - 0  1  3  5  6

   Example 2:   
   Input:
   n=6, m=8
   edges= [[0,5,8],[0,2,2],[0,1,1],[1,3,3],[1,2,3],[2,5,6],[3,4,2],[4,5,2]]
   Output:
   3
   Explanation: 
   The three ways to get there in 8 minutes (which is the shortest calculated time) are:
   - 0  5
   - 0  2  5
   - 0  1  3  4  5
*/

import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair{
    long dis;
    int node;
    
    Pair(long dis, int node){
        this.dis = dis;
        this.node = node;      
    }
}

public class Number_of_Ways_to_Arrive_at_Destination {
    public static int countPaths(int n, int[][] roads) {
        int MOD = (int)(1e9 + 7);
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < roads.length; i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][2], roads[i][1]));
            adj.get(roads[i][1]).add(new Pair(roads[i][2], roads[i][0]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.dis,b.dis));
                
        long[] ways = new long[n];        
        long[] dist = new long[n];
        for(int i = 0; i < n; i++){
            dist[i]= (long) (1e18);
        }
        
        pq.add(new Pair(0, 0));
        dist[0] = 0;
        ways[0] = 1;

        while(!pq.isEmpty()){
            int node = pq.peek().node;
            long dis = pq.peek().dis;
            pq.remove();
                                  
            for(Pair it : adj.get(node)){
                int adjNode = it.node;
                long adjWeight = it.dis;

                if(dis + adjWeight < dist[adjNode]){                    
                    dist[adjNode] = dis + adjWeight;
                    pq.add(new Pair(dis + adjWeight, adjNode));
                    ways[adjNode] = ways[node];
                }
                else if(dis + adjWeight == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node]) % MOD;
                }
            }
        }

        return (int) (ways[n - 1] % MOD);
    }
    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        System.out.println(countPaths(n, roads));
    }
}
