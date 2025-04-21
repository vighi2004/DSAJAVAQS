//Delete nodes which have a greater value on right side in time O(n).
package LinkedList;
public class DeleteNodeGre {
    public static class node {
        int data;
        node next;

        public node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static node head;

    public static node reverse(node head) {
        node prev = null;
        node curr = head;
        node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev; // New head
    }
    public static void result(node head) {
        node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.data > temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
    }
    public static void printList(node head) {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        //: 12->15->10->11->5->6->2->3
        head = new node(12);
        head.next = new node(15);
        head.next.next = new node(10);
        head.next.next.next = new node(11);
        head.next.next.next.next = new node(5);
        head.next.next.next.next.next = new node(6);
        head.next.next.next.next.next.next = new node(2);
        head.next.next.next.next.next.next.next = new node(3);
        System.out.println("Original LL: ");
        printList(head);

        head = reverse(head); 
        result(head);
        head=reverse(head);

        System.out.println("Output LL: ");
        printList(head);
    }
}
