//functions of double linkedlist.
package LinkedList;

public class DoubleList {
    public class node{
        int data;
        node next;
        node prev;
        public node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    public static node head;
    public static int size;
    public static node tail;
    //addfirst
    public void addFirst(int data){
         size++;
         node newnode=new node(data);
         if(head==null){
            head=tail=newnode;
            return;
         }
         newnode.next=head;
         head.prev=newnode;
         head=newnode;


    }
    //removefirst
    public void removeFirst(){
        if(head==null){
            System.out.println("DLL is empty");
            return;
         }
         if(size==1){
            head=tail=null;
            return;
         }
         head=head.next;
         head.prev=null;
         size--;
    }
    //addlast
    public void addLast(int data){
        node newnode=new node(data);
        tail.next=newnode;
        newnode.prev=tail;
        tail=newnode;
        size++;
    }
    //removelast
    public void removeLast(){
        if(size==0){
            System.out.println("LL is empty!");
        }
        else if(size==1){
            head=tail=null;
            size=0;
            return;
        }
        tail=tail.prev;
        tail.next=null;
        size--;
    }
    //reverse
    public void reverse(){
        node temp=tail;
        while(tail!=head.prev){
            System.out.print(tail.data+"<->");
            tail=tail.prev;
        }
        System.out.println("null");
    }
    //print
    public void print(){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        DoubleList dll=new DoubleList();
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.addLast(5);
        dll.addFirst(0);
        // dll.removeFirst();
        // dll.removeLast();
        dll.print();
        //System.out.println(dll.size);
        dll.reverse();


    }
}
