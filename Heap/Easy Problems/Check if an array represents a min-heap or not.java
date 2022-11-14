/*
 * Given an array A of size N, the task is to check if the given array represents a Binary MIN Heap.

   Example 1:
   
   Input:  arr[] = {2, 7, 10, 12, 15, 11, 14}
   Output: True
   The given array represents below tree
           2
        /    \
       7      10
     /  \     / \
   12    15  11  14
   The tree follows max-heap property as every
   node is less than all of its descendants.
 */


public class Check_if_an_array_represents_a_min_heap_or_not {
    public static boolean countSub(long arr[])
    {
        for(int i = 0; i < arr.length; i++){
            if((2 * i + 1) < arr.length){
                if(arr[2 * i + 1] < arr[i]){
                    return false;
                }
            }
            if((2 * i + 2) < arr.length){
                if(arr[2 * i + 2] < arr[i]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        long arr[] = {2, 7, 10, 12, 15, 11, 14};
        System.out.println(countSub(arr));
    }
}
