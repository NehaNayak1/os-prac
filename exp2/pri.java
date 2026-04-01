import java.util.*;
public class pri{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter no of process");
        int n=sc.nextInt();

        
        int pid[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int pr[]= new int[n];
        int rt[] = new int[n]; 
        int ct[] = new int[n];
        int tat[] = new int[n];
        int wt[] = new int[n];

        for(int i=0;i<n;i++)
        {
            System.out.println("enter at and bt and pr of process"+(i+1)+":");
            pid[i]=i+1;
            at[i]=sc.nextInt();
            bt[i]=sc.nextInt();
            pr[i]=sc.nextInt();
            rt[i]=bt[i];
        }

        int time=0,completed=0;

        while(completed<n){
            int minindex=-1;
            int highpriority=Integer.MAX_VALUE;

            for(int i=0;i<n;i++)
            {
                if(at[i]<=time && rt[i]>0 && pr[i]<highpriority)
                {
                    highpriority=pr[i];
                    minindex=i;
                }
            }

            if(minindex==-1)
            {   
                time++;
            }
            else
            {   
                rt[minindex]--;
                time++;

                if(rt[minindex]==0)
                {
                    ct[minindex]=time;
                    completed++;
                    tat[minindex]=ct[minindex]-at[minindex];
                    wt[minindex]=tat[minindex]-bt[minindex];
                }
                
                
            
            }
        }


        System.out.println("pid\tat\tbt\tpr\tct\ttat\twt");
        for(int i=0;i<n;i++)
        {
            System.out.println("p"+pid[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+pr[i]+"\t"+ct[i]+"\t"+tat[i]+"\t"+wt[i]);
        }   
        





    }
}