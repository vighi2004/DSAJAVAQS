//Fractional knapsack solving using grredy.
package Greedy_Algo;
import java.util.*;
public class FractionalKnap {
    public static void main(String[] args) {
        int value[]={60,100,120};
        int weight[]={10,20,30};
        int W=50;
        //make 2D array to sort ratio with index.
        double Ratio[][]=new double[value.length][2];
        for(int i=0;i<Ratio.length;i++){
            Ratio[i][0]=i;
            Ratio[i][1]=value[i]/(double)weight[i];
        }
        Arrays.sort(Ratio,Comparator.comparingDouble(o->o[1]));
        double Maxcollect=0;
        int Capacity=W;
        for(int i=Ratio.length-1;i>=0;i--){
            int idx=(int)Ratio[i][0];
            if(Capacity>=weight[idx]){
                    Maxcollect=Maxcollect+value[idx];
                    Capacity=Capacity-weight[idx];
                }
                else{
                    //fractional item adding.
                    Maxcollect=Maxcollect + (Ratio[i][1]*Capacity);
                    Capacity=0;
                    break;
                }
            }
             System.out.println(Maxcollect);
        }
       

        
    }
    

