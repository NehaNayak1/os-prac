import java.util.*;

public class FIFO {
    public static void main(String args[]) {

        int pages[] = {7,0,1,2,0,3,0,4,2,3,0,3,2};
        int frame = 3;

        ArrayList<Integer> l = new ArrayList<>();

        int fault = 0, hit = 0;

        for(int i = 0; i < pages.length; i++){
            int page = pages[i];

            if(l.contains(page)){
                hit++;
            }
            else{
                fault++;

                if(l.size() < frame){
                    l.add(page);
                }
                else{
                    int farthest = -1;
                    int indexToReplace = -1;

                    for(int j = 0; j < l.size(); j++){
                        int current = l.get(j);
                        int k;

                        for(k = i+1; k < pages.length; k++){
                            if(pages[k] == current){
                                break;
                            }
                        }

                        if(k == pages.length){
                            indexToReplace = j;
                            break;
                        }

                        if(k > farthest){
                            farthest = k;
                            indexToReplace = j;
                        }
                    }

                    l.set(indexToReplace, page);
                }
            }

            System.out.println("Step " + (i+1) + ": " + l);
        }

        System.out.println("Hit: " + hit);
        System.out.println("Fault: " + fault);
        System.out.println("Hit Ratio: " + (float)hit / pages.length);
    }
}