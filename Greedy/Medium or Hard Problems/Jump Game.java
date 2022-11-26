/*
   55. Jump Game
   You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
   
   Return true if you can reach the last index, or false otherwise.
   
   Example 1:
   
   Input: nums = [2,3,1,1,4]
   Output: true
   Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
   Example 2:
   
   Input: nums = [3,2,1,0,4]
   Output: false
   Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
*/


public class Jump_Game {
    public static boolean canJump(int[] nums) {
        /*
            // Solution 1:
            if(nums.length == 1) return true;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 0){
                    int j = i;
                    boolean flag = true;
                    while(j >= 0){
                        if(nums[j] + j > i || (i == nums.length - 1)){
                            flag = false;
                        }
                        j--;
                    }
                    if(flag){
                        return false;
                    }
                }
            }
            return true;
        */

        /*
            // Solution 2:
            if(nums.length == 1) return true;
            Stack<Pair> st = new Stack<>();
            for(int i = 0; i < nums.length; i++){            
                if(nums[i] != 0) {
                    st.push(new Pair(i, nums[i]));
                }
                else{
                    boolean flag = true;
                    while(!st.empty()){
                        if(st.peek().index + st.peek().val > i || (i == nums.length - 1)){
                            flag = false;
                            break;
                        }
                        st.pop();
                    }
                    if(flag){
                        return false;
                    }
                }
            }
            return true;
        */

        // Solution 3:
        int index = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] + i >= index){
                index = i;
            }
        }
        if(index == 0) return true;
        else return false;        
    }
    public static void main(String[] args) {
        int[] num = {2,3,1,1,4};
        System.out.println(canJump(num));
    }
}
