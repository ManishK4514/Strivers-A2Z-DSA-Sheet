// import java.util.ArrayList;
import java.util.Arrays;
// import java.util.Map;
// import java.util.HashMap;
// import java.util.HashSet;

public class Find_the_two_numbers_appearing_odd_number_of_times {
    public static int[] twoOddNum(int nums[])
    {
        /* 
            // Solution 2: Time Complexity: O(N) & Space Complexity: O(N).
            int[] arr = new int[2];
            int j = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++){
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            for(Map.Entry<Integer, Integer> entry: map.entrySet()){
                if(entry.getValue() % 2 != 0){
                    arr[j++] = entry.getKey();
                }
            }
            return arr;
        */

        // Optimized Approach: Time Complexity: O(N) & Space Complexity: O(1);
        int xor = 0;
        for(int i = 0; i < nums.length; i++){
            xor ^= nums[i];
        }
        
        int cnt = 0;
        while(xor != 0){
            if((xor&1) == 1){
                break;
            }
            cnt++;
            xor = xor>>1;
        }

        int xor1 = 0, xor2 = 0;
        for(int i = 0; i < nums.length; i++){
            if((nums[i]&(1<<cnt)) != 0){
                xor1 ^= nums[i];
            }
            else{
                xor2 ^= nums[i];
            }
        }
        return new int[]{xor1, xor2};
    }
    public static void main(String[] args) {
        int[] nums = {34, 52, 45, 15, 23, 23, 22, 22, 34, 52, 15, 9, 34, 23, 22, 43, 9, 23, 23, 23, 23, 45, 9, 34, 22, 22, 22, 52, 34, 23, 34, 43, 23, 23, 34, 22, 22, 9, 52, 43, 27, 34};
        System.out.println(Arrays.toString(twoOddNum(nums)));
    }
}
