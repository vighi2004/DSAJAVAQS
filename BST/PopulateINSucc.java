//populate inorder succesor of given BST.
package BST;
import java.util.*;
public class PopulateINSucc {
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
    public static node prev=null;
    public static void populate(node root){
       if(root==null){
        return;
       }
       populate(root.left);
       if(prev!=null){
        System.out.print(prev.data+"->"+root.data+" ");
       }
       prev=root;
       populate(root.right);
    }
    public static void main(String[] args) {
        String nodes[]={"10", "8", "12", "3", "N", "N","N"};
        node root=buildT(nodes);
        populate(root);
       
    }    
}

