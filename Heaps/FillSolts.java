//Minimum time required to filled slots.
package Heaps;
import java.util.*;
public class FillSolts {
    public static void main(String[] args) {
        int arr[]={2,6};
        int N=6;
        int Time=0;
        Queue <Integer> Q=new LinkedList<>();
        boolean fill[]=new boolean[N];
        for(int i=0;i<arr.length;i++){
                fill[arr[i]-1]=true;
                Q.add(arr[i]-1);
        }
        while(!Q.isEmpty()){
            int size=Q.size();
            boolean newfill=false;
            for(int i=0;i<size;i++){
               int idx=Q.remove();
               if(idx!=0&&fill[idx-1]==false){
                  fill[idx-1]=true;
                  Q.add(idx-1);
                  newfill=true;
               }
               if(idx<N-1&&fill[idx+1]==false){
                  fill[idx+1]=true;
                  Q.add(idx+1);
                  newfill=true;
                }
            }
               if(newfill){
                 Time++;
                }   
            }
             System.out.println("Time required: "+Time);

    }
}
    

