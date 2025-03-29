//swapping LL
package LinkedList;

public class swap {
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
    public void swap(int X, int Y) {
        if (X == Y) {
        return; 
        }
    
        node prevX = null, currX = head;
        node prevY = null, currY = head;
    
        // Find currX and its previous node prevX
        while (currX != null && currX.data != X) {
            prevX = currX;
            currX = currX.next;
        }
    
        // Find currY and its previous node prevY
        while (currY != null && currY.data != Y) {
            prevY = currY;
            currY = currY.next;
        }
    
        // If X or Y is not found, return
        if (currX == null || currY == null) return;
    
        // If X is not the head, update prevX.next
        if (prevX != null) {
            prevX.next = currY;
        } else { 
            head = currY;
        }
    
        // If Y is not the head, update prevY.next
        if (prevY != null) {
            prevY.next = currX;
        } else { 
            head = currX;
        }
    
        // Swap next pointers of currX and currY
        node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
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
        swap LL=new swap();
        LL.head =new node(1);
        LL.head.next=new node(2);
        LL.head.next.next=new node(3);
        LL.head.next.next.next=new node(4);
        LL.print(head);
        int X=2;
        int Y=4;
        LL.swap(X,Y);
        LL.print(head);

        
    }
}

