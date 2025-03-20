//detecting cycle by using slow and fast pointer approach;
package LinkedList;
public class RemoveCycle {
    public static class node{
        int data;
        node next;
        public  node(int data){
              this.data=data;
              this.next=null;

        }
    }
    public static node head;
    public static node tail;
    public static void removeCycle(){
        node slow=head;
        node fast=head;
        while(fast!=null&&fast.next!=null){
            System.out.print(slow.data+"->");
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
               break;
            }
            else if(fast==null&&fast.next==null){
                System.out.println("No cycle exist");
                return;
            }
            }
            slow=head;
            node prev=null;
            while(slow!=fast){
                 slow=slow.next;
                 prev=fast;
                 System.out.print(prev.data+"->");
                 fast=fast.next;
                }
                prev.next=null;
                System.out.println("null");
                System.out.println("As cycle exist we have remove cycle");
        }
        
    public static void Print(){
        if(head==null){
            System.out.println("LL is empty!");
        }
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        
    }

    public static void main(String[] args) {
        head =new node(1);
        head.next=new node(2);
        head.next.next=new node(3);
        head.next.next.next=new node(4);
        head.next.next.next.next=new node(5);
        head.next.next.next.next.next=new node(6);
        head.next.next.next.next.next.next=new node(7);
        head.next.next.next.next.next.next.next=new node(8);
        head.next.next.next.next.next.next.next.next=null;
        removeCycle();
    

    }
}
