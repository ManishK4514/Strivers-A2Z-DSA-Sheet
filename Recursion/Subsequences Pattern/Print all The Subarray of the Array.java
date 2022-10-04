/*
 * Given an integer array nums of unique elements, return all possible subsets (the power set).

   The solution set must not contain duplicate subsets. Return the solution in any order.
   
   Example 1:
   
   Input: nums = [1,2,3]
   Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
   Example 2:
   
   Input: nums = [0]
   Output: [[],[0]]
 */

import java.util.List;
import java.util.ArrayList;

public class Print_all_SubArrays_of_an_Array {
    public static void subset(int idx, int[] nums, ArrayList<Integer> ds, List<List<Integer>> ans){
        if(idx >= nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        // will take
        ds.add(nums[idx]);
        subset(idx + 1, nums, ds, ans);
        ds.remove(ds.size() - 1);

        // will not take
        subset(idx + 1, nums, ds, ans);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subset(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}
