package LinkedList;

public class mergeSort {
    public static node head;

    // Make node class static so it can be accessed in static methods
    public static class node {
        int data;
        node next;

        public node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static node getmid(node head) {
        node slow = head;
        node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static node mergesort(node head) {
        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Find middle node
        node mid = getmid(head);

        // Divide list into two halves
        node righthead = mid.next;
        mid.next = null;

        // Recursive calls for left and right halves
        node newleft = mergesort(head);
        node newright = mergesort(righthead);

        // Merge sorted halves
        return merge(newleft, newright);
    }

    public static node merge(node left, node right) {
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

    public static void printList(node head) {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        mergeSort list = new mergeSort();
        list.head = new node(5);
        list.head.next = new node(4);
        list.head.next.next = new node(3);
        list.head.next.next.next = new node(2);
        list.head.next.next.next.next = new node(1);

        System.out.println("Original List:");
        printList(list.head);

        list.head = mergesort(list.head);

        System.out.println("Sorted List:");
        printList(list.head);
    }
}
