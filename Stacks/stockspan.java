//printing span using stack O(n).
import java.util.*;
public class stockspan {
    public static void main(String[] args) {
        int arr[]={100, 80, 60, 70, 60, 75, 85};
        Stack <Integer> s=new Stack<>();
        Stack <Integer> s1=new Stack<>();
        s.push(0);
        s1.push(1);
        int i=1;
        while(i<arr.length){
             while(!s.isEmpty()&&arr[i]>arr[s.peek()]){
                s.pop();
             }
             int n=i-s.peek();
             s1.push(n);
             s.push(i);
             i++;
        }   
        System.out.println(s1);
    }
    }

