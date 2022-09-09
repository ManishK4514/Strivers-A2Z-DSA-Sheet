/*
 * K-th Element of two sorted arrays
   Problem Statement: Given two sorted arrays of size m and n respectively, you are tasked with finding the element that would be at the kth position of the final sorted array.
   
   Examples :
   
   Input: m = 5
          n = 4
          array1 = [2,3,6,7,9]
          array2 = [1,4,8,10]
          k = 5
   
   Output:
    6
   
   Explanation: Merging both arrays and sorted. Final array will be -
    [1,2,3,4,6,7,8,9,10]
   We can see at k = 5 in the final array has 6. 
   
   
   Input:
    m = 1
          n = 4
          array1 = [0]
          array2 = [1,4,8,10]
          k = 2
   
   Output:
    4
   
   Explanation:
    Merging both arrays and sorted. Final array will be -
    [1,4,8,10]
   We can see at k = 2 in the final array has 4
*/

// import java.util.Arrays;

public class Kth_element_of_two_sorted_Arrays {
    static int kthelement(int array1[], int array2[], int m, int n, int k) {
        /*
         * Bruteforce Approach: Time complexity: o(N) & Space complexity: O(m + n).
         * int[] nums = new int[m + n];
         * int j = 0;
         * for(int i = 0; i < n; i++){
         * nums[j++] = array1[i];
         * }
         * for(int i = 0; i < m; i++){
         * nums[j++] = array2[i];
         * }
         * Arrays.sort(nums);
         * return nums[k - 1];
         */
        
         /*
          * Solution 2: Time complex
          */
        int i = 0, j = 0;
        int count = 0;
        while (i < m && j < n) {
            if (array1[i] <= array2[j]) {
                count++;
                if (count == k) {
                    return array1[i];
                }
                i++;
            } else {
                count++;
                if (count == k) {
                    return array2[j];
                }
                j++;
            }

        }
        while (i < m) {
            count++;
            if (count == k) {
                return array1[i];
            }
            i++;
        }
        while (j < n) {
            count++;
            if (count == k) {
                return array2[j];
            }
            j++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int array1[] = { 2, 3, 6, 7, 9 };
        int array2[] = { 1, 4, 8, 10 };
        int m = array1.length;
        int n = array2.length;
        int k = 5;
        System.out.println("The element at the kth position in the final sorted array is "
                + kthelement(array1, array2, m, n, k));
    }
}
