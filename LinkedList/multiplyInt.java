//multiply two number which are form by LL.
package LinkedList;
public class multiplyInt {
    public static class node{
        int data;
        node next;
        public node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public node head;
    public static int multiply(node first,node second){
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
        return (num1*num2);
    }
    public static void main(String[] args) {
        multiplyInt LL1=new multiplyInt();
        multiplyInt LL2=new multiplyInt();
        //first LL
        LL1.head=new node(1);
        LL1.head.next=new node(0);
        LL1.head.next.next=new node(0);
        //second LL
        LL2.head=new node(1);
        LL2.head.next=new node(0);
        System.out.println(multiply(LL1.head,LL2.head));
        
    }
    
}
