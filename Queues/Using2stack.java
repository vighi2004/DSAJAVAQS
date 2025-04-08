//working on it....
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
    }
    public static void print(Stack<Integer> s2){
           while(!s2.isEmpty()){
                System.out.print(" "+s2.peek());
                s2.pop();
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
    print(s2);
    }
}
