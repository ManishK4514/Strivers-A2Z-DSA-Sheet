/*
 * Allocate Minimum Number of Pages
   Problem Statement: Given an array of integers A of size N and an integer B.
   
   The College library has N bags, the ith book has A[i] number of pages.
   
   You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.
   
   Conditions given :
   
   A book will be allocated to exactly one student.
   
   Each student has to be allocated at least one book.
   
   Allotment should be in contiguous order, for example, A student cannot be allocated book 1 and book 3, skipping book 2.
   
   Calculate and return the minimum possible number. Return -1 if a valid assignment is not possible.
   Examples:

   Example 1:
   
   Input: A = [12, 34, 67, 90]
          B = 2
   Output: 113   
   Explaination: Let’s see all possible cases of how books can be allocated for each student.
   So, the maximum number of pages allocated in each case is [191,157,113]. So, the minimum number among them is 113. Hence, our result is 113.
*/


public class Allocate_minimum_number_of_pages {
    public static boolean check(int[] arr, int students, int mid){
        if(arr.length < students){
            return false;
        }
        int allocatedStudents = 1;
        int pages = 0;
        for (int j = 0; j < arr.length; j++) {
          if (pages + arr[j] > mid) {
            allocatedStudents++;
            pages = arr[j];
            if (pages > mid) return false;
          } else {
            pages += arr[j];
          }
        }
        if (allocatedStudents <= students) return true;
        return false;
    }
    public static int findPages(int[]arr,int N,int students)
    {
        /*
         * BruteForce Approach: Time complexity: O(N^2 & Space complexiyt: O(1)).
         * int sum = 0;
           for(int i = 0; i < arr.length; i++){
               sum += arr[i];
           }
           int start = arr[0];
           int end = sum;
           for(int i = start; i <= end; i++){
               boolean possible = check(arr, students, i);
               if(possible){
                   return i;
               }
           }
           return -1;
        */
        
        // Optimized Approach: Using Binary Search -> Time complexity: O(N*logN) & Space complexity: O(1).
        
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        int start = arr[0];
        int end = sum;
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            boolean possible = check(arr, students, mid);
            if(possible){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int students = 2;
        System.out.println("Minimum Possible Number is " + findPages(arr, arr.length, students));
    }
}
