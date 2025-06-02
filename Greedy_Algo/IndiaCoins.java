//Indian coins given finding minimum coins required to make change of value.
package Greedy_Algo;
public class IndiaCoins {
    public static void main(String[] args) {
    int coins[]={1,2,5,10,20,50,100,500,2000};
    int value=1059;
    int count=0;
    int capacity=value;
    for(int i=coins.length-1;i>=0;i--){
        while(capacity>=coins[i]){
            System.out.println(coins[i]);
            capacity=capacity-coins[i];
            count++;
        }
    }
    System.out.println("Total coins used: "+count);
}
}
