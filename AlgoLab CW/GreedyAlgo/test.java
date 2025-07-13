package GreedyAlgo;
import java.util.*;

class Pair {
    int deadline;
    int profit;
    Pair(int deadline, int profit) {
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class test {
    public static void jobsequencing(Pair p[], int n) {
        Arrays.sort(p, (a, b) -> b.profit - a.profit);
        int total_profit = 0;
        int time_slot[] = new int[n];
        ArrayList<Pair> jobs = new ArrayList<>();
        Arrays.fill(time_slot, 0);
        for(int i=0; i<n; i++) {
            int start = Math.min(n, p[i].deadline) - 1;
            while(start >= 0) {
                if(time_slot[start] == 0) {
                    time_slot[start] = 1;
                    total_profit += p[i].profit;
                    jobs.add(p[i]);
                    break;
                }
                start--;
            }
        }
        System.out.println(total_profit);
        for(Pair job : jobs) {
            System.out.println("Deadline: " + job.deadline + ", Profit: " + job.profit);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] p = new Pair[n];
        for(int i = 0; i < n; i++) {
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            p[i] = new Pair(deadline, profit);
        }
        jobsequencing(p, n);
        sc.close();
    }
}