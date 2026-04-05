import java.util.*;
public class FIFO{
    public static void main(String args[]){

        int pages[]={7,0,1,2,0,3,0,4,2,3,0,3,2};
        int frame=3;
        Queue<Integer> q=new LinkedList<>();

        int fault=0,hit=0;
        for(int i=0;i<pages.length;i++){
           int page=pages[i];
            //if fault
            if(!q.contains(page)){
                fault++;

                if(q.size()==frame){
                    q.poll();//remove oldest element
                }
                q.add(page);
            }

            //else hit
            else{
                hit++;
            }
            System.out.println("step"+(i+1)+":"+q);
        }

         System.out.println("hit :"+hit);
          System.out.println("fault:"+fault);
           System.out.println("hit ratio:"+(float)hit/pages.length);



    }
}