//K maximum combination sum of two arrays.
package Heaps;
import java.util.*;
public class KmaxSum{
    static class pair implements Comparable<pair>{
        int sum;
        int i,j;
        public pair(int sum,int i,int j){
            this.sum=sum;
            this.i=i;
            this.j=j;
        }
        @Override
        public int compareTo(pair p2){
            return p2.sum-this.sum;
        }
    }
    public static void main(String[] args) {
         Integer arr1[]={1, 4, 2, 3};
         Integer arr2[]={2, 5, 1, 6};
         int k=3;
         Arrays.sort(arr1, Collections.reverseOrder());
         Arrays.sort(arr2, Collections.reverseOrder());
         HashSet <String> set=new HashSet<>();
         PriorityQueue <pair> pq=new PriorityQueue<>();
         int i=0;
         int j=0;
         pq.add(new pair(arr1[i]+arr2[j],i,j));
         set.add(i+","+j);
         while(k-->0&&!pq.isEmpty()){
            pair top=pq.poll();
            System.out.print(top.sum+" ");
            int x=top.i;
            int y=top.j;
            if(x+1<arr1.length&&!set.contains((x+1)+","+y)){
                 pq.add(new pair(arr1[x+1]+arr2[y],x+1,y));
                 set.add((x+1)+","+y);
            }
            if(y+1<arr2.length&&!set.contains((x)+","+(y+1))){
                 pq.add(new pair(arr1[x]+arr2[y+1],x,(y+1)));
                 set.add(x+","+(y+1));
            }
    }
}
}