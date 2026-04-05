import java.util.*;
public class FIFO{
    public static void main(String args[]){

        int pages[]={7,0,1,2,0,3,0,4,2,3,0,3,2};
        int frame=3;
        ArrayList<Integer> l=new ArrayList<>();

        int fault=0,hit=0;
        for(int i=0;i<pages.length;i++){
           int page=pages[i];
            //if fault
            if(!l.contains(page)){
                fault++;

                if(l.size()==frame){
                    l.remove(0);//remove least recently used
                }
                l.add(page);
            }

            //else hit
            else{
                hit++;
                l.remove((Integer)page);
                l.add(page);
            }
            System.out.println("step"+(i+1)+":"+l);
        }

         System.out.println("hit :"+hit);
          System.out.println("fault:"+fault);
           System.out.println("hit ratio:"+(float)hit/pages.length);



    }
}