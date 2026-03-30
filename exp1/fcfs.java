import java.util.*;
public class fcfs
{
    public static void main(String[] args)
    {
        int n,i;

        Scanner sc=new Scanner(System.in);
        System.out.println("enter no of process");
        n=sc.nextInt();

        int pid[]=new int[n];
        int at[]=new int[n];
        int bt[]=new int[n];
        int ct[]=new int[n];
        int wt[]=new int[n];
        int tat[]=new int[n];

        for(i=0;i<n;i++)
        {
            System.out.println("enter at and bt  of process"+(i+1)+":");
            pid[i]=i+1;
            at[i]=sc.nextInt();
            bt[i]=sc.nextInt();
        }

        for(i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(at[i]>at[j])
                {   
                   int temp=at[i];
                   at[i]=at[j];
                   at[j]=temp;

                    // swap BT
                    temp = bt[i];
                    bt[i] = bt[j];
                    bt[j] = temp;

                    // swap PID
                    temp = pid[i];
                    pid[i] = pid[j];
                    pid[j] = temp;
                }
            }
        }

        ct[0]=at[0]+bt[0];
        for(i=1;i<n;i++)
        {
            if(ct[i-1]<at[i])
                ct[i]=at[i]+bt[i];
            else
                ct[i]=ct[i-1]+bt[i];    
        }

         // Calculate TAT and WT
        for (i = 0; i < n; i++) {
            tat[i] = ct[i] - at[i];
            wt[i] = tat[i] - bt[i];
        }

        //display
        System.out.println("pid\tat\tbt\tct\ttat\twt");
        for(i=0;i<n;i++)
        {
            System.out.println("p"+pid[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+tat[i]+"\t"+wt[i]);
        }

         // Gantt Chart
        System.out.println("\nGantt Chart:");

        for (int i = 0; i < n; i++) {
            System.out.print("| P" + pid[i] + " ");
        }
        System.out.println("|");

        // Time line
        System.out.print(at[0] + " ");
        for (int i = 0; i < n; i++) {
            System.out.print("   " + ct[i]);
        }

    








        

    }
}