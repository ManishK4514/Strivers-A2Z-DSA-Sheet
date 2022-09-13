public class Capacity_To_Ship_Packages_Within_D_Days {
    public static int shipWithinDays(int[] weights, int days) {
        /*
         * BruteForce Approach: Time complexity: O(N * (sumOfAllElements - max))
         * int max = 0, sum2 = 0;
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
                   if(sum + weights[j] <= i){
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
        */
        int max = 0, sum2 = 0;
        for(int i = 0; i < weights.length; i++){
            sum2 += weights[i];
            max = Math.max(max, weights[i]);
        }
        int ans = 0;
        int start = max;
        int end = sum2;
        while(start <= end){
            int mid = start + (end - start)/2;
            int sum = 0;
            int day = 1;
            for(int i = 0; i < weights.length; i++){
                if(sum <= mid){
                    sum += weights[i];
                }
                else{
                    sum = weights[i];
                    day++;
                }
            }
            if(day <= days){
                ans = mid;
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }
}
