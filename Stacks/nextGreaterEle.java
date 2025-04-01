//optimised code for find next greater element using stack O(n).
import java.util.Stack;
public class nextGreaterEle {
       public static void main(String[] args) {
        int arr[]={6,8,0,1,3};
        int nextGreater[]=new int[arr.length];
    
        Stack <Integer> s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
        while(!s.empty()&&s.peek()<=arr[i]){
            s.pop();
        }
        if(s.isEmpty()){
            nextGreater[i]=-1;
        }
        else{
            nextGreater[i]=s.peek();
        }
        s.push(arr[i]);
       }
       for(int k=0;k<nextGreater.length;k++){
        System.out.print(" "+nextGreater[k]);
       }
    }
    
}