    ⊛ In Merge sort, an Array divided into multiple subArrays till the single element array and then they are combining in sorted order.
    ⊛ After Combining all elments array are in sorted form.
    ⊛ At every recursive call We divide the array into two subArrays.
    ⊛ Then merging two the array at every recursion call according to the order.
    ⊛ Time Complexity: O(NlogN) & Space Complexity: O(N)    

// Write a program to sort an Array using merge sort.
      
import java.util.Arrays;

public class MergeSortAlogrithms {
    public static void merge(int[] arr, int start, int end){
        // Calculating mid element
        int mid = start + (end - start)/2;

        // creating a temp Array
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        while(j <= end){
            temp[k++] = arr[j++];
        }

        // Copying all Elements of temp into Original Array.
        for(int m = 0, n = start; m < temp.length; m++, n++){
            arr[n] = temp[m];
        }
    }

    public static void mergeSort(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int mid = start + (end - start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, end);
    }

    public static void main(String[] args) {
        int arr[] = { 41, 1, 32, 95, 7 };
        mergeSort(arr, 0, arr.length - 1);

        // Printing the array
        System.out.println(Arrays.toString(arr));
    }
}
