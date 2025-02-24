//This is an brute force approach of solving without KPM algo O(n^2).
package Strings;

public class LPS {
      public static void main(String[] args) {
        String str="aaaa";
        int maxlen=0;
        String suf;
        StringBuilder pre=new StringBuilder();
        for(int i=0;i<str.length()-1;i++){
            pre.append(str.charAt(i));
            for(int j=str.length()-1;j>0;j--){
                suf=str.substring(str.length()-i-1);
                if(pre.toString().equals(suf.toString())){
                    int currlength=pre.length();
                    maxlen=Math.max(maxlen,currlength);
                }
                
            }
      }
      System.out.println(maxlen);   
}
}
