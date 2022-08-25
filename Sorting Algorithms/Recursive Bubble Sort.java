➤ Recursive Bubble Sort:
    
    ⊛ first we start a loop and send the largest element to the end of the array by comparing adjacent element.
    ⊛ And then we recursive call for (N - 1), and if n == 0 then it will terminate.
    ⊛ Time Complexity: O(N^2).
      
public class RecursiveBubbleSort {
    public static void bubbleSort(int[] arr, int n){
        if(n == 0){
            return;
        }
        for(int i = 0; i < n; i++){
            if(arr[i] > arr[i + 1]){
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        bubbleSort(arr, n - 1);
    }
    public static void main(String[] args) {
        int n = 8;
        int arr[] = { 4, 6, 2, 5, 7, 8, 1, 3 };
        System.out.println("Before Quick Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        bubbleSort(arr, arr.length - 1);
        System.out.println("After Quick Sort: ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
      
