//removing duplicates.
package LinkedList;
public class RemoveDuplicate {
    public static class node{
        int data;
        node next;
        public node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static void duplicate(node head){
        node temp=head;
        while(temp!=null){
            node move=temp.next;
            node prev=temp;
            while(move!=null){
                if(temp.data==move.data){
                  prev.next=move.next;
                }
                prev=move;
                move=move.next;
            }
            temp=temp.next;
        }        
    }
    public static node head;
    public void  print(node head){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        RemoveDuplicate LL=new RemoveDuplicate();
        LL.head =new node(1);
        LL.head.next=new node(2);
        LL.head.next.next=new node(3);
        LL.head.next.next.next=new node(4);
        LL.head.next.next.next.next=new node(2);
        LL.print(head);
        LL.duplicate(head);
        LL.print(head);
    }
}
