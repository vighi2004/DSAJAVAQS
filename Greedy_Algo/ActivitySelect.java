//Actvity selection using greedy approach time-O(nlogn).
package Greedy_Algo;
import java.util.*;
public class ActivitySelect {
    public static void main(String[] args) {
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};//as this end time is already sorted.
        int Activites[][]=new int[start.length][3];//we make 2d array for sorting end time.
        for(int i=0;i<start.length;i++){
            Activites[i][0]=i;//index in first column.
            Activites[i][1]=start[i];//2nd column.
            Activites[i][2]=end[i];//3rd column.
        }
        //lamda function used to sort 2d array.
        Arrays.sort(Activites, Comparator.comparingDouble(o->o[2]));
        ArrayList <Integer> ans=new ArrayList<>();
        int maxAct=1;//first wali activty
        ans.add(Activites[0][0]);
        int End=Activites[0][2];
        for(int i=1;i<end.length;i++){
            if(Activites[i][1]>=End){
               maxAct++;
               ans.add(Activites[i][0]);
               End=Activites[i][2];
            }
        }
        System.out.println("max activites: "+maxAct);
        for(int i=0;i<ans.size();i++){
            System.out.print(" "+"A"+ans.get(i));
        }
        
    }
}
