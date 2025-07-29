//searching key in BST.
package BST;
import java.util.*;

import org.w3c.dom.Node;
public class searchInBST {
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
        if(arr.length==0||arr[0].equals("N")){
            return null;
        }
        
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
    public static boolean find(node root,int key){
         if(root==null){
            return false;
         }
         if(root.data==key){
            return true;
         }
         if(root.data>key){
            return find(root.left,key);
         }
         else{
            return find(root.right, key);
         }     
    }
    public static void main(String[] args) {
        String nodes[]={"6","2","8","N","N","7","9"};
        node root=buildT(nodes);
        int key=11;
        System.out.println(find(root,key));

    }
}
