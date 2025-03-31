// Sorting LL in O(n) using frequency (only 0s,1s,2s)
package LinkedList;

public class sortLL {
    public static class node {
        int data;
        node next;

        public node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static node head;
    public static node tail;

    public static node sort(node head) {
        node temp = head;
        int[] arr = new int[4];
        while (temp != null) {
            arr[temp.data]++;
            temp = temp.next;
        }
        node newHead = null, newTail = null;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                node newnode = new node(i);
                if (newHead == null) {
                    newHead = newTail = newnode;
                } else {
                    newTail.next = newnode;
                    newTail = newnode;
                }
                arr[i]--;
            }
        }
        return newHead;
    }

    public void print(node head) {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        sortLL LL = new sortLL();
        LL.head = new node(0);
        LL.head.next = new node(1);
        LL.head.next.next = new node(2);
        LL.head.next.next.next = new node(0);
        LL.head.next.next.next.next = new node(0);
        LL.head.next.next.next.next.next = new node(2);

        System.out.println("Before Sorting:");
        LL.print(LL.head);
        LL.head = LL.sort(LL.head);
        System.out.println("After Sorting:");
        LL.print(LL.head);
    }
}
