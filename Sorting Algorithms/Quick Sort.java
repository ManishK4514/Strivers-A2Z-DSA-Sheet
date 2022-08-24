➤ Quick Sort:
    
    ⊛ In Quick Sort, First we choose pivot element and swaps element such a way that all the smaller elements comes before pivot and greater elements after pivot.
    ⊛ At every recursive call We divide the array into two subArrays According to the pivot element.
    ⊛ Time Complexity: O(NlogN).


// Write a program to Sort an Array using Quick Sort.

public class QuickSortAlgorithms {
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;
        while(i < j){
            while(arr[i] <= pivot && i <= high - 1){
                i++;
            }
            while(arr[j] > pivot && j >= low){
                j--;
            }
            // Swapping ith index and jth index.
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swapping high with the pivot element.
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        
        return j;
    }
    public static void quicksort(int[] arr, int low, int high){
        if(low < high){
            int pivot = partition(arr, low, high);
            quicksort(arr, low, pivot - 1);
            quicksort(arr, pivot + 1, high);
        }
    }
    public static void main(String[] args) {
        int n = 8;
        int arr[] = { 4, 6, 2, 5, 7, 8, 1, 3 };
        System.out.println("Before Quick Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        quicksort(arr, 0, n - 1);
        System.out.println("After Quick Sort: ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
