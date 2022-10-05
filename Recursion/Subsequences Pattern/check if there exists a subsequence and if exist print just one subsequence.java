/*
   Q. Write a program to Print check if there exists a subsequence and if exist print just one subsequence.
   
 * Input: [1, 2, 1], Target = 2;
 * output: [[1,1]]
 * 
 * Input: [1, 2, 3, 2], target = 5;
 * output: [[2, 3]]
 */


import java.util.List;
import java.util.ArrayList;

public class Check_if_there_exists_a_subsequence_with_sum_K {
    public static boolean findCombination(int idx, int[] arr, int target, List<List<Integer>> ans, ArrayList<Integer> ds){
        if(idx == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
                return true;
            }
            else return false;
        }
        // will take
        ds.add(arr[idx]);
        if(findCombination(idx + 1, arr, target - arr[idx], ans, ds) == true){
            return true;
        }
        ds.remove(ds.size() - 1);

        // will not take
        if(findCombination(idx + 1, arr, target, ans, ds) == true) return true;

        return false;
    }
    public static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0, arr, target, ans, new ArrayList<>());
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int target = 2;
        System.out.println(combinationSum(arr, target));
    }
}
