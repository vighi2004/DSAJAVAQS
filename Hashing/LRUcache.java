//LRU cahche 
package Hashing;
import java.util.*;
public class LRUcache {
    static class node{
        int key;
        int value;
        node prev,next;
       
        public node(int key,int value){
            this.key=key;
            this.value=value;
            this.next=null;
            this.prev=null;
        }
    }
    public static node head;
    public static int size;
    public static node tail;
    static int capacity;
    static HashMap<Integer, node> hm = new HashMap<>();
    public LRUcache(int capacity) {
        this.capacity=capacity;
        head=new node(-1,-1);
        tail=new node(-1, -1);
        head.next=tail;
        tail.prev=head;
        
    }
    public static void remove(node n){
           n.prev.next=n.next;
           n.next.prev=n.prev;
    }
    public static void addToHead(node n){
           n.next=head.next;
           n.prev=head;
           head.next.prev = n;
           head.next = n;
    }
    public static void put(int key,int value){
        if(hm.containsKey(key)){
             node exitsNode=hm.get(key);
             exitsNode.value=value;
             remove(exitsNode);
             addToHead(exitsNode);
             return;
        }
        if(hm.size() == capacity) {
        node lru = tail.prev;
        remove(lru);
        hm.remove(lru.key);
        }
        //if space is there then add
        node newnode=new node(key, value);
        addToHead(newnode);
        hm.put(key, newnode);
    }
    public static int get(int key){
        if(hm.containsKey(key)){
            node exitsNode=hm.get(key);
            remove(exitsNode);
            addToHead(exitsNode);
           return exitsNode.value;       
        }
        else{
            return -1;
        }
    }
    public static void main(String[] args) {
        int input[][]={{2},{1,1},{2,2},{1},{3,3},{2},{4,4},{1},{3},{4}};
        LRUcache DLL=new LRUcache(input[0][0]);
        String opInput[]={"LRUCache","put","put","get","put","get","put","get","get","get"};
        System.out.print("null");
        for(int i=0;i<opInput.length;i++){
           if(opInput[i].equals("put")){
              put(input[i][0], input[i][1]);
              System.out.print(" "+"null");
           }
           if(opInput[i].equals("get")){
            System.out.print(" "+get(input[i][0]));
           }
        }

        
    }
}
