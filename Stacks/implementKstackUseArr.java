//implementing K stacks in arrays and putting operation push ,pop,also managing stack size .
public class implementKstackUseArr {
    public static class StackArr {
        int n = 10;
        int k = n / 2;
        int[][] stacks = new int[k][n / k];
        int[] top = new int[k];

        // Constructor to initialize top[]
        StackArr() {
            for (int i = 0; i < k; i++) {
                top[i] = -1;
            }
        }

        public void push(int data, int i) {
            if (top[i] < n / k - 1) {
                top[i]++;
                stacks[i][top[i]] = data;
            } else {
                System.out.println("Stack " + i + " overflow");
            }
        }

        public void pop(int i) {
            if (top[i] >= 0) {
                int popped = stacks[i][top[i]];
                top[i]--;
                System.out.println("Popped from stack " + i + ": " + popped);
            } else {
                System.out.println("Stack " + i + " underflow");
            }
        }
    }

    public static void main(String[] args) {
        StackArr S = new StackArr();

        // Sample usage
        S.push(10, 0); 
        S.push(20, 0);  
        S.push(30, 1);  
        S.pop(0);       
        S.pop(1);      
        S.pop(1);       
    }
}
