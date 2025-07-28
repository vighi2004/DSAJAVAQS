//find k sum path in Binary Tree.//have to solve....
package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

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
    public static int findpath(node root,StringBuilder str){
            if(root==null){
                return 0;
            }
            int left=findpath(root.left, str.append(root.data));
            int right=findpath(root.right, str.append(root.data));
            if((root.data+left+right)==5){
                System.out.println(str.toString());
            }
            str.deleteCharAt(str.length()-1);
            return root.data;
    }
    public static void main(String[] args) {
        String nodes[]={"1","3","-1","2","1","4","5","N","N","1","N","1","2","N","6"};
        node root=BuildT(nodes);
        StringBuilder str=new StringBuilder();
        findpath(root,str);
        
    }
    
}
