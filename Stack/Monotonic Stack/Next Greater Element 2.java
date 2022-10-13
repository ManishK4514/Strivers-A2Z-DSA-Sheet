/*
    Next Greater Element Using Stack
    Problem Statement: Given a circular integer array A, return the next greater element for every element in A. The next greater element for an element x is the first element greater than x that we come across while traversing the array in a clockwise manner. If it doesn’t exist, return -1 for this element.
    
    Examples:
    
    Example 1:     
    Input: N = 11, A[] = {3,10,4,2,1,2,6,1,7,2,9}    
    Output: 10,-1,6,6,2,6,7,7,9,9,10    
    Explanation: For the first element in A ,i.e, 3, the greater element which comes next to it while traversing and is closest to it is 10. Hence,10 is present on index 0 in the resultant array. Now for the second element,i.e, 10, there is no greater number and hence -1 is it’s next greater element (NGE). Similarly, we got the NGEs for all other elements present in A.  
    
    
    Example 2:    
    Input:  N = 6, A[] = {5,7,1,7,6,0}    
    Output: 7,-1,7,-1,7,5
*/

import java.util.Arrays;
import java.util.Stack;

public class Next_Greater_Element_II {
    public static int[] nextGreaterElements(int[] nums) {
        /*
           // BruteForce Approach: Time Complexity: O(N^2) & Space Complexity: O(1).
           int n = nums.length;
           int[] ans = new int[n];
           boolean flag = true;
           int k = 0;
           for(int i = 0; i < n; i++){
               int j = i;
               flag = true;
               while(j < (2 * n) - 1){
                   if(nums[j % n] > nums[i]){
                       flag = false;
                       ans[k++] = nums[j % n];
                       break;
                   }
                   j++;
               }
               if(flag){
                   ans[k++] = -1;
               }
           }
           return ans;
        */
        
        // Optimized Approach: Time Complexity: O(N) & Space Complexity: O(N).
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        for(int i = 2*n-1; i >= 0; i--){
            while(!stack.empty() && nums[i % n] >= stack.peek()){
                stack.pop();
            }
            
            if(i < n){
                if(!stack.empty()) ans[i] = stack.peek();
                else ans[i] = -1;
            }
            
            stack.push(nums[i%n]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int num[] = {1,2,1};
        System.out.println(Arrays.toString(nextGreaterElements(num)));
    }
}
