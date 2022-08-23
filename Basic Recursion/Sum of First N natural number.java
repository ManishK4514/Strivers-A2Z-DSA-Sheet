// Q. Write a program to print sum of First N natuaral number.

public class Sum_of_First_N_number {
    public static int sum(int n){
        if(n == 0){
            return 0;
        }
        int sum = n + sum(n - 1);
        return sum;
    }
    public static void main(String[] args) {
        int n = 10;
        int sum = sum(n);
        System.out.println(sum);
    }
}
