import java.util.*;

public class SJF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int pid[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int ct[] = new int[n];
        int tat[] = new int[n];
        int wt[] = new int[n];
        boolean completed[] = new boolean[n];

        // Input
        for (int i = 0; i < n; i++) {
            System.out.print("Enter AT and BT for P" + (i + 1) + ": ");
            pid[i] = i + 1;
            at[i] = sc.nextInt();
            bt[i] = sc.nextInt();
            completed[i] = false;
        }

        int time = 0;
        int completedcount = 0;

        while (completedcount < n) {
            int minindex = -1;
            int minbt = Integer.MAX_VALUE;

            // 🔹 Step 1: Find shortest job
            for (int i = 0; i < n; i++) {
                if (at[i] <= time && !completed[i] && bt[i] < minbt) {
                    minbt = bt[i];
                    minindex = i;
                }
            }

            // 🔹 Step 2: Execute after loop
            if (minindex == -1) {
                time++; // CPU idle
            } else {
                ct[minindex] = time + bt[minindex];
                time = ct[minindex];

                tat[minindex] = ct[minindex] - at[minindex];
                wt[minindex] = tat[minindex] - bt[minindex];

                completed[minindex] = true;
                completedcount++;
            }
        }

        // Display Table
        System.out.println("\nPID\tAT\tBT\tCT\tTAT\tWT");
        for (int i = 0; i < n; i++) {
            System.out.println("P" + pid[i] + "\t" + at[i] + "\t" + bt[i] + "\t" +
                    ct[i] + "\t" + tat[i] + "\t" + wt[i]);
        }
    }
}