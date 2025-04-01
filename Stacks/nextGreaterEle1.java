//There are two arrays finding array1 next greater with  help of array 2.
import java.util.Stack;
public class nextGreaterEle1 {
       public static void main(String[] args) {
        int num1[]={4,1,2};
        int num2[]={1,3,4,2};
        int nextGreaterofnum2[]=new int[num2.length];
        int nextGreaterofnum1[]=new int[num1.length];

    
        Stack <Integer> s=new Stack<>();
        for(int i=num2.length-1;i>=0;i--){
        while(!s.empty()&&s.peek()<=num2[i]){
            s.pop();
        }
        if(s.isEmpty()){
            nextGreaterofnum2[i]=-1;
        }
        else{
            nextGreaterofnum2[i]=s.peek();
        }
        s.push(num2[i]);
       }
       for (int i = 0; i < num1.length; i++) {
        // Find the index of num1[i] in num2
        for (int j = 0; j < num2.length; j++) {
            if (num1[i] == num2[j]) {
                nextGreaterofnum1[i] = nextGreaterofnum2[j];
                break;
            }
        }
    }
       for(int k=0;k<nextGreaterofnum1.length;k++){
        System.out.print(" "+nextGreaterofnum1[k]);
       }

    }
    
}