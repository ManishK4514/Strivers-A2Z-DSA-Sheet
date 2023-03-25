/*
   Number of Provinces
   Problem Statement: Given an undirected graph with V vertices. We say two vertices u and v belong to a single province if there is a path from u to v or v to u. Your task is to find the number of provinces.
   
   Pre-req: Connected Components, Graph traversal techniques
   
   Examples:
   
   Input: {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}};   
   Output: 3
   
*/

import java.util.ArrayList;

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

public class Number_of_Provinces {
    public static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        DisjointSet ds = new DisjointSet(V);

        // O(N^2)
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                if(adj.get(i).get(j) == 1){
                    ds.unionBySize(i, j);
                }
            }
        }
        
        int count = 0;
        
        for(int i = 0; i < V; i++){
            if(ds.parent[i] == i) count++;
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
                
        System.out.println("Total no. of Provinces: " + numProvinces(adj, 3));
    }
}
