//implementing queue using static array.But we should not implement beacuse remove takes O(N).
package Queues;
public class usingArray {
    static class Queue{
        int arr[];
        int rear;
        int size;
        Queue(int n){
            arr=new int[n];
            rear=-1;
            size=n;
        }
        public  boolean isEmpty(){
            return rear==-1;
        }
        public  void add(int data){
            if(rear==size-1){
                 System.out.println("QUEUE IS FULL!");
                 return;
            }
            rear=rear+1;
            arr[rear]=data;
        }
        //remove
        public void remove(){
            if(rear==-1){
                System.out.println("QUEUE IS EMPTY!");
                return;
            }
            rear=rear-1;
            int front=arr[0];
            for(int i=0;i<=rear;i++){
                arr[i]=arr[i+1];
            }
            return ;
        }
        public int peek(){
            if(rear==-1){
                return -1;
            }
            else{
                return arr[0];
            }
        }

    }
    public static void main(String[] args) {
        Queue q=new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.remove();
        while(!q.isEmpty()){
            System.out.print(" "+q.peek());
            q.remove();
        }
        

    }
    
}
