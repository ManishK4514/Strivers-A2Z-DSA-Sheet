/*
   347. Top K Frequent Elements
   Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
   
    
   
   Example 1:
   
   Input: nums = [1,1,1,2,2,3], k = 2
   Output: [1,2]
   Example 2:
   
   Input: nums = [1], k = 1
   Output: [1]
*/

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.Arrays;

class Pair implements Comparable<Pair>{
    int key;
    int value;
    Pair(int key, int value){
        this.key = key;
        this.value = value;
    }
    public int compareTo(Pair o){
        return this.value - o.value;
    }
}

public class K_most_frequent_elements {
    public static int[] topKFrequent(int[] nums, int k) {
        /*
           Solution 1: Using BucketSort
           
           List<Integer>[] bucket = new List[nums.length + 1];
	       Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
       
	       for (int n : nums) {
	       	frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
	       }
       
	       for (int key : frequencyMap.keySet()) {
	       	int frequency = frequencyMap.get(key);
	       	if (bucket[frequency] == null) {
	       		bucket[frequency] = new ArrayList<>();
	       	}
	       	bucket[frequency].add(key);
	       }
       
	       List<Integer> res = new ArrayList<>();
       
	       for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
	       	if (bucket[pos] != null) {
	       		res.addAll(bucket[pos]);
	       	}
	       }
   
           int[] ans = new int[res.size()];
           for(int i = 0; i < res.size(); i++){
               ans[i] = res.get(i);
           }
	       return ans;
        */

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            Pair pair = new Pair(entry.getKey(), entry.getValue());
            pq.add(pair);
            if(pq.size() > k){
                pq.remove();
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = pq.remove().key;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
