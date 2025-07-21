//check whether leaf is at same level in all .
package BinaryTrees;
import java.util.*;
public class LeafAtSame {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node buildTree(String[] arr) {
        if (arr.length == 0 || arr[0].equals("N")) return null;

        Node root = new Node(Integer.parseInt(arr[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();

            // Left child
            if (!arr[i].equals("N")) {
                current.left = new Node(Integer.parseInt(arr[i]));
                queue.add(current.left);
            }
            i++;
            if (i >= arr.length) break;

            // Right child
            if (!arr[i].equals("N")) {
                current.right = new Node(Integer.parseInt(arr[i]));
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static boolean checkLeaf(Node root){
        int leafNode=-1;
        int level=0;
        Queue <Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                Node curr=q.remove();
                if(curr.left==null&&curr.right==null){
                    //compare
                    if(leafNode==-1){
                        leafNode=level;
                    }
                    else if(leafNode!=level){
                        return false;
                          
                    }
                }
                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                    if(curr.right!=null){
                        q.add(curr.right);
                    }
                }
            
            level++;
        }
        return true;

    }

    public static void main(String[] args) {
        String[] input = {"10", "20", "30", "N", "N"};
        Node root = buildTree(input);
        // System.out.print("Inorder: ");
        // inorder(root);
        System.out.println(checkLeaf(root));
    }
}
