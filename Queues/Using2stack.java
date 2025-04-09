//Queue using two Stack.push O(1) and pop O(N)
package Queues;

import java.util.Stack;
public class Using2stack {
    public static void popy(Stack<Integer> s1,Stack<Integer> s2){
      if(s1.isEmpty()){
        System.out.println("QUEUE IS EMPTY");
        return;
      }
      while(s1.peek()!=s1.firstElement()){
           s2.push(s1.pop());
      }
      while(!s1.isEmpty()){
        s1.pop();
      }
      while(!s2.isEmpty()){
        s1.push(s2.pop());
      }

    }   
    public static void main(String[] args) {
    Stack <Integer> s1=new Stack<>();
    Stack <Integer> s2=new Stack<>();
    s1.add(1);
    s1.add(2);
    s1.add(3);
    s1.add(4);
    System.out.println(s1);
    popy(s1,s2);
    System.out.println(s1);
    popy(s1,s2);
    s1.push(100);
    System.out.println(s1);
    }
}
