/*
   Depth First Search (DFS) of Graph
   Save Today, Earn More Tomorrow. Get 25% off on Complete Interview Preparation  
   
   You are given a connected undirected graph. Perform a Depth First Traversal of the graph.
   Note: Use a recursive approach to find the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph.
   
   
   Example 1:
   
   Input: V = 5 , adj = [[2,3,1] , [0], [0,4], [0], [2]]
   
           0
        /  |  \
       2   3   1
       |
       4
   Output: 0 2 4 3 1
   Explanation: 
   0 is connected to 2, 3, 1.
   1 is connected to 0.
   2 is connected to 0 and 4.
   3 is connected to 0.
   4 is connected to 2.
   so starting from 0, it will go to 2 then 4,
   and then 3 and 1.
   Thus dfs will be 0 2 4 3 1.
   Example 2:
   
   Input: V = 4, adj = [[1,3], [2,0], [1], [0]]
   
         0
       /   \
      1     3
       \
        2
        
   Output: 0 1 2 3
   Explanation:
   0 is connected to 1 , 3.
   1 is connected to 0, 2. 
   2 is connected to 1.
   3 is connected to 0. 
   so starting from 0, it will go to 1 then 2
   then back to 0 then 0 to 3
   thus dfs will be 0 1 2 3. 
*/

import java.util.ArrayList;
public class DFS_of_Graph {

    // Time Complexity: O(N) + (2E -->total Degree) & Space Complexity: O(3N ≅ N)
    static ArrayList<Integer> ls = new ArrayList<>();
    static boolean[] vis;
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        ls.add(node);
        for(int it : adj.get(node)){
            if(!vis[it]){
                dfs(it, adj);
            }
        }
    }
    public static ArrayList<Integer> dfsOfGraph(int n, ArrayList<ArrayList<Integer>> adj) {
        vis = new boolean[n];
        dfs(0, adj);
        return ls;
    }
    public static void main(String[] args) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);
        System.out.println(dfsOfGraph(5, adj));
    }
}
