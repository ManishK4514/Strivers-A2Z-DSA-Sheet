/*  
    Given an integer array Arr of size N. For each element in the array, check whether the right adjacent element (on the next immediate position) of the array is smaller. If next element is smaller, update the current index to that element. If not, then  -1.

    Example 1:

    Input:
    N = 5
    Arr[] = {4, 2, 1, 5, 3}
    
    Output:
    2 1 -1 3 -1
    Explanation: Array elements are 4, 2, 1, 5
    3. Next to 4 is 2 which is smaller, so we
    print 2. Next of 2 is 1 which is smaller,
    so we print 1. Next of 1 is 5 which is
    greater, so we print -1. Next of 5 is 3
    which is smaller, so we print 3.  Note
    that for last element, output is always 
    going to be -1 because there is no element
    on right.

*/

import java.util.Arrays;
import java.util.Stack;

public class Next_Smaller_Element {
    public static void immediateSmaller(int arr[], int n) {
        /*
            // Using Iteration: Time Complexity: O(N) & Space Complexity: O(1).
            for(int i = 0; i < n; i++){
                if(i < n - 1 && arr[i] > arr[i + 1]){
                    arr[i] = arr[i +  1];
                }
                else{
                    arr[i] = -1;
                }
            }
            arr[n - 1] = -1;
        */

        // Using Stack: Time Complexity: O(N) & Space Complexity: O(N).

        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            if(stack.empty()){
                stack.push(arr[i]);
                arr[i] = -1;
            }
            else if(!stack.empty() && stack.peek() < arr[i]){
                int temp = stack.peek();
                stack.push(arr[i]);
                arr[i] = temp;
            }
            else{
                stack.push(arr[i]);
                arr[i] = -1;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {4, 2, 1, 5, 3};
        immediateSmaller(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
