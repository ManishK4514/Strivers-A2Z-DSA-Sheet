// Write a program to print all the SubSequences with sum k.
/*
 * Input: [1, 2, 1], Target = 2;
 * output: [[1,1], [2]]
 * 
 * Input: [1, 2, 3, 2], target = 5;
 * output: [[2, 3], [3, 2], [1, 2, 2]]
 */


import java.util.List;
import java.util.ArrayList;

public class Print_all_subsequences_with_sum_K {
    public static void findCombination(int idx, int[] arr, int target, List<List<Integer>> ans, ArrayList<Integer> ds){
        if(idx == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
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
        int[] arr = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(arr, target));
    }
}
