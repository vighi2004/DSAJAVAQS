//printing all combination of parenthesis forming.
package DP;
public class printParenthesis {
    public static void print(int open,int close,String str,int n){
        if(open==0&&close==0){
            System.out.println(str);
            return;
        }
        if(open>0){
            print(open-1, close, str+"{", n);
        }
        if(close>open){
          print(open, close-1, str+"}", n);
        }
    }
    public static void main(String[] args) {
        int n=3;
        print(n,n,"",n);
    }
    
}
