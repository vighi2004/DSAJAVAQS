//printing zigzag linkedlist.
public class zigzag{
    public static class node{
        int data;
        node next;
        public node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static node head;
    public static node tail;
    public static void printList(node head) {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static node middleInd(node head){
       node slow=head;
       node fast=head;
       while(fast!=null&&fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
       }
       return slow;
    }
    public static node  reversinghalf(node head) {
        if (head == null || head.next == null) {
            return head;
        }
    
        // Find middle node
        node middleI = middleInd(head);
    
        // Reverse the second half
        node prev = null;
        node curr = middleI.next;
        middleI.next=null;
        node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;  // Reverse link
            prev = curr;
            curr = next;
        }
    
        node right = prev;  // Right half 
        node left = head;   // Left half
        node zigzagLL = new node(0); // Dummy node to start
        node temp = zigzagLL;

        while (left != null || right != null) {
            if (left != null) {
                temp.next = left;
                temp = temp.next;
                left = left.next;
            }
            if (right != null) {
                temp.next = right;
                temp = temp.next;
                right = right.next;
            }
        }

        return zigzagLL.next;
    }

    public static void main(String[] args) {
        zigzag list =new zigzag(); 
        list.head = new node(1);
        list.head.next = new node(2);
        list.head.next.next = new node(3);
        list.head.next.next.next = new node(4);
        list.head.next.next.next.next = new node(5);
        list.printList(list.head);
        list.head=list.reversinghalf(list.head);
        list.printList(list.head);
}
}