//printing zigzag view
import java.util.*;
public class Main {
    static class node {
        int data;
        node left;
        node right;

        public node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static node BuildTree(int nodes[]) {
            idx++;
            if (idx >= nodes.length || nodes[idx] == -1) {
                return null;
            }
            node newnode = new node(nodes[idx]);
            newnode.left = BuildTree(nodes);
            newnode.right = BuildTree(nodes);
            return newnode;
        }

        public static node buildTreeWrapper(int nodes[]) {
            idx = -1;
            return BuildTree(nodes);
        }
    }

    public static void printzigzagView(node root) {
       ArrayList <Integer> arr=new ArrayList<>(); 
        if (root == null)
            return;
         
        Queue<node> q = new LinkedList<>();
        q.add(root);
        int level=1;
        int prev=root.data;
        while (!q.isEmpty()) {
            int n = q.size();
            ArrayList <Integer> inarr=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                node curr = q.poll();
                inarr.add(curr.data);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            if(level%2!=0){  //even so right to left view.
              for(int i=0;i<n;i++){
                  arr.add(inarr.get(i));
              }
                
            }
            else{
                 for(int i=n-1;i>=0;i--){//odd so left to right view.
                  arr.add(inarr.get(i));
              }
            }
            level++;
        }
        for(int i=0;i<arr.size();i++){
            System.out.print(" "+arr.get(i));
        }
        
    }


    public static void main(String[] args) throws Exception {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        node root = BinaryTree.buildTreeWrapper(nodes);

        System.out.println("Printing zigzag view:");
        printzigzagView(root);
    }
}
