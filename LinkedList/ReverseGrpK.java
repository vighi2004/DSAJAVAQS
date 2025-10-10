//Reversing Grooup of k elements only.
package LinkedList;
import java.util.*;
public class ReverseGrpK {
    static class node{
        int data;
        node next;
        public node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static node head;
    public static node tail;
    public static int size;
    //make LL
    public static void makeLL(int data){
        size++;
        node newnode=new node(data);
        if(head==null){
            head=tail=newnode;
            return;
        }
        tail.next=newnode;
        tail=newnode;
    }

   public static  void printLL(node head){
    node temp=head;
    while(temp!=null){
        System.out.print(temp.data);
        System.out.print("->");
        temp=temp.next;
    }
    System.out.print("null");
   }
   public static node ReverseGrp(node head,int k){
    if(head==null&&k<1){
        return head;
    }
    node dummy = new node(0);
    dummy.next = head;
    node prevGroupEnd = dummy;
    node curr = head;
    while(true){
        node grpStart=curr;
        int count=0;
        while(count<k&& curr!=null){
            curr=curr.next;
            count++;
        }
        if(count<k){
            break;
        }
    
        node newHead=reverseLL(grpStart,curr);
        prevGroupEnd.next=newHead;
        grpStart.next=curr;
        prevGroupEnd=grpStart;
    }
    return dummy.next;
   }
   public static node reverseLL(node start,node end){
    node prev=null;
    node curr=start;
    node next;
    while(curr!=end){
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
    }
    return prev;
   }

    public static void main(String[] args) {
       int arr[]={1, 2, 3, 4, 5};
       int k=2;
       for(int i=0;i<arr.length;i++){
        makeLL(arr[i]);
       }
       printLL(head);
       head=ReverseGrp(head,k);
       System.out.println();
       printLL(head);
    }
    
}
