/*
   Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

   Only numbers 1 through 9 are used.
   Each number is used at most once.
   Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
   
   Example 1:   
   Input: k = 3, n = 7
   Output: [[1,2,4]]
   Explanation:
   1 + 2 + 4 = 7
   There are no other valid combinations.

   Example 2:   
   Input: k = 3, n = 9
   Output: [[1,2,6],[1,3,5],[2,3,4]]
   Explanation:
   1 + 2 + 6 = 9
   1 + 3 + 5 = 9
   2 + 3 + 4 = 9
   There are no other valid combinations.

   Example 3:   
   Input: k = 4, n = 1
   Output: []
   Explanation: There are no valid combinations.
   Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
*/


import java.util.List;
import java.util.ArrayList;

public class Combination_Sum_III {
    public static void findCombination(int idx, int[] arr, int target, List<List<Integer>> ans, ArrayList<Integer> ds, int k){
        if(ds.size() > k){
            return;
        }
        if(idx == arr.length){
            if(target == 0){
                if(ds.size() == k){
                    ans.add(new ArrayList<>(ds));
                }
            }
            return;
        }
        // will take
        ds.add(arr[idx]);
        findCombination(idx + 1, arr, target - arr[idx], ans, ds, k);
        ds.remove(ds.size() - 1);

        // will not take
        findCombination(idx + 1, arr, target, ans, ds, k);
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = new int[10];
        int count = 1;
        for(int i = 0; i <= 9; i++){
            arr[i] = count;
            count++;
        }
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0, arr, n, ans, new ArrayList<>(), k);
        return ans;
    }
    public static void main(String[] args) {
        int k = 3, n = 7;
        System.out.println(combinationSum3(k, n));
    }
}
