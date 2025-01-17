//buy and sell stocks problem where we have to find profit O(n);
public class BuySellStocks {
    public static int BuySell(int prices[]){
    int buyprice=Integer.MAX_VALUE;
    int maxprofit=0;
    int profit;
    
    for(int i=0;i<prices.length;i++){
        if(buyprice<prices[i]){
            profit=prices[i]-buyprice;
            maxprofit=Math.max(maxprofit, profit);
            
        }
        else{
            buyprice=prices[i];
            
        }
    }
    System.out.println("your buying price is:"+buyprice);
    return maxprofit;
    }
    public static void main(String[] args) {
        int prices[]={7,1,5,3,6,4};
        System.out.println("your profit is:"+BuySell(prices));
    }
}