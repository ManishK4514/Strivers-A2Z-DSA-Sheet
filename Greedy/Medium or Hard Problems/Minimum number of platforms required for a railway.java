/*
   Minimum number of platforms required for a railway
   Problem Statement: We are given two arrays that represent the arrival and departure times of trains that stop at the platform. We need to find the minimum number of platforms needed at the railway station so that no train has to wait.
   
   Examples 1:
   
   Input: N=6, 
   arr[] = {9:00, 9:45, 9:55, 11:00, 15:00, 18:00} 
   dep[] = {9:20, 12:00, 11:30, 11:50, 19:00, 20:00}
   
   Output:3
   Explanation: There are at-most three trains at a time. The train at 11:00 arrived but the trains which had arrived at 9:45 and 9:55 have still not departed. So, we need at least three platforms here.
   
   
   Example 2:
   
   Input Format: N=2, 
   arr[]={10:20,12:00}
   dep[]={10:50,12:30}
   
   Output: 1
   Explanation: Before the arrival of the new train, the earlier train already departed. So, we don’t require multiple platforms.
*/


import java.util.Arrays;

public class Minimum_number_of_platforms_required_for_a_railway {
    public static int findPlatform(int arr[], int dep[])    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int  i = 1, j = 0;
        int platform_needed = 1, result = 1;
        while(i < arr.length && j < arr.length){
            if(arr[i] <= dep[j]){
                platform_needed++;
                i++;
            }
            else if(arr[i] > dep[j]){
                platform_needed--;
                j++;
            }
            
            result = Math.max(result, platform_needed);
        }
        return result;
    }
    public static void main(String[] args) {
        int arr[] = {Integer.parseInt("0900"), Integer.parseInt("0940"), Integer.parseInt("0950"), 1100, 1500, 1800},
        dep[] = {Integer.parseInt("0910"), 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arr, dep));
    }
}
