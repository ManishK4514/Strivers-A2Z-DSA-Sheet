/*
 * Q. Write a program to print "Hello World" N times.
 * Q. Write a program to print "Name" N times.
 * Q. Write a program to print 1 to N.
 * Q. Write a program to print N to 1.
 */

public class Hello_World_N_Times {
    public static void printNTimes(int n){
        if(n == 0){
            return;
        }
        System.out.println("Hello World");
        // System.out.println("Manish kumar"); // to print name N times
        // System.out.println(n); // to print N to 1
        printNTimes(n - 1);
        // System.out.println(n); // to print 1 to N
    }
    public static void main(String[] args) {
        int n = 10;
        printNTimes(n);
    }
}
