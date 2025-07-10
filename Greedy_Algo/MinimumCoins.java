//finding minimum number of coins required.
package Greedy_Algo;
public class MinimumCoins {
    public static void main(String[] args) {
        int n=39;
        int coins[]={1,2,5,10};
        int count=0;
        for(int i=coins.length-1;i>=0;i--){
           while(n!=0){
                if(n>coins[i]){
                    n=n-coins[i];
                    count++;
                }
                else{
                    break;
                }
           } 
        }
        System.out.println("minimum coins required: "+count);
    }
    
}
