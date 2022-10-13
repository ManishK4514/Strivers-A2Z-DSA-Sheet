/*
   Q. Next Greater Element.

   Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
   Example 1:

   Input: 
   N = 4, arr[] = [1 3 2 4]
   Output:
   3 4 4 -1
   Explanation:
   In the array, the next larger element 
   to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ? 
   since it doesn't exist, it is -1.
   Example 2:
   
   Input: 
   N = 5, arr[] [6 8 0 1 3]
   Output:
   8 -1 1 3 -1
   Explanation:
   In the array, the next larger element to 
   6 is 8, for 8 there is no larger elements 
   hence it is -1, for 0 it is 1 , for 1 it 
   is 3 and then for 3 there is no larger 
   element on right and hence -1.
*/


import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;

public class Next_Greater_Element_for_Single_Array {
    public static long[] nextLargerElement(long[] arr)
    {
        Stack<Long> stack = new Stack<>();
        long[] ans = new long[arr.length];
        for(int i = arr.length - 1; i >= 0; i--){
            while(!stack.empty() && arr[i] >= stack.peek()){
                stack.pop();
            }
            if(stack.empty()){
                ans[i] = -1;
            }
            else{
                ans[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        long arr[] = new long[4];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < arr.length; i++){
            int b = sc.nextInt();
            arr[i] = Long.parseLong(Integer.toString(b));
        }
        sc.close();
        System.out.println(Arrays.toString(nextLargerElement(arr)));

    }
}
