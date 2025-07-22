package BinaryTrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BottomView {
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
    static class BinaryTree{
        static class Info{
            node node;
            int HD;

            Info(node node,int HD){
                this.node=node;
                this.HD=HD;
            }
        }
        public static void BottomView(node root){
            int min=0,max=0;
            Queue <Info> Q=new LinkedList<>();
            HashMap<Integer,node> map=new HashMap<>();
            Q.add(new Info(root, 0));
            Q.add(null);
            while(!Q.isEmpty()){
                Info curr=Q.remove();
                if(curr==null){
                    if(!Q.isEmpty()){
                        Q.add(null);
                    }
                }
                else{
                //checking key exist or not.
                    map.put(curr.HD,curr.node);
                if(curr.node.left!=null){
                    Q.add(new Info(curr.node.left,curr.HD-1));
                    min=Math.min(min,curr.HD-1);
                   
                }
                if(curr.node.right!=null){
                   Q.add(new Info(curr.node.right,curr.HD+1));
                   max=Math.max(max,curr.HD+1);
                }
            }
        }
            for(int i=min;i<=max;i++){
                System.out.println("key = "+i +", value = "+map.get(i).data);
            }
        }
        public static node buildTree(String[] arr) {
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

    }
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
        String nodes[]={"10","20","30","40","50","60"};
        node root=tree.buildTree(nodes);
        tree.BottomView(root);

    
}
}