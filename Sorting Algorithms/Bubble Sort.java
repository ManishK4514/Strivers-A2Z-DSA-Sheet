   ⊛ It sorts N elements by placing the biggest element at the end in each iteration.
   ⊛ Starting with two pointer, Initial value of both are 0.
   ⊛ In each iteration we have to compare next two element that why arr[j] > arr[j + 1].
   ⊛ Second pointer goes till (arr.length - i - 1) because in each iteration, we will get our largest index at the end.
   ⊛ Time Complexity: O(N^2).
     
/* Write a program to Sort an array by using bubble sort */

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {3, 2, 4, 1, 5};
        bubbleSort(nums);
        
        // printing Array after Soring
        for(int values: nums){
            System.out.print(values + " ");
        }
    }
}     
     
