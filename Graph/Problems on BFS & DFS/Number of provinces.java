/*
   Q. Number of provinces.
   Given an undirected graph with V vertices. We say two vertices u and v belong to a single province if there is a path from u to v or v to u. Your task is to find the number of provinces.

    Note: A province is a group of directly or indirectly connected cities and no other cities outside of the group.
    
    Example 1:
    
    Input:
    [
     [1, 0, 1],
     [0, 1, 0],
     [1, 0, 1]
    ]
    
    Output:
    2
    Explanation:
    The graph clearly has 2 Provinces [1,3] and [2]. As city 1 and city 3 has a path between them they belong to a single province. City 2 has no path to city 1 or city 3 hence it belongs to another province.
    Example 2:
    Input:
    [
     [1, 1],
     [1, 1]
    ]
    
    Output :
    1

    Ex: 
    
       0              1────────────2
     / | \            │            │ ╲
    1──2──3           │            │  5
     \  /             │            │ ╱
      4               3────────────4              
                        
    Int this Example there are two  Two Disconnected  province of Single Graph.
    That means
    province: 2                     
      
*/

import java.util.ArrayList;

public class Number_of_Provinces {

    // Time Complexity: O(N) + O(2E) & Space Complexity: O(2N ≅ N).

    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[node] = true;
        for(int it : adj.get(node)){
            if(!vis[it]){
                dfs(it, adj, vis);
            }
        }
    }
    public static int numProvinces(ArrayList<ArrayList<Integer>> adj, int n) {
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjLs.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(adj.get(i).get(j) == 1 && i != j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        
        int count = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                count++;
                dfs(i, adjLs, vis);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();

        adj.add(new ArrayList<Integer>());
        adj.get(0).add(0, 1);
        adj.get(0).add(1, 0);
        adj.get(0).add(2, 1);
        adj.add(new ArrayList<Integer>());
        adj.get(1).add(0, 0);
        adj.get(1).add(1, 1);
        adj.get(1).add(2, 0);
        adj.add(new ArrayList<Integer>());
        adj.get(2).add(0, 1);
        adj.get(2).add(1, 0);
        adj.get(2).add(2, 1);

        System.out.println(numProvinces(adj, 3));
    }
}
