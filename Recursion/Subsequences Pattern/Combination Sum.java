/*
 * Combination Sum – 1
   Problem Statement: 
   
   Given an array of distinct integers and a target, you have to return the list of all unique combinations where the chosen numbers sum to target. You may return the combinations in any order.
   
   The same number may be chosen from the given array an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
   
   It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
   
   Examples:
   
   Example 1:   
   Input: array = [2,3,6,7], target = 7   
   Output: [[2,2,3],[7]]
   
   Explanation: 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
                7 is a candidate, and 7 = 7.
                These are the only two combinations.
   
   
   Example 2:   
   Input: array = [2], target = 1   
   Output: []   
   Explaination: No combination is possible.
*/

import java.util.List;
import java.util.ArrayList;

public class Combination_Sum {
    public static void findCombination(int idx, int[] arr, int target, List<List<Integer>> ans, ArrayList<Integer> ds){
        if(idx == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        // will take
        if(arr[idx] <= target) {
            ds.add(arr[idx]);
            findCombination(idx, arr, target - arr[idx], ans, ds);
            ds.remove(ds.size() - 1);
        }

        // will not take
        findCombination(idx + 1, arr, target, ans, ds);
    }
    public static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0, arr, target, ans, new ArrayList<>());
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2};
        System.out.println(combinationSum(arr, 5));
    }
}
