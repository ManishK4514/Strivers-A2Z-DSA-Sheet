import java.util.HashMap;

/*
 * Count the number of subarrays with given xor K
   Problem Statement: Given an array of integers A and an integer B. Find the total number of subarrays having bitwise XOR of all elements equal to B.
   
   Examples:
   
   Input Format:  A = [4, 2, 2, 6, 4] , B = 6
   Result: 4
   Explanation: The subarrays having XOR of their elements as 6 are  [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]
   
   Input Format: A = [5, 6, 7, 8, 9], B = 5
   Result: 2
   Explanation:The subarrays having XOR of their elements as 2 are [5] and [5, 6, 7, 8, 9]
*/


public class Count_number_of_subarrays_with_given_xorK {
    public static int subsetXOR(int arr[], int k) {  
        /* 
            BruteForce Appraoch: Time complexity: O(N^N) & Space complexity: O(1)
            int count = 0;
            for(int i = 0; i < arr.length; i++){
                int currXor = 0;
                for(int j = i; j < arr.length; j++){
                    currXor ^= arr[j];
                    if(currXor == k){
                        count++;
                    }
                }
            }
            return count;
        */  
        // Optimized Solution: Time complexity: O() 
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int xorr = 0;
        for(int i = 0; i < arr.length; i++){
            xorr = xorr ^ arr[i];
            if(map.get(xorr ^ k) != null){
                count += map.get(xorr ^ k);
            }
            if(xorr == k){
                count++;
            }
            if(map.get(xorr) != null){
                map.put(xorr, map.get(xorr) + 1);
            }
            else{
                map.put(xorr, 1);
            }
        }   
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {4, 94, 39, 36, 88, 87, 39, 67, 11, 6};
        int k = 15;
        System.out.println(subsetXOR(nums, k));
    }
}
