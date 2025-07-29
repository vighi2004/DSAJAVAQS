//searching key in BST.
package BST;
import java.util.*;
public class preAndSuccOfBST{
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
    public static void findPS(node root,int key){
         if(root==null){
            return;
         }
         if(root.data==key){
             if(root.left!=null){
             node precedor=prece(root.left);
              System.out.println("precedor is: "+precedor.data);
             }
             else{
                 System.out.println("precedor is: "+"-1");
             }
             if(root.right!=null){
             node succesor=succ(root.right);
             System.out.println("successor is; "+succesor.data);
             }
             else{
                System.out.println("successor is; "+"-1");
         }
             }
         if(root.data>key){
            findPS(root.left, key);
         }
         if(root.data<key){
            findPS(root.right, key);
         }
    }
    public static node prece(node root){
        if(root.right==null){
            return root;
        }
        return prece(root.right);
    }
    public static node succ(node root){
        if(root.left==null){
            return root;
        }
        return succ(root.left);
    }
    public static void main(String[] args) {
        String nodes[]={"8","1","9","N","4","N","10","3","N","N","N"};
        node root=buildT(nodes);
        int key=8;
        findPS(root,key);

    }
}
