public class Capacity_To_Ship_Packages_Within_D_Days {
    public static int shipWithinDays(int[] weights, int days) {
        int max = 0, sum2 = 0;
        for(int i = 0; i < weights.length; i++){
            sum2 += weights[i];
            max = Math.max(max, weights[i]);
        }
        int start = max;
        int end = sum2;
        for(int i = start; i <= end; i++){
            int sum = 0;
            int day = 1;
            for(int j = 0; j < weights.length; j++){
                if(sum + weights[j] < i){
                    sum += weights[j];
                }
                else{
                    sum = weights[j];
                    day++;                    
                }
            }
            if(day <= days){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }
}
