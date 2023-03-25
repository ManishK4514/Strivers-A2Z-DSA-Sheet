/*
   Number of Operations to Make Network Connected – DSU: G-49.
   Problem Statement: You are given a graph with n vertices and m edges. You can remove one edge from anywhere and add that edge between any two vertices in one operation. Find the minimum number of operations that will be required to make the graph connected. If it is not possible to make the graph connected, return -1.
   
   Pre-requisite: Disjoint Set data structure
   
   Example 1:
   
   Input Format: N = 4, M = 3, Edge[] =[ [0,  1], [ 0, 2], [1, 2]]
   
   Result: 1
   Explanation: We need a minimum of 1 operation to make the two components connected. We can remove the edge (1,2) and add the edge between node 2 and node 3 like the following:
   
   Example 2:
   
   Input Format: N = 9, M = 8, Edge[] = [[0,1],[0,2],[0,3],[1,2],[2,3],[4,5],[5,6],[7,8]]
   
   Result: 2
   Explanation: We need a minimum of 2 operations to make the two components connected. We can remove the edge (0,2) and add the edge between node 3 and node 4 and we can remove the edge (0,3) and add it between nodes 6 and 8 like the following:
  
*/

// import java.util.ArrayList;

class DisjointSet{
    int[] size, parent;
    // Constructor
    DisjointSet(int n){
        size = new int[n + 1];
        parent = new int[n + 1];
        for(int i = 0; i <= n; i++){
            size[i] = 1;
            parent[i] = i;
        }
    }

    // find Ultimate Parent
    public int findUPar(int node){
        if(node == parent[node]) return node;
        return parent[node] = findUPar(parent[node]);
    }

    // Union by Size
    public void unionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v) return;
        if(size[ulp_u] < size[ulp_v]){
            parent[ulp_u] = parent[ulp_v];
            size[ulp_v] += size[ulp_u];
        }
        else{
            parent[ulp_v] = parent[ulp_u];
            size[ulp_u] += size[ulp_v];
        }
    }
}

public class Number_of_operations_to_make_network_connected {
    /*
       // BFS -> Breadth First Search (Solution - 01)

       class Solution {
           public int makeConnected(int n, int[][] connections) {
               if(connections.length < n - 1) return -1;
               ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
               for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
               for(int i = 0; i < connections.length; i++){
                   adj.get(connections[i][0]).add(connections[i][1]);
                   adj.get(connections[i][1]).add(connections[i][0]);
               }
               int[] vis = new int[n];
               int ans = 0;
               Queue<Integer> q = new LinkedList<>();
               for(int i = 0; i < n; i++){
                   if(vis[i] == 0){
                       ans++;
                       q.add(i);
                       while(!q.isEmpty()){
                           int node = q.remove();
                           vis[node] = 1;
                           for(int it : adj.get(node)){
                               if(vis[it] == 0) q.add(it);
                           }
                       }
                   }
               }
               return ans - 1;
           }
       }
    */
    
    /*
       // DFS -> Depth First Search  (Solution - 02)

       public static void dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int node){
          vis[node] = 1;
          for(int it : adj.get(node)){
              if(vis[it] == 0) dfs(adj, vis, it);
          }
       }
       public static int makeConnected(int n, int[][] connections) {
          if(connections.length < n - 1) return -1;
          ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
          for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
          for(int i = 0; i < connections.length; i++){
              adj.get(connections[i][0]).add(connections[i][1]);
              adj.get(connections[i][1]).add(connections[i][0]);
          }
          int[] vis = new int[n];
          int ans = 0;
          for(int i = 0; i < n; i++){
              if(vis[i] == 0) {
                  ans++;
                  dfs(adj, vis, i);
              }
          }
          return ans - 1;
       }
    */

    // Disjoint Set -> (Solution - 03)
    
    public static int makeConnected(int n, int[][] connections) {
        // base case
        if(connections.length < n - 1) return -1;
        
        DisjointSet ds = new DisjointSet(n);

        for(int i = 0; i < connections.length; i++){
            ds.unionBySize(connections[i][0], connections[i][1]);
        }
        
        int count = 0;

        for(int i = 0; i < n; i++){
            if(ds.parent[i] == i) count++;
        }

        // To link count provinces we require count - 1 links 
        return count - 1;
    }
    public static void main(String[] args) {
        int V = 9;
        int[][] edge = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {2, 3}, {4, 5}, {5, 6}, {7, 8}};
        System.out.println(makeConnected(V, edge));
    }
}
