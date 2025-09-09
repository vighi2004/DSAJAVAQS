//minimising the cash flow.
package Graphs;
//import java.util.*;
public class MinimiseCashFlow {
    public static void solve(int net[]){
         int maxCreditor=Integer.MIN_VALUE;
         int maxDebitor=Integer.MAX_VALUE;
         int sender=0;
         int reciever=0;
         for(int i=0;i<net.length;i++){
            if(net[i]>maxCreditor){
                maxCreditor=net[i];
                reciever=i;
            }
            if(net[i]<maxDebitor){
                maxDebitor=net[i];
                sender=i;
            }
         }
        int amount = Math.min(-net[sender], net[reciever]);
        net[sender] += amount;    
        net[reciever] -= amount; 
        System.out.println("P" + sender + " pays " + amount + " to P" + reciever);
         if(isAllset(net)){
            return;
         }
         else{
            solve(net);
         }
    }
    public static boolean isAllset(int net[]){
        for(int i=0;i<net.length;i++){
            if(net[i]!=0){
                return false;
            }
        }
        return true;
    }
     public static void main(String[] args) {
         int transaction[][] = {{0, 1000, 2000}, {0, 0, 5000}, {0, 0, 0}};
         int net[]=new int[transaction.length];
         for(int i=0;i<transaction.length;i++){
            for(int j=0;j<transaction.length;j++){
               if(transaction[i][j]!=0){
                    net[i]-=transaction[i][j];
                    net[j]+=transaction[i][j];
               }
            }
         }
         solve(net);
         for(int i=0;i<net.length;i++){
            System.out.print(net[i]+" ");
         }
     }
}
