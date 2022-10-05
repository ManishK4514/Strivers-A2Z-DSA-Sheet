// Write a program to print all the SubSequences with sum k.
/*
   Q. Write a program to count all the Subsequences with sum k.

 * Input: [1, 2, 1], Target = 2;
 * output: ([[1,1], [2]]) = 2
 * 
 * Input: [1, 2, 3, 2], target = 5;
 * output: ([[1, 2, 2], [2, 3], [3, 2]]) = 3
 */

public class Count_all_subsequences_with_sum_K {
    public static int findCombination(int idx, int[] arr, int target){
        // Condition not satisfied
        // strictly done if array contains only posivtive integer
        if(target < 0){
            return 0;
        }
        if(idx == arr.length){
            if(target == 0){
                return 1;
            }
            return 0;
        }
        // will take
        int l = findCombination(idx + 1, arr, target - arr[idx]);

        // will not take
        int r = findCombination(idx + 1, arr, target);
        return l + r;
    }
    public static int combinationSum(int[] arr, int target) {
        return findCombination(0, arr, target);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1};
        int target = 2;
        System.out.println(combinationSum(arr, target));
    }
}
