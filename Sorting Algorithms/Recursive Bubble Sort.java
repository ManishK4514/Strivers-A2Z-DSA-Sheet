➤ Recursive Bubble Sort:
    
    ⊛ first we start a loop and send the largest element to the end of the array by comparing adjacent element.
    ⊛ And then we recursive call for (N - 1), and if n == 0 then it will terminate.
    ⊛ Time Complexity: O(N^2).
      
Q. This is the Depth representation of the Recursion using Bubble Sort.

public class BubbleSortUsingDepthOfRecursion {
    // This method is used to print the Array.
    public static void print(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
  
    // This is the inner recursion of the bubble sort. i.e. Recursion inside Recursion
    public static void bubbleSortDepth(int[] arr, int i, int j){
        if(j == arr.length - i - 1){
            return;
        }
        if(arr[j] > arr[j + 1]){
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
        }
        bubbleSortDepth(arr, i, j + 1);
    }
  
    // This is the outer Recursion of Bubble Sort
    public static void bubbleSort(int[] arr, int i, int j){
        if(i == arr.length - 1){
            return;
        }
        bubbleSortDepth(arr, i, j);
        bubbleSort(arr, i + 1, 0);
    }
  
    // Main Method
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 1, 8, 2, 4};
        bubbleSort(arr, 0, 0);
        print(arr);
    }
}
