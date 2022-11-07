public class Check_if_a_number_is_odd_or_not {
    public static void checkOdd(int n){
        if(((n&1) == 1)){
            System.out.println("Odd");
        }
        else{
            System.out.println("Even");
        }
    }
    public static void main(String[] args) {
        int n = 23;
        checkOdd(n);
    }
}
