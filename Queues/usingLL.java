//Solving Queue Using LL in 0(1).
package Queues;
public class usingLL {
   public static class node{
        int data;
        node next;
        node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static node head;
    public static node tail;
    public static int rear=-1;
    public static void add(int data){
        node newnode =new node(data);
        if(head==null){
            head=tail=newnode;
        }else{
        tail.next=newnode;
        tail=newnode;
        }
        rear=rear+1;
    }
    public static node remove(){
        node temp=head;
        if(head==null){
            System.out.println("QUEUE IS EMPTY!");
            return null;
        }
        head=head.next;
        if(head==null){
            tail=null;
        }
        rear--;
        return temp;
    }
    public static int peek(){
        if(head==null){
            return -1;
        }
        return head.data;
    }
    public static void print(node head){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args){
        usingLL LL=new usingLL();
        LL.add(1);
        LL.add(2);
        LL.add(3);
        LL.remove();
        LL.add(4);
        LL.remove();
        LL.print(LL.head);
        System.out.println(LL.peek());
    }
}
