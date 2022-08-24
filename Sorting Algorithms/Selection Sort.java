    ⊛ It sorts N elements by placing the Smallest element at the Starting according to the order in each iteration.
    ⊛ Starting with two pointer, both goes till N and Second pointer increase every time to find smallest.
    ⊛ And at the end of first iteration we will swap smallest element with arr[i].
    ⊛ Time Complexity: O(N^2)
// Write a program to sort an array using Selection sort

public class SelectionSort {
    public static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int smallest = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[smallest] > arr[j]){
                    smallest = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
    }
    public static void main(String[] args) {
        int[] nums = {64, 25, 12, 22, 11};
        selectionSort(nums);
        
        // printing Array after Soring
        for(int values: nums){
            System.out.print(values + " ");
        }
    }
}
