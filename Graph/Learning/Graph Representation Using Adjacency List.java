import java.util.ArrayList;

/*
   Graph Representation Using Adjacency List.
   
   ①────────────②
   │            │ ╲
   │            │  ⑤
   │            │ ╱
   ③────────────④ 

   Input:
   n = 5;
   m = 6;
   m - lines:
   [1, 2] ---------> means (1 <----> 2) & (2 <-------> 1)
   [1, 3]
   [3, 4]
   [2, 4]
   [2, 5]
   [4, 5]

   Representation in List:

   Step 1: Initialize N + 1 ArrayList (if 1-Based Indexing)
      
   0 │ 
   1 │ -> ② -> ③ 
   2 │ -> ① -> ④ -> ⑤
   3 │ -> ① -> ④ 
   4 │ -> ③ -> ② -> ⑤
   5 │ -> ② -> ④ 

*/

public class Graph_Representation_Using_Adjacency_List {
    public static void representGraph(int n, int[][] input){
        // Declaring ArrayList of ArrayList
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n + 1; i++){
            adj.add(new ArrayList<>());
        }
        // Storing into list;
        for(int i = 0; i < input.length; i++){
            adj.get(input[i][0]).add(input[i][1]);
            adj.get(input[i][1]).add(input[i][0]);
        }
        // Printing list
        System.out.println(adj);
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] input = {{1, 2}, {1, 3}, {3, 4}, {2, 4}, {2, 5}, {4, 5}};      
        representGraph(n, input);    
    }
}
