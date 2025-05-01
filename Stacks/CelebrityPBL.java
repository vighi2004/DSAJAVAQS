
import java.util.Stack;
public class CelebrityPBL {
    public static int check(Stack<Integer> S, int mat[][]) {
        if(S.size()==1){
            return 0;
        }
        while (S.size() >= 2) {
            int A = S.pop();
            int B = S.pop();
            if (mat[A][B] == 1) {
                S.push(B);
            } else {
                S.push(A);
            }
        }

        if (S.size() == 1) {
            int top = S.peek();
            boolean KnowsNo = true;
            boolean KnowsAll = true;
            for (int i = 0; i < mat.length; i++) {
                if (i != top && mat[top][i] == 1) {
                    KnowsNo = false;
                    break;
                }
            }

            for (int i = 0; i < mat.length; i++) {
                if (i != top && mat[i][top] == 0) {
                    KnowsAll = false;
                    break;
                }
            }

            if (KnowsNo && KnowsAll) {
                return top;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Stack<Integer> S = new Stack<>();
        int mat[][] = {{1,1},{1,1}}; 
        for (int i = mat.length - 1; i >= 0; i--) {
            S.push(i);
        }
        System.out.println(check(S, mat)); 
    }
}
