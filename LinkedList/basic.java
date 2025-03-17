package LinkedList;

public class basic {
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
    public static int size;
    //methods
    public void addFirst(int data){
    //create node    
    node newnode=new node(data);
    size++;
    if(head==null){
       head=tail=newnode;
       return;
    }
    //node storing next node address.
    newnode.next=head;
    head=newnode;
    }
    public void addLast(int data){
        node newnode=new node(data);
        size++;
        if(head==null){
            head=tail=newnode;
            return;
         }
         tail.next=newnode;
         tail=newnode;

    }
    public void addAtIndex(int idx,int data){
        node newnode=new node(data);
        node temp=head;
        int i=0;
        if(idx==0){
            addFirst(data);
            return;
        }
        size++;
        while(temp!=null){
            if(i==idx-1){
                newnode.next=temp.next;
                temp.next=newnode;
                temp=newnode;
            }
            temp=temp.next;
            i++;
        }
    }
    public void removeFirst(){
        if(size==0){
            System.out.println("LL is empty!");
        }
        else if(size==1){
            head=tail=null;
            size=0;
            return;
        }
        head=head.next;
        size--;
        return;
    }
    public void removeLast(){
        if(size==0){
            System.out.println("LL is empty!");
        }
        else if(size==1){
            head=tail=null;
            size=0;
            return;
        }
        int i=0;
        node prev=head;
        while(prev!=null){
            if(i==size-2){
                size--;
                prev.next=null;
                tail=prev;
                return;
            }
            i++;
            prev=prev.next;

        }

    }
    public int foundkeyPos(int key){
        node temp=head;
        for(int i=0;i<size;i++){
            if(key==temp.data){
                return i+1;
            }
            temp=temp.next;
        }
        return -1;
    }
    //reverse LL
    public void revrseLL(){
        node prev=null;
        node curr=tail=head;
        node next;
        while(curr!=null){
          next=curr.next;
          curr.next=prev;//reversing the link.
          prev=curr;
          curr=next;
        }
        head=prev;
    }
    //remove nth node from last.
    public void removeNthfromEnd(int n){
        node prev=head;
        int i=0;
        while(prev!=null){
            if(i==(size-1)-n){
                prev.next=prev.next.next;//2
                return;
            }
            prev=prev.next;
            i++;
        }

    }
    //find middle
    public node middleInd(node head) {
        node slow = head;
        node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;  // Move 2 step
        }
        return slow; 
    }
    
    // Check if linked list is a palindrome
    public boolean checkpalin() {
        if (head == null || head.next == null) {
            return true;
        }
    
        // Find middle node
        node middleI = middleInd(head);
    
        // Reverse the second half
        node prev = null;
        node curr = middleI;
        node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;  // Reverse link
            prev = curr;
            curr = next;
        }
    
        node right = prev;  // Right half 
        node left = head;   // Left half
    
        while (right != null) {
            if (left.data != right.data) {  
                return false;
            }
            left = left.next;
            right = right.next;
        }
    
        return true; 
    }
    
    public void Print(){
        if(head==null){
            System.out.println("LL is empty!");
        }
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("Null");
    }
    public static void main(String[] args) {
    basic LL=new basic();
    LL.addFirst(1);  
    LL.addLast(2);
    LL.addLast(100);
    LL.addLast(1);
    LL.Print(); 
    if(LL.checkpalin()){
       System.out.println("It is palindrome");
    }
    else{
        System.out.println("NOt a palindrome");
    }
    
        
    }
    
}
