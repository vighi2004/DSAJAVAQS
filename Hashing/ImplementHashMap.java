//implement hasmap.
package Hashing;
import java.util.*;
public class ImplementHashMap {
    static class HashMap<K,V>{
        private class Node{
             K key;
             V value;

             public Node(K key,V value){
                this.key=key;
                this.value=value;
             }
        }
        private int n;//nodes size
        private int N;//bucket size
        private LinkedList<Node> buckets[];//N array size
        @SuppressWarnings("unchecked")//as this stucks the warnings as we we doing array of linked.
        public HashMap(){//contructor
            this.N=4;
            this.buckets=new LinkedList[4];
            for(int i=0;i<4;i++){
            this.buckets[i]=new LinkedList<>();//this means linked is there in all index in array.
            }

        }
        private int hashFuction(K key){//O(1)
            int hc=key.hashCode();
            //1234,-12344;
            return Math.abs(hc)%buckets.length;//for 4 index 0 to 3 comes.

        }
        private int searchLL(K key,int bi){//O(1)
            LinkedList<Node> ll=buckets[bi];
            int di=0;
            for(int i=0;i<ll.size();i++){
                Node node=ll.get(i);
                if(node.key==key){
                    return di;
                }
                di++;
            }
            return -1;
        }
        //Re hashing
        @SuppressWarnings("unchecked") 
        private void reHash(){//O(n)
            LinkedList<Node> oldBuck[]=buckets;
            buckets=new LinkedList[N*2];
            N=2*N;
            for(int i=0;i<buckets.length;i++){
                buckets[i]=new LinkedList<>(); 
            }
            //adding all nodes in new bucket 
            for(int i=0;i<oldBuck.length;i++){
                LinkedList<Node> ll=oldBuck[i];
                for(int j=0;i<ll.size();i++){
                    Node node=ll.remove();
                    put(node.key,node.value);
                }
            }
        }
        public void put(K key,V value){//O(1)  O(lamda).
            int bi=hashFuction(key);
            int di=searchLL(key,bi);//searching node in Particular index LL
            if(di!=-1){
                Node node=buckets[bi].get(di);
                node.value=value;
            }
            else{
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda=(double)n/N;
            if(lambda>2.0){
                 reHash();
            } 
        }
        public boolean containsKey(K key){//O(1)
            int bi=hashFuction(key);
            int di=searchLL(key,bi);//searching node in Particular index LL
            if(di!=-1){
                return true;
            }
            else{
                return false;
            }
        }
        public V remove(K key){//O(1)
            int bi=hashFuction(key);
            int di=searchLL(key,bi);//searching node in Particular index LL
            if(di!=-1){
                Node node=buckets[bi].remove(di);
                n--;
                return node.value;

            }
            else{
                return null;
            }
        }
        public V get(K key){//O(1)
            int bi=hashFuction(key);
            int di=searchLL(key,bi);//searching node in Particular index LL
            if(di!=-1){
                Node node=buckets[bi].get(di);
                return node.value; 
            }
            else{
                return null;
            }
        }
        public ArrayList<K> keySet(){//O(n)
              ArrayList<K> keys=new ArrayList<>();
              for(int i=0;i<buckets.length;i++){
                LinkedList<Node> ll=buckets[i];
                for(Node k:ll){
                    keys.add(k.key);
                }
              }
              return keys;
        }
        public boolean isEmpty(){//O(1)
            return n==0;
        }


    }
    public static void main(String[] args) {
        HashMap <String,Integer> hm=new HashMap<>();
        hm.put("India",100);
        hm.put("china",50);
        hm.put("nepal",20);
        hm.put("indonesia",6);
        hm.put("USA",150);

        ArrayList<String> keys=hm.keySet();
        for(String key:keys){
            System.out.println(key);
        }
        System.out.println(hm.get("India"));
         System.out.println(hm.remove("India"));
         System.out.println(hm.get("India"));
          System.out.println(hm.containsKey("India"));

        
    }
}
