/*
   N meetings in one room
   Problem Statement: There is one meeting room in a firm. You are given two arrays, start and end each of size N.For an index ‘i’, start[i] denotes the starting time of the ith meeting while end[i]  will denote the ending time of the ith meeting. Find the maximum number of meetings that can be accommodated if only one meeting can happen in the room at a  particular time. Print the order in which these meetings will be performed.
   
   Example:
   
   Input:  N = 6,  start[] = {1,3,0,5,8,5}, end[] =  {2,4,5,7,9,9}
   
   Output: 1 2 4 5
   
   */


import java.util.*;

class Pair{
    int s;
    int e;
    Pair(int s, int e){
        this.s = s;
        this.e = e;
    }
}

class ItemComparator implements Comparator<Pair>{
    @Override
    public int compare(Pair a, Pair b){
        if(a.e < b.e) return -1;
        else if(a.e > b.e) return 1;
        else return 0;
    }
}

public class N_meetings_in_one_room {
    public static int maxMeetings(int start[], int end[], int n)
    {
        Pair[] arr = new Pair[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = new Pair(start[i], end[i]);
        }
        Arrays.sort(arr, new ItemComparator());
        int ans = 1;
        int temp = arr[0].e;
        for(int i = 1; i < arr.length; i++){
            if(arr[i].s > temp){
                ans++;
                temp = arr[i].e;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5}, end =  {2,4,6,7,9,9};
        int n = start.length;
        System.out.println(maxMeetings(start, end, n));
    }
}
