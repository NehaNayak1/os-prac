import java.util.*;

public class PriorityScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int pid[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int pr[] = new int[n]; // priority
        int ct[] = new int[n];
        int tat[] = new int[n];
        int wt[] = new int[n];
        boolean completed[] = new boolean[n];

        // Input
        for (int i = 0; i < n; i++) {
            System.out.print("Enter AT, BT and Priority for P" + (i + 1) + ": ");
            pid[i] = i + 1;
            at[i] = sc.nextInt();
            bt[i] = sc.nextInt();
            pr[i] = sc.nextInt();
            completed[i] = false;
        }

        int time = 0, completedCount = 0;

        // Priority Scheduling Logic
        while (completedCount < n) {
            int minIndex = -1;
            int highestPriority = Integer.MAX_VALUE;

            // Find highest priority process (smallest value)
            for (int i = 0; i < n; i++) {
                if (at[i] <= time && !completed[i] && pr[i] < highestPriority) {
                    highestPriority = pr[i];
                    minIndex = i;
                }
            }

            // If no process is ready
            if (minIndex == -1) {
                time++;
            } else {
                ct[minIndex] = time + bt[minIndex];
                time = ct[minIndex];

                tat[minIndex] = ct[minIndex] - at[minIndex];
                wt[minIndex] = tat[minIndex] - bt[minIndex];

                completed[minIndex] = true;
                completedCount++;
            }
        }

        // Display Table
        System.out.println("\nPID\tAT\tBT\tPR\tCT\tTAT\tWT");
        for (int i = 0; i < n; i++) {
            System.out.println("P" + pid[i] + "\t" + at[i] + "\t" + bt[i] + "\t" +
                    pr[i] + "\t" + ct[i] + "\t" + tat[i] + "\t" + wt[i]);
        }

        // Gantt Chart (order of execution)
        System.out.println("\nGantt Chart:");

        // Sort by completion time
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ct[i] > ct[j]) {
                    int temp;

                    temp = ct[i]; ct[i] = ct[j]; ct[j] = temp;
                    temp = pid[i]; pid[i] = pid[j]; pid[j] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print("| P" + pid[i] + " ");
        }
        System.out.println("|");
    }
}