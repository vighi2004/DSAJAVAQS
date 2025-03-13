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
    LL.addLast(3);
    LL.addLast(4); 
    LL.addAtIndex(2,5);
    LL.Print();
    System.out.println("founding key...");
    System.out.println("found at position :"+LL.foundkeyPos(32));
        
    }
    
}
