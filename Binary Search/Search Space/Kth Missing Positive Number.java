


// import java.util.HashSet;

public class Kth_Missing_Positive_Number {
    public static boolean binarySearch(int[] nums, int target){
        // Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while(start <= end){
            mid = start + (end - start)/2;
            if(nums[mid] == target){
                return true;
            }
            else if(nums[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return false;
    }
    public static int findKthPositive(int[] arr, int k) {
        /*
         * BruteForce Appraoch: Using HashSet ->  Time coplexity: O(N) & Space complexity: O(N).
         * HashSet<Integer> set = new HashSet<>();
           for(int i = 0; i < arr.length; i++){
               set.add(arr[i]);
           }
           int count = 0;
           for(int i = 1; i <= 2000; i++){
               if(!set.contains(i)){
                   count++;
                   if(count == k){
                       return i;
                   }
               }
           }
           return -1;
        */
        
        /*
         * Solution 2: Time compelxity: O(N) & Space complexity: O(1).
         * int count = 0;
           for(int i = 1; i <= 2000; i++){
               boolean contains = binarySearch(arr, i);
               if(!contains){
                   count++;
                   if(count == k){
                       return i;
                   }
               }
           }
           return -1;
        */

        /*
         * Solution 3: Time compelxity: O(N) & Space complexity: O(1).
         * if(arr[0] > k){
               return k;
           }
           int num = k;
           for(int val: arr){
               if(val <= num){
                   num++;
               }
               else{
                   break;
               }
           }
           return num;
        */
        
        // Optimized Approach: using Binary Search -> Time complexity: O(logN) & Space complexity: O(1). 
        int start = 0;
        int end = arr.length - 1;
        int closestMid = 0;
        while(start <= end){
            int mid = start + (end - start)/2;
            if((arr[mid] - (mid + 1)) < k){
                closestMid = mid + 1;
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return k + closestMid;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(findKthPositive(arr, k));
    }
}
