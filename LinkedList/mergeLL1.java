//merging LL with sorted but duplicates are there.
package LinkedList;

public class mergeLL1 {
    public static class node{
        int data;
        node next;
        public node(int data){
           this.data=data;
           this.next=null;
        }
    }
    public node head;
    public static node mergeLL(node left, node right) {
        node mergeLL = new node(-1); // Dummy node
        node temp = mergeLL;

        while (left != null && right != null) {
            if (left.data <= right.data) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        // Add remaining elements
        if (left != null) {
            temp.next = left;
        }
        if (right != null) {
            temp.next = right;
        }

        return mergeLL.next; // Return merged list (skipping dummy node)
    }
    public static void print(node head){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        mergeLL1 LL1 = new mergeLL1();
        mergeLL1 LL2 = new mergeLL1();

        LL1.head=new node(1);
        LL1.head.next=new node(2);
        LL1.head.next.next=new node(3);
        
        LL2.head=new node(1);
        LL2.head.next=new node(2);
        LL2.head.next.next=new node(4);
        LL1.print(LL1.head);
        LL2.print(LL2.head);
        LL1.mergeLL(LL1.head, LL2.head);
        LL1.print(LL1.head);
    }
    
}
