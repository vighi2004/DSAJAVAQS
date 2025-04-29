//Stack using DEQUE.
import java.util.*;
public class StackusingDQ {
    public static void add(Deque<Integer> DQ,int data){
         DQ.addLast(data);
    }
    public static void pop(Deque<Integer> DQ){
        DQ.removeLast();
   }
   public static int peek(Deque<Integer> DQ){
    return DQ.peekLast();
   }

    public static void main(String[] args) {
        Deque <Integer> DQ=new LinkedList<>();
        add(DQ,1);
        add(DQ,2);
        add(DQ,3);
        add(DQ,4);
        System.out.println(DQ);
        pop(DQ);
        System.out.println(DQ);
        System.out.println(peek(DQ));
    }
}
