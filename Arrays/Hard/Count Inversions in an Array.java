/*
 * Count inversions in an array
   Problem Statement: Given an array of N integers, count the inversion of the array (using merge-sort).
   
   What is an inversion of an array? Definition: for all i & j < size of array, if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i].
   
   Example 1:
   
   Input Format: N = 5, array[] = {1,2,3,4,5}
   
   Result: 0
   
   Explanation: we have a sorted array and the sorted array 
   has 0 inversions as for i < j you will never find a pair 
   such that A[j] < A[i]. More clear example: 2 has index 1 
   and 5 has index 4 now 1 < 5 but 2 < 5 so this is not an 
   inversion.
*/


public class Count_inversions_in_an_array {
    static int merge(int arr[],int temp[],int left,int mid,int right)
    {
        int inv_count=0;
        int i = left;
        int j = mid;
        int k = left;
        while((i <= mid-1) && (j <= right)){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }
            else
            {
                temp[k++] = arr[j++];
                inv_count = inv_count + (mid - i);
            }
        }
    
        while(i <= mid - 1)
            temp[k++] = arr[i++];
    
        while(j <= right)
            temp[k++] = arr[j++];
    
        for(i = left ; i <= right ; i++)
            arr[i] = temp[i];
        
        return inv_count;
    }
    
    static int merge_Sort(int arr[],int temp[],int left,int right)
    {
        int mid,inv_count = 0;
        if(right >= left){
            return 0;
        }
        else{
            mid = (left + right)/2;
    
            inv_count += merge_Sort(arr,temp,left,mid);
            inv_count += merge_Sort(arr,temp,mid+1,right);
    
            inv_count += merge(arr,temp,left,mid+1,right);
            return inv_count;
        }        
    }

    // public static int countInversions(int[] arr){
    //     /*
    //      * //BruteForce Approach: Time complexity: O(N^2) & Space complexity: O(1).
    //      * int count = 0;
    //        for(int i = 0; i < arr.length; i++){
    //            for(int j = i + 1; j < arr.length; j++){
    //                if(arr[i] > arr[j]){
    //                    count++;
    //                }
    //            }
    //        }
    //        return count;
    //     */
        
    // }
    public static void main(String[] args) {
        int arr[]={5,3,2,1,4};
        int n=arr.length;
        int[] temp = new int[arr.length];
        int ans = merge_Sort(arr,temp,0,n-1);
        System.out.println(ans);

        // System.out.println(countInversions(arr));
    }
}
