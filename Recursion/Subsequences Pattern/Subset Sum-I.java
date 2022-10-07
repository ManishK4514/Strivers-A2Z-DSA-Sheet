/*
   Subset Sum-1 : Sum of all Subsets
   Problem Statement: Given an array print all the sum of the subset generated from it, in the increasing order.
   
   Examples:
   
   Example 1:
   Input: N = 3, arr[] = {5,2,1}
   Output: 0,1,2,3,5,6,7,8
   Explanation: We have to find all the subset’s sum and print them.in this case the generated subsets are [ [], [1], [2], [2,1], [5], [5,1], [5,2]. [5,2,1],so the sums we get will be  0,1,2,3,5,6,7,8
   
   
   Input: N=3,arr[]= {3,1,2}   
   Output: 0,1,2,3,3,4,5,6   
   Explanation: We have to find all the subset’s sum and print them.in this case the generated subsets are [ [], [1], [2], [2,1], [3], [3,1], [3,2]. [3,2,1],so the sums we get will be  0,1,2,3,3,4,5,6
*/


import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Subset_Sum_Sum_of_all_Subsets {
    /*
       BruteForce approach:
        public static int sum(ArrayList<Integer> arr){
            int sum = 0;
            for(int i = 0; i < arr.size(); i++){
                sum += arr.get(i);
            }
            return sum;
        }
        public static void findSubsetSum(int idx, int[] arr, List<Integer> ans, ArrayList<Integer> ds){
            if(idx == arr.length){
                ans.add(sum(ds));
                return;
            }
            // pick
            ds.add(arr[idx]);
            findSubsetSum(idx + 1, arr, ans, ds);
            ds.remove(ds.size() - 1);
    
            // not pick
            findSubsetSum(idx + 1, arr, ans, ds);
        }
        public static List<Integer> subsetSum(int[] arr) {
            List<Integer> ans = new ArrayList<>();
            findSubsetSum(0, arr, ans, new ArrayList<>());
            Collections.sort(ans);
            return ans;
        }
    */
    
    // Optimized Approach: Time complexity: O(2^n) * log(2^n) & Space Complexity: O(2^b)
    public static void findSubsetSum(int idx, int[] arr, List<Integer> ans, int sum){
        if(idx == arr.length){
            ans.add(sum);
            return;
        }
        // pick
        findSubsetSum(idx + 1, arr, ans, sum + arr[idx]);

        // not pick
        findSubsetSum(idx + 1, arr, ans, sum);
    }
    public static List<Integer> subsetSum(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        findSubsetSum(0, arr, ans, 0);
        Collections.sort(ans);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {5, 2, 1};
        System.out.println(subsetSum(arr));
    }
}
