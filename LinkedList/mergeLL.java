//merging sorted LL.
package LinkedList;
public class mergeLL {
    public static class node{
        int data;
        node next;
        public node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public  node head;
    //merge LL logic.
    public void merge(node temp,node temp1){
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=temp1;
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
            mergeLL LL1 = new mergeLL();
            mergeLL LL2 = new mergeLL();
            mergeLL LL3 = new mergeLL();
    
            // First linked list
            LL1.head = new node(1);
            LL1.head.next = new node(3);

            LL2.head = new node(6);
            LL2.head.next = new node(8);

            LL3.head = new node(9);
            LL3.head.next = new node(10);

    
            // Printing each list
            System.out.println("LL1:");
            LL1.print(LL1.head);
            System.out.println("LL2:");
            LL2.print(LL2.head);
            System.out.println("LL3:");
            LL3.print(LL3.head);
           System.out.println("merge LL:"); 
           LL1.merge(LL1.head,LL2.head);
           LL1.merge(LL1.head,LL3.head);
           LL1.print(LL1.head);

        
    }
}

