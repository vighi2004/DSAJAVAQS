//checking if array a[] can we form like array b[] with help of stack push pop.O(N) time.
import java.util.*;
public class StackPermute {
    public static Boolean solve(int a[],int b[]){
        if (a.length != b.length) return false;
        Stack <Integer> S=new Stack<>();
        int j=0;
        for(int i=0;i<a.length;i++){
            S.push(a[i]);
            while(!S.isEmpty()&&b[j]==S.peek()){
                S.pop();
                j++;
            }
        }
        return S.isEmpty();
    }
    public static void main(String[] args) {
        int a[]={1,2,3};
        int b[]={3,1};
        System.out.println(solve(a,b));
        
    }
    
}
