//find minimu element from stack .
import java.util.Stack;
public class MinStack {
    public void minstack(Stack <Integer> s,Stack <Integer> s1) {
        s.push(null);
        s1.push(null);
        
    }
    
    public void push(Stack <Integer> s,Stack <Integer> s1,int i,Stack <Integer> minStack) {
         s.push(i);
         if (minStack.isEmpty()) {
            minStack.push(i);
        } else {
            minStack.push(Math.min(i, minStack.peek()));
        }
        s1.push(null);
    }
    
    public void pop(Stack <Integer> s,Stack <Integer> s1,Stack <Integer> minStack) {
        if (!s.isEmpty()) {
            s.pop();
            minStack.pop();
        }
        s1.push(null);
    }
    
    public static void top(Stack <Integer> s,Stack <Integer> s1) {
        s1.push(s.peek());
    }
    
    public static int getMin(Stack <Integer> minStack) {
        return minStack.peek();
    }
    public static void main(String[] args) {
        String str[]={"MinStack","push","push","push","getMin","pop","top","getMin"};
        MinStack m=new MinStack();
        int min=Integer.MAX_VALUE;
        int[] arr = {0, -2, 0, -3, 0, 0, 0, 0};
        Stack <Integer> s=new Stack<>();
        Stack <Integer> s1=new Stack<>();
        Stack <Integer> minStack=new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(str[i].equals("MinStack")){
                m.minstack(s,s1);
            }
            else if(str[i].equals("push")){
                m.push(s,s1,arr[i],minStack);
            }
            else if(str[i].equals("pop")){
                m.pop(s,s1,minStack);
            }
            else if(str[i].equals("top")){
                m.top(s,s1);
            }
            else{
                s1.push(m.getMin(minStack));
            }
        }
        System.out.println(s1);
        
    }
}
