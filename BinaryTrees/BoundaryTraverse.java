//boundary traversal.
package BinaryTrees;
import java.util.*;
public class BoundaryTraverse {
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
    public static void boundaryT(Node root){
        ArrayList <Integer> res=new ArrayList<>();
        if(root!=null){
            res.add(root.data);
        }
        Stack <Integer> s=new Stack<>();
        leftT(root,res);
        leafT(root,res);
        rightT(root,res.get(0),s);
        //reverse stack ouptut
        while(!s.isEmpty()){
            res.add(s.pop());
        }
        //print
        System.out.println("Boundary traversal:-");
        for(int i=0;i<res.size();i++){
            System.out.print(" "+res.get(i));
        }
    }
    public static void leftT(Node root,ArrayList <Integer> left){
        Node curr=root.left;
        while(curr!=null){
            if(curr.left!=null&&curr.right!=null){
              left.add(curr.data);
           }
           if(curr.left!=null){
              curr=curr.left;
           }
           else{
              curr=curr.right;
           }   
         }
    }
    public static void leafT(Node root,ArrayList <Integer> leaf){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            leaf.add(root.data);
        }
        if(root.left!=null){
            leafT(root.left, leaf);
        }
        if(root.right!=null){
            leafT(root.right, leaf);
        }
    }
    public static void rightT(Node root,int n,Stack<Integer> s){
        Node curr=root.right;
        while(curr!=null){
            if(curr.left!=null&&curr.right!=null){
              s.push(curr.data);
           }
           if(curr.right!=null){
              curr=curr.right;
           }
           else{
              curr=curr.left;
           }   
         }
    }
    public static void main(String[] args) {
        String[] input = {"1","2","3","4","5","6","7","N","N","8","9","N","N","N","N"};
        Node root = buildTree(input);
        boundaryT(root);

    }
}
