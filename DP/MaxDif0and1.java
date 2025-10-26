//finding max difference between zeros and ones.if all 1 cames return -1;
package DP;
public class MaxDif0and1 {
    public static void main(String[] args) {
        String s="11000010001";
        int sum=0;
        int maxsum=0;
        int check=0;
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='1'){
            check++;
           }
        }
        if(check==s.length()){
            System.out.println("-1");
        }
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='0'){
                sum++;
                maxsum=Math.max(maxsum, sum);
            }
            else{
                sum--;
                if(sum<0){
                  sum=0;
                }
            }
    }
    System.out.println(maxsum);
}
}
