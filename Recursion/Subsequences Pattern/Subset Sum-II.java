/*
    Subset – II | Print all the Unique Subsets
    Problem Statement: Given an array of integers that may contain duplicates the task is to return all possible subsets. Return only unique subsets and they can be in any order.
    
    Examples:
    
    Example 1:    
    Input: array[] = [1,2,2]    
    Output: [ [ ],[1],[1,2],[1,2,2],[2],[2,2] ]    
    Explanation: We can have subsets ranging from  length 0 to 3. which are listed above. Also the subset [1,2] appears twice but is printed only once as we require only unique subsets.
    
    Input: array[] = [1]    
    Output: [ [ ], [1] ]    
    Explanation: Only two unique subsets are available
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Subset_Sum_II {
    public static void findUniqueSubset(int idx, int[] arr, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> ds){
        ans.add(new ArrayList<>(ds));
        for(int i = idx; i < arr.length; i++){
            if(i > idx && arr[i] == arr[i - 1]) continue;
            
            // pick
            ds.add(arr[i]);
            findUniqueSubset(i + 1, arr, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
    public static ArrayList<ArrayList<Integer>> subsetSum(int[] arr){
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        findUniqueSubset(0, arr, ans, new ArrayList<>());
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        System.out.println(subsetSum(arr));
    }
}
