/*
   Merge k Sorted Arrays
   MediumAccuracy: 67.25%Submissions: 59905Points: 4
   Given K sorted arrays arranged in the form of a matrix of size K*K. The task is to merge them into one sorted array.
   Example 1:
   
   Input:
   K = 3
   arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
   Output: 1 2 3 4 5 6 7 8 9
   Explanation:Above test case has 3 sorted
   arrays of size 3, 3, 3
   arr[][] = [[1, 2, 3],[4, 5, 6], 
   [7, 8, 9]]
   The merged list will be 
   [1, 2, 3, 4, 5, 6, 7, 8, 9].
   Example 2:
   
   Input:
   K = 4
   arr[][]={{1,2,3,4}{2,2,3,4},
            {5,5,6,6},{7,8,9,9}}
   Output:
   1 2 2 2 3 3 4 4 5 5 6 6 7 8 9 9 
   Explanation: Above test case has 4 sorted
   arrays of size 4, 4, 4, 4
   arr[][] = [[1, 2, 2, 2], [3, 3, 4, 4],
   [5, 5, 6, 6]  [7, 8, 9, 9 ]]
   The merged list will be 
   [1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 
   6, 6, 7, 8, 9, 9 ].
*/


import java.util.PriorityQueue;
import java.util.ArrayList;

class Pair implements Comparable<Pair>{
    int value;
    int row;
    int col;
    Pair(int value, int row, int col){
        this.value = value;
        this.row = row;
        this.col = col;
    }
    public int compareTo(Pair o){
        return this.value - o.value;
    }
}

public class Merge_k_Sorted_Arrays {
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int k) 
    {
        /*
           BruteForce Approach: O(NlogN) N -sum of the size of k array & Space Complexity: O(N)
           ArrayList<Integer> list = new ArrayList<>();
           for(int[] temp : arr){
               for(int num : temp){
                   list.add(num);
               }
           }
           Collections.sort(list);
           return list;
        */
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            Pair pair = new Pair(arr[i][0], i, 0);
            pq.add(pair);
        }
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            list.add(curr.value);
            int row = curr.row;
            if(curr.col + 1 < arr[row].length){
                Pair pair = new Pair(arr[row][curr.col + 1], row, curr.col + 1);
                pq.add(pair);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int k = 3;
        System.out.println(mergeKArrays(arr, k));
    }
}
