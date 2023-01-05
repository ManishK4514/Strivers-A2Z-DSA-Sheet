/*
   Graph Representation Using Adjacency Matrix.
   
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

   Representation in Matrix:
       0 1 2 3 4 5 
      ────────────
   0 │ 0 0 0 0 0 0 
   1 │ 0 0 1 1 0 0 
   2 │ 0 1 0 0 1 1 
   3 │ 0 1 0 0 1 0 
   4 │ 0 0 1 1 0 1 
   5 │ 0 0 1 0 1 0 

   0 --> Represents no Edge
   1 --> Represents There is edge between ith row node and jth col node;

*/

public class Graph_Representation_Using_Adjacency_Matrix {
    public static void representGraph(int n, int[][] input){
        int[][] adj = new int[n + 1][n + 1];
        for(int i = 0; i < input.length; i++){
            adj[input[i][0]][input[i][1]] = 1;
            adj[input[i][1]][input[i][0]] = 1;
        }

        // Printing Matrix
        for(int[] nums : adj){
            for(int i : nums){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] input = {{1, 2}, {1, 3}, {3, 4}, {2, 4}, {2, 5}, {4, 5}};      
        representGraph(n, input);          
    }
}
