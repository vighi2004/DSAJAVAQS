//pushing element in bottom of stack.
import java.util.*;
public class pushBottom {
    public static void pushBottom(Stack<Integer> s,int data){
         if(s.isEmpty()){
            s.push(data);
            return;
         }
         int top=s.pop();
         pushBottom(s, data);
         s.push(top);
    }
    public static void ReverseStack(Stack <Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top=s.pop();
        ReverseStack(s);
        pushBottom(s, top);
    }

    public static void main(String[] args) {
        Stack <Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s);
        //pushBottom(s,4);
        ReverseStack(s);
        System.out.println(s);
    
}}
