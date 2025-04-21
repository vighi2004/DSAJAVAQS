//substrcting  2 LL and result making in LL form.
package LinkedList;
public class subtract2LL {
    public static class node {
        int data;
        node next;

        public node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public  node head;
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
    public static int subtract(node first,node second){
        int mod=1000000007;
        int num1=0;
        int num2=0;
        while(first!=null){
            num1=((num1*10)+first.data)%mod;
            first=first.next;
        }
        while(second!=null){
            num2=((num2*10)+second.data)%mod;
            second=second.next;
        }
        return (num1-num2);
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
        subtract2LL LL1=new subtract2LL();
        subtract2LL LL2=new subtract2LL();
        subtract2LL resLL=new subtract2LL();
        LL1.head = new node(1);
        LL1.head.next = new node(0);
        LL1.head.next.next = new node(0);
        LL2.head = new node(1);
        int number=subtract(LL1.head,LL2.head); 
        resLL.head = null;
        node tail = null;

        while (number != 0) {
        int n = number % 10;
         node newNode = new node(n);

        if (resLL.head == null) {
        resLL.head = newNode;
        tail = newNode;
        }
        else {
        tail.next = newNode;
        tail = newNode;
         }

         number = number / 10;
        }  
        resLL.head=reverse(resLL.head);
        printList(resLL.head); 

    }
    
}
