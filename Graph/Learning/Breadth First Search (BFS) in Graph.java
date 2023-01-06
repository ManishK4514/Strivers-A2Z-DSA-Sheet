/*
   Q. Breadth First Search (BFS) In Graph.
   Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
   Note: One can move from node u to node v only if there's an edge from u to v and find the BFS traversal of the graph starting from the 0th vertex, from left to right according to the graph. Also, you should only take nodes directly or indirectly connected from Node 0 in consideration.
   
   
   Example 1:  

   Input: 

        0
      / | \
    1   2  3
       /
      4 

   Output: 0 1 2 3 4
   Explanation: 
   0 is connected to 1 , 2 , 3.
   2 is connected to 4.
   so starting from 0, it will go to 1 then 2
   then 3.After this 2 to 4, thus bfs will be
   0 1 2 3 4.

   Example 2:
   
   Input: 

        0
      /  \
    1     2 

   Output: 0 1 2
   Explanation:
   0 is connected to 1 , 2.
   so starting from 0, it will go to 1 then 2,
   thus bfs will be 0 1 2. 
*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_of_graph {

    // Time Complexity: O(N) + (2E -->total Degree) & Space Complexity: O(3N ≅ N);
    // Adding Neighbour Nodes
    public static void addNeighbours(ArrayList<Integer> nums, Queue<Integer> q, boolean[] vis){
        for(int val : nums){
            if(vis[val] == false){
                // marking true the val in vis array before adding into the queue.
                vis[val] = true;
                q.add(val);
            }
        }
    }
    public static ArrayList<Integer> bfsOfGraph(int n, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        // 0-Based indexing - we will create a visited array of size n.
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        // adding 0 because it is 0-based indexing
        q.add(0);
        // marking 0 as true in visited array
        vis[0] = true;
        while(!q.isEmpty()){
            int curr = q.remove();
            // adding into the bfs array.
            bfs.add(curr);

            // Adding Neighbours of curr Node.
            addNeighbours(adj.get(curr), q, vis);
        }
        return bfs;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        /*
           // Adjacency List of Directed Graph
           0-> 1, 2, 4
           1
           2 -> 4
           3
           4 ->
        */
        
        int n = 5;
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(2).add(4);
        System.out.println(bfsOfGraph(n, adj));
    }
}
