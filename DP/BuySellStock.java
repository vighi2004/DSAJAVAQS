//Buying and selling stock finding max profit.
package DP;
public class BuySellStock {
    public static void main(String[] args) {
        int arr[]={6,1,7,2,8,4};
        int fee=2;
        int hold=-arr[0];//by default buy
        int nothold=0;
        int firstbuy=0;
        int lastsell=0;
        for(int i=1;i<arr.length-1;i++){
            if(nothold-arr[i]>hold){
                hold=nothold-arr[i];
                firstbuy=i;
            }
            if((arr[i]+hold-fee)>nothold){
                nothold=arr[i]+hold-fee;
                lastsell=i;
            }
        }
        int day=lastsell-firstbuy;
        System.out.println("Day Difference: "+day);
        System.out.println("max profit: "+nothold);
    }
}
