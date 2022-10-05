/*
 * Combination Sum II – Find all unique combinations
   In this article we will solve the most asked interview question “Combination Sum II – Find all unique combinations”.
   
   Problem Statement: Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target. Each number in candidates may only be used once in the combination.
   
   Note: The solution set must not contain duplicate combinations.
   
   Examples:
   
   Example 1:   
   Input: candidates = [10,1,2,7,6,1,5], target = 8   
   Output: 
   [[1,1,6],[1,2,5],[1,7],[2,6]]
   
   Explanation: These are the unique combinations whose sum is equal to target.
    
   Example 2:   
   Input: candidates = [2,5,2,1,2], target = 5   
   Output: [[1,2,2],[5]]   
   Explanation: These are the unique combinations whose sum is equal to target.
*/

import java.util.List;
import java.util.ArrayList;

public class Combination_Sum_II {
    public static void findCombination(int idx, int[] arr, int target, List<List<Integer>> ans, ArrayList<Integer> ds){
        if(idx == arr.length){
            if(target == 0){
                if(!ans.contains(ds)){
                    ans.add(new ArrayList<>(ds));
                }
            }
            return;
        }
        // will take
       
        ds.add(arr[idx]);
        findCombination(idx + 1, arr, target - arr[idx], ans, ds);
        ds.remove(ds.size() - 1);

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
