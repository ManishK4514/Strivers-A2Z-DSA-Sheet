/*
    Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

    Example 1:    
    Input: arr = [3,1,2,4]
    Output: 17
    Explanation: 
    Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
    Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
    Sum is 17.

    Example 2:    
    Input: arr = [11,81,94,43,3]
    Output: 444
*/


import java.util.ArrayDeque;;

class Pair{
    int element;
    int eleMin;
    Pair(int element, int eleMin){
        this.element = element;
        this.eleMin = eleMin;
    }
}


public class Sum_of_subarray_minimum {
    public static int m = (int)(Math.pow(10, 9) + 7);
    public static int sumSubarrayMins(int[] arr) {
        /*
            // BruteForce Approach: Time complexity: O(N^2) & Space Complexity: O(1)
            long sum = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < arr.length; i++){
                min = Integer.MAX_VALUE;
                for(int j = i; j < arr.length; j++){
                    min = Math.min(min, arr[j]);
                    sum += min;
                }
            }
            return (int)(sum % 1000000007);
        */
        
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];
        ArrayDeque<Pair> stack1 = new ArrayDeque<>();
        ArrayDeque<Pair> stack2 = new ArrayDeque<>();
        
        // filling our left array
        for(int i = 0; i < arr.length; i++){
            int count = 1;
            while(stack1.size() != 0 && stack1.peek().element > arr[i]){
                count+= stack1.peek().eleMin;
                stack1.pop();
            }
            stack1.push(new Pair(arr[i], count));
            left[i] = count;
        }
        
        // filling our right Array
        for(int i = arr.length - 1; i >= 0; i--){
            int count = 1;
            while(stack2.size() != 0 && stack2.peek().element >= arr[i]){
                count+= stack2.peek().eleMin;
                stack2.pop();
            }
            stack2.push(new Pair(arr[i], count));
            right[i] = count;
        }
        int ans = 0;
        for(int i = 0; i < arr.length; i++){
            ans = (ans + left[i] * right[i] * arr[i]) % m;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        System.out.println(sumSubarrayMins(arr));
    }
}
