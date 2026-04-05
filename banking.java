import java.util.*;

public class banking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p, r;

        System.out.println("Enter no of processes:");
        p = sc.nextInt();

        System.out.println("Enter no of resources:");
        r = sc.nextInt();

        int alloc[][] = new int[p][r];
        int max[][] = new int[p][r];
        int need[][] = new int[p][r];
        int available[] = new int[r];

        System.out.println("Enter allocation matrix:");
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {
                alloc[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter max matrix:");
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {
                max[i][j] = sc.nextInt();
            }
        }

        // Calculate need matrix
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {
                need[i][j] = max[i][j] - alloc[i][j];
            }
        }

        System.out.println("Enter available resources:");
        for (int j = 0; j < r; j++) {
            available[j] = sc.nextInt();
        }

        boolean finish[] = new boolean[p];
        int safeseq[] = new int[p];
        int count = 0;

        while (count < p) {
            boolean found = false;

            for (int i = 0; i < p; i++) {
                if (!finish[i]) {

                    boolean canExecute = true;

                    for (int j = 0; j < r; j++) {
                        if (need[i][j] > available[j]) {
                            canExecute = false;
                            break;
                        }
                    }

                    if (canExecute) {
                        for (int j = 0; j < r; j++) {
                            available[j] += alloc[i][j];
                        }

                        safeseq[count++] = i;
                        finish[i] = true;
                        found = true;
                    }
                }
            }

            if (!found) {
                System.out.println("System is NOT in safe state");
                return;
            }
        }

        System.out.println("System is in safe state");
        System.out.print("Safe sequence: ");

        for (int i = 0; i < p; i++) {
            System.out.print("P" + safeseq[i]);
            if (i != p - 1)
                System.out.print(" -> ");
        }
    }
}