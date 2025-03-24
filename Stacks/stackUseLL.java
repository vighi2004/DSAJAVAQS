//implementation of stack using linkedlist.
package Stacks;
public class stackUseLL {
    public static  class node{
        int data;
        node next;
        public node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static node head=null;
    public static void push(int data){
        node newnode=new node(data);
        newnode.next=head;
        head=newnode;
    }
    public static int pop(){
        if(head==null){
            System.out.println("LL is empty");
            return 0;
        }
        int val=head.data;
        node temp=head;
        temp=temp.next;
        head=temp;
        return val;
    }
    public static int peek(node head){
        if(head==null){
            return -1;
        }
        return head.data;
    }
    public static void print(){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
     stackUseLL LL=new stackUseLL();
     LL.push(1);
     LL.push(2);
     LL.push(3);
     LL.print();
     System.out.println("element pop: "+LL.pop());
     LL.print();
     System.out.println("peek element is "+peek(head));
     
    }
}
