//swapping even and odd in different side.
package LinkedList;

public class EvenOdd {
    public static class node{
        int data;
        node next;
        public node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static node head;
    //swaping logic.
    public void EvenOdd(node head) {
        if (head == null) return; 
    
        node evenStart = null, evenEnd = null;
        node oddStart = null, oddEnd = null;
        node current = head;
        while (current != null) {
            int value = current.data;
            if (value % 2 == 0) { // Even number
                if (evenStart == null) {
                    evenStart = evenEnd = current;
                } else {
                    evenEnd.next = current;
                    evenEnd = evenEnd.next;
                }
            } else { // Odd number
                if (oddStart == null) {
                    oddStart = oddEnd = current;
                } else {
                    oddEnd.next = current;
                    oddEnd = oddEnd.next;
                }
            }
            current = current.next;
        }
    
        // Step 2: Connect even list with odd list
        if (evenStart == null || oddStart == null) {
            return; // No changes needed if only one type exists
        }
    
        evenEnd.next = oddStart;
        oddEnd.next = null; // Ensure last node points to null
    
        // Step 3: Update head to new even-started list
        head = evenStart;
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
        EvenOdd LL=new EvenOdd();
        LL.head =new node(8);
        LL.head.next=new node(12);
        LL.head.next.next=new node(10);
        LL.head.next.next.next=new node(5);
        LL.head.next.next.next.next=new node(4);
        LL.head.next.next.next.next.next=new node(1);
        LL.head.next.next.next.next.next.next=new node(6);
        LL.print(head);
        LL.EvenOdd(head);
        LL.print(head);

        
    }
}

