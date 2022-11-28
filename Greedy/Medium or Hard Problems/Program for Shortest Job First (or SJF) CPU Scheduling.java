import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Process implements Comparable<Process>{
    int id, arrival, burst;
    Process(int x, int y, int z){
        this.id = x;
        this.arrival = y;
        this.burst = z; 
    }
    public int compareTo(Process o){
        return this.burst - o.burst;
    }
}

class ProcessComparator implements Comparator<Process>{
    @Override
    public int compare(Process a, Process b){
        if(a.arrival > b.arrival) return 1;
        else if(a.arrival < b.arrival) return -1;
        else if(a.arrival == b.arrival){
            if(a.burst > b.burst) return 1;
            else if(a.burst < b.burst) return -1;
            else if(a.burst == b.burst){
                if(a.id > b.id) return 1;
                else return -1;
            }
        }
        return 0;
    }
}

public class Shortest_Job_First_CPU_Scheduling {
    public static ArrayList<Integer> ProcessScheduling(Process[] processes, int n){
        Arrays.sort(processes, new ProcessComparator());
        PriorityQueue<Process> pq = new PriorityQueue<>();
        ArrayList<Integer> res = new ArrayList<>();
        pq.add(processes[0]);
        int i = 1, current_time = 0;
        while(!pq.isEmpty()){
            int burst_time = pq.peek().burst;
            int id = pq.peek().id;
            pq.remove();
            res.add(id);
            current_time += burst_time;
            while(true){
                if(i < n && processes[i].arrival <= current_time){
                    pq.add(processes[i]);
                    i++;
                }
                else break;
            }
        }   
        return res;
    }
    public static void main(String[] args) {
        Process[] processes = {new Process(1,2,3), new Process(2,0,4),new Process(3, 4, 2), new Process(4, 5, 4)};
        System.out.println(ProcessScheduling(processes, 4));
    }
}
