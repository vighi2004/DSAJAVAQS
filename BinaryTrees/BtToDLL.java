//convert BT to Doubly Linked List.
package BinaryTrees;
import java.util.*;
public class BtToDLL {
    static class node{
        int data;
        node left;
        node right;
        public node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class node1{
        int data;
        node1 next;
        node1 prev;
        public node1(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    public static node1 head;
    public static node1 tail;
    public static node BuildT(String arr[]){
        if(arr.length==0||arr[0].equals("N")){
            return null;
        }
        node root = new node(Integer.parseInt(arr[0]));
        Queue <node> q=new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
             node current = q.poll();

            // Left child
            if (!arr[i].equals("N")) {
                current.left = new node(Integer.parseInt(arr[i]));
                q.add(current.left);
            }
            i++;
            if (i >= arr.length) break;

            // Right child
            if (!arr[i].equals("N")) {
                current.right = new node(Integer.parseInt(arr[i]));
                q.add(current.right);
            }
            i++;
        }

        return root;
    }
    public static void ToDLL(node root){
        if(root==null){
            return ;
        }
        ToDLL(root.left);
        node1 newnode=new node1(root.data);
         if(head==null){
            head=tail=newnode;
        }
        tail.next=newnode;
        newnode.prev=tail;
        tail=newnode;
        ToDLL(root.right);
    }
     public static void print(){
        node1 temp=head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        String nodes[]={"10","12","15","25","30","36","N"};
        node root=BuildT(nodes);
        ToDLL(root);
        System.out.println("prinitng DLL:-");
        print();
    }
    
}
