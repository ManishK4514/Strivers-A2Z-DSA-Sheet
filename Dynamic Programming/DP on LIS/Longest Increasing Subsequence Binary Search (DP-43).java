/*
    Q. Longest Increasing Subsequence | Binary Search | (DP-43)

    Practice : https://leetcode.com/problems/longest-increasing-subsequence/description/

    Given an integer array nums, return the length of the longest strictly increasing 
    subsequence.
    
    Example 1:
    
    Input: nums = [10,9,2,5,3,7,101,18]
    Output: 4
    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
    Example 2:
    
    Input: nums = [0,1,0,3,2,3]
    Output: 4
    Example 3:
    
    Input: nums = [7,7,7,7,7,7,7]
    Output: 1
*/

import java.util.ArrayList;

public class Longest_Increasing_Subsequence_Binary_Search {
    public static int lowerBound(ArrayList<Integer> list, int target){
        int l = 0, h = list.size() - 1;
        while(l <= h){
            int mid = l + (h - l)/2;
            if(list.get(mid) >= target) h = mid - 1;
            else l = mid + 1;
        }
        return l;
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);

        for(int i = 1; i < n; i++){
            if(temp.get(temp.size() - 1) < nums[i]){
                temp.add(nums[i]);
            }
            else {
                int idx = lowerBound(temp, nums[i]);
                temp.set(idx, nums[i]);
            }
        }

        return temp.size();
    }
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
