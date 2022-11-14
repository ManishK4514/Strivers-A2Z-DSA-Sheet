/*
   215. Kth Largest Element in an Array
   
   Given an integer array nums and an integer k, return the kth largest element in the array.
   
   Note that it is the kth largest element in the sorted order, not the kth distinct element.
   
   You must solve it in O(n) time complexity.
   
   Example 1:
   
   Input: nums = [3,2,1,5,6,4], k = 2
   Output: 5
   Example 2:
   
   Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
   Output: 4
*/


import java.util.PriorityQueue;
import java.util.Collections;

public class Kth_Largest_Element_in_an_Array {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }
        for(int i = 0; i < k - 1; i++){
            pq.poll();
        }
        return pq.poll();
    }
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }
}
