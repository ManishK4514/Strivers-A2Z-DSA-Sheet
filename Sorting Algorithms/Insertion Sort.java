    ⊛ In Insertion sort array contains two part one is Sorted Part and another one is Unsorted part.
    ⊛ Initially, Sorted part will be of one index and during execution Sorted part will increase and unsorted part will decrease.
    ⊛ First we will store the CURRENT index into current variable and then we find the particular place then we will place current at that position.
    ⊛ Time Complexity: O(N^2)
      
// Write a program to sort an Array using Insertion sort.
      
public class InsertionSortProgram {
    public static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int current = arr[i];
            int j = i - 1;
            while(j >= 0 && current < arr[j]){
                arr[j + 1] = arr[j];
                j--;
            }
            //Placement
            arr[j + 1] = current;
        }
    }
    public static void main(String[] args) {
        int[] arr = {7, 8, 3, 2, 1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
