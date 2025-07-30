//find k sum path in Binary Tree.
package BinaryTrees;
import java.util.*;
public class KSumPath {
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
    public static node BuildT(String arr[]){
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
    public static void findpath(node root,int k){
        ArrayList <Integer> arr=new ArrayList<>();
        helper(root,arr,k);
    }
    public static void helper(node root,ArrayList <Integer> arr,int k){
        if(root==null){
            return;
        }
        arr.add(root.data);
        int sum=0;
        for(int i=arr.size()-1;i>=0;i--){
            sum+=arr.get(i);
            if(sum==k){
                for(int j=i;j<arr.size();j++){
                    System.out.print(" "+arr.get(j));
                }
                System.out.println();
            }
        }
        helper(root.left, arr, k);
        helper(root.right, arr, k);
        arr.remove(arr.size()-1);
    }
    public static void main(String[] args) {
        String nodes[]={"1","3","-1","2","1","4","5","N","N","1","N","1","2","N","6"};
        node root=BuildT(nodes);
        int k=5;
        StringBuilder str=new StringBuilder();
        findpath(root,k);
        
    }
    
}
