package Queues;

public class CircularQueueArr {
    static class Queue {
        int arr[];
        int rear;
        int size;
        int front;

        Queue(int n) {
            arr = new int[n];
            rear = -1;
            size = n;
            front = -1;
        }

        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public void add(int data) {
            if ((rear + 1) % size == front) {
                System.out.println("QUEUE IS FULL!");
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public void remove() {
            if (isEmpty()) {
                System.out.println("QUEUE IS EMPTY!");
                return;
            }
            int result = arr[front];
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("QUEUE IS EMPTY!");
                return -1;
            } else {
                return arr[front];
            }
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.remove();
        q.add(5);
        q.add(6);
        q.add(7); 
        q.add(8);// should show "QUEUE IS FULL!"
        while (!q.isEmpty()) {
            System.out.print(" " + q.peek());
            q.remove();
        }
    }
}
