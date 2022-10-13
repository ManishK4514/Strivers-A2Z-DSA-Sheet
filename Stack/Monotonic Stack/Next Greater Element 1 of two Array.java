/*
    The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
    You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
    
    Example 1:
    
    Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
    Output: [-1,3,-1]
    Explanation: The next greater element for each value of nums1 is as follows:
    - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
    - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
    - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
    Example 2:
    
    Input: nums1 = [2,4], nums2 = [1,2,3,4]
    Output: [3,-1]
    Explanation: The next greater element for each value of nums1 is as follows:
    - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
    - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
*/


// import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.Arrays;

public class Next_Greater_Element_I {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        /* 
            // BruteForce Approach: Time Complexity: O(N^2)

            ArrayList<Integer> res = new ArrayList<>();
            int max = 0;
            int temp = 0;
            boolean flag = false;
            for(int i = 0; i < nums1.length; i++){
                for(int j = 0; j < nums2.length; j++){
                    if(nums1[i] == nums2[j]){
                        max = 0;
                        temp = j + 1;
                        flag = false;
                        while(temp < nums2.length){
                            if(nums2[temp] > nums2[j]){
                                flag = true;
                                res.add(nums2[temp]);
                                break;
                            }
                            temp++;
                        }
                        if(!flag){
                            res.add(-1);
                        }
                    }
                }
            }
            int[] ans = new int[res.size()];
            for(int i = 0; i < ans.length; i++){
                ans[i] = res.get(i);
            }
            return ans;
        */

        // Optimized Approach: Time Complexity: O(N) & Space complexity: O(N).

        HashMap<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num){
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }   
        for (int i = 0; i < nums1.length; i++){
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }    
        return nums1;
    }
    public static void main(String[] args) {
        int[] nums1 = {4,1,2}, nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
}
