/*
   Question : https://leetcode.com/problems/cheapest-flights-within-k-stops/
   G-38: Cheapest Flights Within K Stops
   There are n cities and m edges connected by some number of flights. You are given an array of flights where flights[i] = [ fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost price. You have also given three integers src, dst, and k, and return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
   
   Example 1: 
   
   Input:
   n = 4
   flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]]
   src = 0
   dst = 3
   k = 1
   Output:
   700
   Explanation: 
   The optimal path with at most 1 stops from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
   Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.

   Example 2:   
   
   Input:
   n = 3
   flights = [[0,1,100],[1,2,100],[0,2,500]]
   src = 0 
   dst = 2 
   k = 1
   Output:
   200
   Explanation: 
   The graph is shown above.
   The optimal path with at most 1 stops from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
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

class Touple{
    int first;
    int second;
    int third;
    Touple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

public class Cheapest_flights_within_k_stops {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i = 0; i < flights.length; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        int[] dist = new int[n];
        for(int i = 0; i < n; i++) dist[i] = Integer.MAX_VALUE;
        Queue<Touple> q = new LinkedList<>();
        q.add(new Touple(0, src, 0));
        while(!q.isEmpty()){
            Touple it = q.remove();
            int stops = it.first;
            int node = it.second;
            int cost = it.third;

            if(stops > k) continue;
            for(Pair iter : adj.get(node)){
                int adjNode = iter.first;
                int edgeWeight = iter.second;
                if(cost + edgeWeight < dist[adjNode]){
                    dist[adjNode] = cost + edgeWeight;
                    q.add(new Touple(stops + 1, adjNode, dist[adjNode]));
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
    public static void main(String[] args) {
        int n = 4, src = 0, dst = 3, K = 1;
        int[][] flights={{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        System.out.println(findCheapestPrice(n, flights, src, dst, K));
    }
}
