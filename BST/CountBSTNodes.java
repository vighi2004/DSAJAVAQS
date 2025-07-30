//count  nodes in BST which lie in given range.
package BST;
import java.util.LinkedList;
import java.util.Queue;
public class CountBSTNodes {
    static class node{
        int data;
        node left;
        node right;

        public node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        } 
    }
    public static node buildT(String arr[]){
        if (arr.length == 0 || arr[0].equals("N")) return null;

        node root = new node(Integer.parseInt(arr[0]));
        Queue<node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            node current = queue.poll();

            // Left child
            if (!arr[i].equals("N")) {
                current.left = new node(Integer.parseInt(arr[i]));
                queue.add(current.left);
            }
            i++;
            if (i >= arr.length) break;

            // Right child
            if (!arr[i].equals("N")) {
                current.right = new node(Integer.parseInt(arr[i]));
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }
    public static int countN(node root,int in,int ex){
        if(root==null){
            return 0;
        }
        if(root.data>=in&&root.data<=ex){
            return 1+countN(root.left, in, ex) + countN(root.right, in, ex);
        }
        else if(root.data<in){
             return countN(root.right, in, ex);
        }
        else{
             return countN(root.left, in, ex);
        }

    }
    public static void main(String[] args) {
        String nodes[]={"10", "5", "50", "1", "N", "40","10"};
        int l=5;
        int h=45;
        node root=buildT(nodes);
        countN(root,l,h);
        System.out.println("Nodes lie in the range:- "+countN(root, l, h));
    }
    
}
