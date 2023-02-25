/*
   Question : https://practice.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-multiplications-to-reach-end
   G-39: Minimum Multiplications to Reach End
   Given start, end, and an array arr of n numbers. At each step, the start is multiplied by any number in the array and then a mod operation with 100000 is done to get the new start.
   Your task is to find the minimum steps in which the end can be achieved starting from the start. If it is not possible to reach the end, then return -1.
   
   Example 2:
   
   Input:
   arr[] = {2, 5, 7}
   start = 3
   end = 30
   Output:
   2
   Explanation: 
   Step 1: 3*2 = 6 % 100000 = 6 
   Step 2: 6*5 = 30 % 100000 = 30
   Therefore, in minimum 2 multiplications we reach the 
   end number which is treated as a destination 
   node of a graph here.
   Example 2:
   
   Input:
   arr[] = {3, 4, 65}
   start = 7
   end = 66175
   Output:
   4
   Explanation: 
   Step 1: 7*3 = 21 % 100000 = 21 
   Step 2: 21*3 = 6 % 100000 = 63 
   Step 3: 63*65 = 4095 % 100000 = 4095 
   Step 4: 4095*65 = 266175 % 100000 = 66175
   Therefore, in minimum 4 multiplications we reach the end number which is treated as a destination node of a graph here.
*/

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Pair{
    int steps;
    int num;
    Pair(int steps, int num){
        this.steps = steps;
        this.num = num;
    }
}
public class Minimum_Multiplications_to_reach_End {
    // Time Complexity: 100000 * N (Hypothetical)
    public static int minimumMultiplications(int[] arr, int start, int end) {
        int[] dist = new int[100000];
        int mod = 100000;
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, start));
        dist[start] = 0;
        while(!q.isEmpty()){
            int steps = q.peek().steps;
            int num = q.peek().num;
            q.remove();
            for(int i = 0; i < arr.length; i++){
                int nnum = (num * arr[i]) % mod;
                if(steps + 1 < dist[nnum]){
                    dist[nnum] = steps + 1;
                    q.add(new Pair(steps + 1, nnum));
                }
            }
        }
        return dist[end] == Integer.MAX_VALUE ? -1 : dist[end];
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, 65};
        int start = 7, end = 66175;
        System.out.println(minimumMultiplications(arr, start, end));
    }
}
