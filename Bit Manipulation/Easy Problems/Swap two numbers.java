public class Swap_two_numbers {
    public static void swap(int a, int b){
        System.out.println("a: " + a + " " + "b: " + b);
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println("a: " + a + " " + "b: " + b);
    }
    public static void main(String[] args) {
        int a = 5, b = 7;
        swap(a, b);
    }
}
