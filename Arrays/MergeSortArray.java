//Merge two sorted arrays without extra space where samllest elemnts in array1 and largest elements in arrys2.
import java.util.*;
public class MergeSortArray {
    public static void main(String[] args) {
    ArrayList <Integer> a=new ArrayList<>();
    ArrayList <Integer> b=new ArrayList<>();
    a.add(2);
    a.add(4);
    a.add(7);
    a.add(10);
    b.add(2);
    b.add(3);
    //merging
    a.addAll(b);
    Collections.sort(a); 
    int num=a.size()-b.size();
    b.clear();
    for(int i=num;i<a.size();i++){
        b.add(a.get(i));
    }
    for (int i = a.size() - 1; i >= num; i--) {
        a.remove(i);
    }
    System.out.print(a);
    System.out.print(b);
}
}

