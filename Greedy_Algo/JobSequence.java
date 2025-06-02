//finding profits with particular deadlines using greedy aproach.
package Greedy_Algo;
import java.util.*;
public class JobSequence {
    static class job{
        int id;
        int deadline;
        int profit;

        public job(int i,int d,int p){
            id=i;
            deadline=d;
            profit=p;
        }
    }
    public static void main(String[] args) {
        int jobsInfo[][]={{4,20},{1,10},{1,40},{1,20}};
        ArrayList<job> jobs=new ArrayList<>();//job object array this is.
        for(int i=0;i<jobsInfo.length;i++){
            jobs.add(new job(i,jobsInfo[i][0],jobsInfo[i][1]));
        }
         Collections.sort(jobs,(obj1,obj2)->obj2.profit-obj1.profit);//descending
         //max deadline finding.
         int maxdeadline=0;
         for(int i=0;i<jobs.size();i++){
           maxdeadline=Math.max(maxdeadline,jobs.get(i).deadline);
         }
         boolean[] slots = new boolean[maxdeadline + 1];//slots tracking.
         ArrayList <Integer> seq=new ArrayList<>();
         int profit=0;
        for (int i = 0; i < jobs.size(); i++) {
           job curr = jobs.get(i);
           for (int t = curr.deadline; t >= 1; t--) {
               if (!slots[t]) {
               slots[t] = true;
               seq.add(curr.id);
               profit=profit+curr.profit;
               break;
        }
    }
}
         //print seq
         System.out.println("Maximum jobs can be done: "+seq.size());
         for(int i=0;i<seq.size();i++){
            System.out.print(seq.get(i)+" ");
         }
         System.out.println();
         System.out.println("Max profit is "+profit);
        }
    }
