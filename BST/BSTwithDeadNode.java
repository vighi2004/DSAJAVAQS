//finding dead node that os leaf node whether we can inserte node which value is greater than 0 and o duplicate.
package BST;

import java.util.LinkedList;
import java.util.Queue;

public class BSTwithDeadNode {
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
    public static boolean findDead(node root,int min,int max){
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null){
            if(min==max){
                return true;
            }
        }
        return findDead(root.left,min,root.data-1)||findDead(root.right, root.data+1, max);
    }
    public static void main(String[] args) {
        String nodes[]={"8", "5", "9", "2", "7", "N", "N", "1"};
        node root=buildT(nodes);
        System.out.println(findDead(root,1,Integer.MAX_VALUE));
    }
}
