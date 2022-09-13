/*
 * Median of Two Sorted Arrays of different sizes
   Problem Statement: Given two sorted arrays arr1 and arr2 of size m and n respectively, return the median of the two sorted arrays.
   
   Example 1:
   
   Input format: arr1 = [1,4,7,10,12], arr2 = [2,3,6,15]
   
   Output format : 6.00000
   
   Explanation:
   Merge both arrays. Final sorted array is [1,2,3,4,6,7,10,12,15]. We know that to find the median we find the mid element. Since, the size of the element is odd. By formula, the median will be at [(n+1)/2]th position of the final sorted array. Thus, for this example, the median is at [(9+1)/2]th position which is [5]th = 6.
   Example 2:
   
   Input: arr1 = [1], arr2 = [2]
   
   Output format:
    1.50000
   
   Explanation:
    
   Merge both arrays. Final sorted array is [1,2]. We know that to find the median we find the mid element. Since, the size of the element is even. By formula, the median will be the mean of elements at [n/2]th and  [(n/2)+1]th position of the final sorted array. Thus, for this example, the median is (1+2)/2 = 3/2 = 1.50000.
*/

// import java.util.Arrays;

public class Median_of_two_sorted_arrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2, int m, int n) {
        /*
         * BruteForce Approach: Time complexity: O(Nlog(m + n)) + Space complexity: O(m + n).
         * int[] finalArray = new int[nums1.length + nums2.length];
           int k = 0;
           for(int i = 0; i < nums1.length; i++){
               finalArray[k++] = nums1[i];
           }
           for(int i = 0; i < nums2.length; i++){
               finalArray[k++] = nums2[i];
           }
           Arrays.sort(finalArray);
           if(finalArray.length % 2 == 0){
               int mid1 = finalArray[finalArray.length/2];
               int mid2 = finalArray[(finalArray.length/2) - 1];
               return (double)(mid1 + mid2)/2;
           }
           else{
               return (double)(finalArray[(finalArray.length/2)]);
           }
        */

        /*
         * // Solution 2: Using mergeSort Approach.
         * // Time complexity: O(m + n) + Space complexity: O(m + n).
         * int[] finalArray = new int[m + n];
           int k = 0;
           int i = 0, j = 0;
           while(i < m && j < n){
               if(nums1[i] <= nums2[j]){
                   finalArray[k++] = nums1[i++];
               }
               else{
                   finalArray[k++] = nums2[j++];
               }
           }
           while(i < m){
               finalArray[k++] = nums1[i++];
           }
           while(j < n){
               finalArray[k++] = nums2[j++];
           }
           if(finalArray.length % 2 == 0){
               int mid1 = finalArray[finalArray.length/2];
               int mid2 = finalArray[(finalArray.length/2) - 1];
               return (double)(mid1 + mid2)/2;
           }
           else{
               return (double)(finalArray[(finalArray.length/2)]);
           }
        */
        /*
         * // Optimized Approach: Using Binary Search.
           // Time complexity: O(m+n) & Space complexity: O(1).
           int i = 0, j = 0, count = 0;
           int mid1 = 0, mid2 = 0;
           while(i < m && j < n){
               if(nums1[i] <= nums2[j]){
                   if(count == ((m + n)/2) - 1){
                       mid1 = nums1[i];
                   }
                   if(count == ((m + n)/2)){
                       mid2 = nums1[i];
                   }
                   count++; i++;
               }
               else{
                   if(count == ((m + n)/2) - 1){
                       mid1 = nums2[j];
                   }
                   if(count == ((m + n)/2)){
                       mid2 = nums2[j];
                   }
                   count++; j++;
               }
           }
           while(i < m){
               if(count == ((m + n)/2) - 1){
                   mid1 = nums1[i];
               }
               if(count == ((m + n)/2)){
                   mid2 = nums1[i];
               }
               count++; i++;
           }
           while(j < n){
               if(count == ((m + n)/2) - 1){
                   mid1 = nums2[j];
               }
               if(count == ((m + n)/2)){
                   mid2 = nums2[j];
               }
               count++; j++;
           }
           if((m + n) % 2 == 0){
               return (double)(mid1 + mid2)/2;
           }
           else{
               return (double)(mid2);
           }
        */

        // Optimized Approach: Using Binary Search.
        // Time complexity: O(log(min(m,n))) & Space complexity: O(1).
        
        if(n > m){
            return findMedianSortedArrays(nums2, nums1, n, m);
        }
        int k = (n + m)/2;
        int low = Math.max(0,k-n), high = Math.min(k,m);
        while(low <= high){
            int cut1 = low + (high - low)/2;
            int cut2 = k - cut1;

            // edge cases

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1]; 
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r1 = cut1 == m ? Integer.MAX_VALUE : nums1[cut1]; 
            int r2 = cut2 == n ? Integer.MAX_VALUE : nums2[cut2]; 
            
            if(l1 <= r2 && l2 <= r1){
                int mid = Integer.MAX_VALUE, mid1 = Integer.MIN_VALUE, mid2 = Integer.MAX_VALUE;
                if((m + n) % 2 == 0){
                    mid1 = Math.max(l1, l2);
                    mid2 = Math.min(r1, r2);
                    return (double)(mid1 + mid2)/2;
                }
                else{
                    mid = Math.min(r1, r2);
                    return (double)(mid);
                }
            }
            else if(l1 > r2){
                high = cut1 - 1;
            }
            else{
                low = cut1 + 1;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        int arr1[] = {1,4,7,10,12};
        int arr2[] = {2,3,6,15};
        int m = arr1.length;
        int n = arr2.length;
        System.out.print("The Median of two sorted array is ");
        System.out.println(findMedianSortedArrays(arr1, arr2, m, n));
    }
}
