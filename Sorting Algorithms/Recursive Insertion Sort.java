➤ Recursive Bubble Sort:
    
    ⊛ first we start a loop and find the current element at i = 1 and then by comparing elements we insert an element at particular position.
    ⊛ And then we recursive call for (N - 1) & (i + 1), and if n == 0 then it will terminate.
    ⊛ Time Complexity: O(N^2).
      
public class RecursiveInsertionSort {
    public static void insertionSort(int[] arr, int n, int i){
        if(n == 0){
            return;
        }
        int current = arr[i];
        int j = i - 1;
        while(j >= 0 && current < arr[j]){
            arr[j + 1] = arr[j];
            j--;
        }
        // placement
        arr[j + 1] = current;
        insertionSort(arr, n - 1, i + 1);
    }
    public static void main(String[] args) {
        int n = 8;
        int arr[] = { 4, 6, 2, 5, 7, 8, 1, 3 };
        System.out.println("Before Quick Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        insertionSort(arr, arr.length - 1, 1);
        System.out.println("After Quick Sort: ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
      
