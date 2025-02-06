//coverting number to word e.g:-2020 ouput "two zero two zero".
package Strings;

public class NumbertoWord {
    public static void Convert(int i,String str,String arr[]) {
        if(i==str.length()){
            return;
        }
        int digit=str.charAt(i)-'0';
        System.out.print(" "+ arr[digit]);
        
        Convert(i+1, str, arr);
        

    }
    public static void main(String[] args) {
        int number=2019;
        String arr[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
        String str=Integer.toString(number);
        int i=0;
        Convert(i,str,arr);
    }
    
}
