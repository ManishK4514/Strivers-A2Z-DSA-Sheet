/*
   Given an integer array nums of unique elements, return all possible subsets (the power set).

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

public class Print_All_Subsets {
    public static List<List<Integer>> subsets(int[] nums) {        
        int n = nums.length, subsetSize = (1<<n);
        List<List<Integer>> result = new ArrayList<>();
        for(int num = 0; num <= subsetSize - 1; num++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int bit = 0; bit <= n - 1; bit++){
                if((num&(1<<bit)) != 0){
                    temp.add(nums[bit]);
                }
            }
            result.add(temp);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
}
