public class Check_if_the_ith_bit_is_set_or_not {
    public static void checkSetBits(int n, int i){
        if((n&(1<<i)) != 0){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
    public static void main(String[] args) {
        int n = 24;
        int i = 3;
        checkSetBits(n, i);
    }
}
