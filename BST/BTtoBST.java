//converting BT to BST.
package BST;
import java.util.*;
public class BTtoBST {
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
    public static node TOBST(ArrayList <Integer> arr,int start,int end){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        node newnode=new node(arr.get(mid));
        newnode.left=TOBST(arr, start, mid-1);
        newnode.right=TOBST(arr,mid+1, end);
        return newnode;
    }
    public static void preOrder(node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    } 
    public static void  arrayFill(node root,ArrayList<Integer> arr){
          if(root==null){
            return;
        }
        arr.add(root.data);
        arrayFill(root.left,arr);
        arrayFill(root.right,arr);
    }
    public static void main(String[] args) {
     String nodes[]={"1","2","3"};
     ArrayList <Integer> arr=new ArrayList<>();
     node root=buildT(nodes);
     System.out.println("BT Tree:-");
     preOrder(root);
     System.out.println();
     arrayFill(root, arr);
     Collections.sort(arr);
     System.out.println("BST Tree:-");
     node root1=TOBST(arr,0,arr.size()-1);
     preOrder(root1);
    }
}
