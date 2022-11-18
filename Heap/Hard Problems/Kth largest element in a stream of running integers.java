/*
   703. Kth Largest Element in a Stream
   Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
   
   Implement KthLargest class:
   
   KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
   int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
    
   
   Example 1:
   
   Input
   ["KthLargest", "add", "add", "add", "add", "add"]
   [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
   Output
   [null, 4, 5, 5, 8, 8]
   
   Explanation
   KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
   kthLargest.add(3);   // return 4
   kthLargest.add(5);   // return 5
   kthLargest.add(10);  // return 5
   kthLargest.add(9);   // return 8
   kthLargest.add(4);   // return 8
*/

import java.util.PriorityQueue;


class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {        
        this.k = k;
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.remove();
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > k){
            pq.remove();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */


public class Kth_largest_element_in_a_stream_of_running_integers {
    public static void main(String[] args) {
        KthLargest k = new KthLargest(3, new int[]{4, 5,8, 2});
        System.out.println(k.add(3));
        System.out.println(k.add(5));
        System.out.println(k.add(10));
        System.out.println(k.add(9));
        System.out.println(k.add(4));
    }    
}
