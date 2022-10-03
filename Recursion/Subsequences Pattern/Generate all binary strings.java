/*
 * Q. Generate all the binary strings of N bits
 * Given a positive integer number N. The task is to generate all the binary strings of N bits. These binary strings should be in ascending order.
 * 
   Examples: 

   Input: 2
   Output:
   0 0
   0 1
   1 0
   1 1
   
   Input: 3
   Output:
   0 0 0
   0 0 1
   0 1 0
   0 1 1
   1 0 0
   1 0 1
   1 1 0
   1 1 1
*/

public class Generate_all_binary_strings {
    /*
     * if Consecutive 1's not allowed.
     * 
     *  long countStrings(int n) {
            // code here
            int zeroend = 1;
            int oneend = 1;
            int sum = zeroend + oneend;
            if(n == 1){
                return sum;
            }
            int i = 2;
            while(i <= n){
                oneend = zeroend % (1000000007);
                zeroend = sum % (1000000007);
                sum = zeroend + oneend % (1000000007);
                i++;
            }
            return sum % (1000000007);
        }
    */
    
    public static void print(int[] arr, int n){
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void generate(int[] arr, int n, int i){
        if(i == n){
            print(arr, n);
            return;
        }
        arr[i] = 0;
        generate(arr, n, i + 1);
        arr[i] = 1;
        generate(arr, n, i + 1);
    }
    public static void main(String[] args) {
        int n = 4;
        int[] arr = new int[4];
        generate(arr, n, 0);
    }
}
