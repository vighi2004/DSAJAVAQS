//objects store in priority Queue.
package Queues;
import java.util.*;
public class priorityQueue1 {
    static class Student implements Comparable<Student>{
        String name;
        int rank;

        public Student(String name,int rank){
            this.name=name;
            this.rank=rank;
        }
    
       @Override
       public int compareTo(Student s2){
             return this.rank-s2.rank;
         }
    }
    public static void main(String[] args) {
        PriorityQueue <Student> PQ=new PriorityQueue<>();
        PQ.add(new Student("Vighnesh", 1));
        PQ.add(new Student("siddhesh", 5));
        PQ.add(new Student("kunal", 4));
        PQ.add(new Student("rakesh", 2));
        while(!PQ.isEmpty()){
            System.out.println(PQ.peek().name+"->"+PQ.peek().rank);
            PQ.remove();
        }
       

    }
}
