//find smallest number with digit count and sum.
package Greedy_Algo;
public class SmallestNumber {
    public static void main(String[] args) {
        int s=9;
        int d=2;
         if (s > 9 * d || s < 1) {
            System.out.println("Not possible");
            return;
        }

        StringBuilder ans = new StringBuilder();
        for(int i=0;i<d;i++){
            int start=(i==0)?1 :0;
            for(int digit=start;digit<10;digit++){
              int remaining=s-digit;
              int maxpossible=(d-i-1)*9;
              if(remaining<=maxpossible){
                ans.append(digit);
                s-=digit;
                break;
              }
            }}
          System.out.println("number found: "+ans.toString());
    
    
}}
