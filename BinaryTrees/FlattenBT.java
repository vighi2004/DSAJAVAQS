//making flatten BT like LL with time-O(n) and space-O(1).
package BinaryTrees;
import java.util.*;
public class FlattenBT {
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
    public static node builT(String arr[]){
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
    public static void flat(node root){
        node curr=root;
        while(curr!=null){
            if(curr.left!=null){
               node pred=findP(curr.left);
               pred.right=curr.right;
               curr.right=curr.left;
               curr.left=null;
            }
            curr=curr.right;
        }
    }
    public static node findP(node root){
        while(root.right!=null){
            root=root.right;
        }
        return root;
    }
    public static void main(String[] args) {
        String nodes[]={"1","2","5","3","4","N","6"};
        node root=builT(nodes);
        flat(root);
    }  
}
