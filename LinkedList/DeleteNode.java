//deleteing N nodes after M nodes in LL. 
package LinkedList;

import java.util.LinkedList;

public class DeleteNode {
    public static class node{
        int data;
        node next;
        public node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static node head;
    //n nodes deleteing logic.
    public void deletenode(node head,int M,int N){
        node prev=head;
        int len=1;
        int count=0;
        while(prev.next!=null){
              if(len==M){
                prev.next=prev.next.next;
                prev=head;;
                len=1;
                count++;
              }
              if(count==N){
                count=0;
                M=M+M;
              }
              prev=prev.next;
              len++;
        }

    }
    //print
    public void  print(node head){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
        DeleteNode LL=new DeleteNode();
        LL.head =new node(1);
        LL.head.next=new node(2);
        LL.head.next.next=new node(3);
        LL.head.next.next.next=new node(4);
        LL.head.next.next.next.next=new node(5);
        LL.head.next.next.next.next.next=new node(6);
        LL.head.next.next.next.next.next.next=new node(7);
        LL.head.next.next.next.next.next.next.next=new node(8);
        // LL.head.next.next.next.next.next.next.next.next=new node(9);
        // LL.head.next.next.next.next.next.next.next.next.next=new node(10);
        LL.print(head);
        int M=2;
        int N=2;
        LL.deletenode(head,M,N);
        LL.print(head);

        
    }
}

