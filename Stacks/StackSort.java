//sorting stack using recursion.
import java.util.*;
public class StackSort {
    public static void sort(Stack <Integer> S){
         if(S.isEmpty()){
             return;
         }
         int top=S.pop();
         sort(S);
         insertEle(S,top);

    }
        public static void insertEle(Stack<Integer> S, int data) {
            if (S.isEmpty() || S.peek() <= data) {
                S.push(data);
                return;
            }
        
            int top = S.pop(); 
            insertEle(S, data); 
            S.push(top);        
        }
        

    public static void main(String[] args) {
        Stack <Integer> S=new Stack<>();
        S.push(2);
        S.push(5);
        S.push(1);
        S.push(3);
        System.out.println(S);
        System.out.println("Sorting...");
        sort(S);
        System.out.println(S);
    }
    
}
