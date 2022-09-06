/*
 * Count Reverse Pairs
   Problem Statement: Given an array of numbers, you need to return the count of reverse pairs. Reverse Pairs are those pairs where i<j and arr[i]>2*arr[j].
   
   Examples:
   
   Example 1:
   Input: N = 5, array[] = {1,3,2,3,1)
   Output: 2 
   Explanation: The pairs are (3, 1) and (3, 1) as from both the pairs the condition arr[i] > 2*arr[j] is satisfied.
   
   Example 2:
   Input: N = 4, array[] = {3,2,1,4}
   Output: 1
   Explaination: There is only 1 pair  ( 3 , 1 ) that satisfy the condition arr[i] > 2*arr[j]
*/


import java.util.ArrayList;

public class Reverse_Pairs {
    public static int merge(int[] nums, int low, int mid, int high) {
        int cnt = 0;
        int j = mid + 1; 
        for(int i = low;i<=mid;i++) {
            while(j<=high && nums[i] > (2 * (long) nums[j])) {
                j++;
            }
            cnt += (j - (mid+1));
        }
        
        ArrayList<Integer> temp = new ArrayList<>(); 
        int left = low, right = mid+1; 
        while(left <= mid && right<=high) {
            if(nums[left]<=nums[right]) {
                temp.add(nums[left++]); 
            }
            else {
                temp.add(nums[right++]); 
            }
        }
        
        while(left<=mid) {
            temp.add(nums[left++]); 
        }
        while(right<=high) {
            temp.add(nums[right++]); 
        }
        
        for(int i = low; i<=high;i++) {
            nums[i] = temp.get(i - low); 
        }
        return cnt; 
    }
    public static int mergeSort(int[] nums, int low, int high) {
        if(low>=high) return 0; 
        int mid = (low + high) / 2;
        int inv = mergeSort(nums, low, mid); 
        inv += mergeSort(nums, mid+1, high); 
        inv += merge(nums, low, mid, high); 
        return inv; 
    }
    static int reversePairs(int arr[]) {
        /*
         * // BruteForce Approach: Time complexity: O(N^2) & Space complexity: O(1).
         * int Pairs = 0;
           for (int i = 0; i < arr.length; i++) {
               for (int j = i + 1; j < arr.length; j++) {
                   if (arr[i] > 2 * arr[j]){
                       Pairs++;
                   }
               }
           }
           return Pairs;
        */

        // solution 2: Optimized -> Time compelxity: O( N log N ) + O (N) + O (N) & Space compelxity: O(N).
        return mergeSort(arr, 0, arr.length - 1); 
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 3, 1 };
        System.out.println("The Total Reverse Pairs are " + reversePairs(arr));
    }
}
