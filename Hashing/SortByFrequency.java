//sorting String by Frequency.time-O(N+KlogK)N=total charcaters,K=uniques character stored.
package Hashing;
import java.util.*;
public class SortByFrequency {
    public static class Info implements Comparable<Info>{
        char ch;
        Integer Count;

        public Info(char ch,Integer Count){
            this.ch=ch;
            this.Count=Count;
        }
        @Override
        public int compareTo(Info i2){
            return i2.Count-this.Count;
        }
    }
    public static void main(String[] args) {
        HashMap <Character,Integer> hm=new HashMap<>();
        PriorityQueue <Info> PQ=new PriorityQueue<>(); 
        String str="tree";
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            hm.put(ch,hm.getOrDefault(ch, 0)+1);      
        }
        for(Character k:hm.keySet()){
            PQ.add(new Info(k, hm.get(k)));
        }
        String res="";
        while(!PQ.isEmpty()){
             Info freq=PQ.remove();
            while(freq.Count>0){
                 res=res+freq.ch;
                 freq.Count--;
            }
        }
        System.out.println(res);

    }
    
}
