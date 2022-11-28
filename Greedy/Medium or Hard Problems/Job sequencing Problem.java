/*
   Job Sequencing Problem
   Problem Statement: You are given a set of N jobs where each job comes with a deadline and profit. The profit can only be earned upon completing the job within its deadline. Find the number of jobs done and the maximum profit that can be obtained. Each job takes a single unit of time and only one job can be performed at a time.
   
   Examples
   
   Example 1:   
   Input: N = 4, Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}   
   Output: 2 60   
   Explanation: The 3rd job with a deadline 1 is performed during the first unit of time .The 1st job is performed during the second unit of time as its deadline is 4.
   Profit = 40 + 20 = 60
   
   Example 2:   
   Input: N = 5, Jobs = {(1,2,100),(2,1,19),(3,2,27),(4,1,25),(5,1,15)}   
   Output: 2 127
   
   Explanation: The  first and third job both having a deadline 2 give the highest profit. 
   Profit = 100 + 27 = 127
*/

import java.util.Arrays;
import java.util.Comparator;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class JobComparator implements Comparator<Job>{
    @Override
    public int compare(Job a, Job b){
        if(a.profit < b.profit) return 1;
        else if(a.profit > b.profit) return -1;
        else return 0;
    }
}
public class Job_sequencing_Problem {
    int[] JobScheduling(Job arr[], int n)    {
        Arrays.sort(arr, new JobComparator());
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i].deadline);
        }
        int[] mark = new int[max + 1];
        int sum = 0, count = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = arr[i].deadline; j > 0; j--){
                if(mark[j] == 0){
                    count++;
                    sum += arr[i].profit;
                    mark[j] = arr[i].id;
                    break;
                }
            }
        }
        return new int[] {count, sum};
    }
    public static void main(String[] args) {
        
    }
}
