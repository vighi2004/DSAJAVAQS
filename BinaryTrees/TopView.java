//printing top view of tree using hashmaps.
package BinaryTrees;
import java.util.*;
public class TopView {
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
        public static void TopView(node root){
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
                if(!map.containsKey(curr.HD)){
                    map.put(curr.HD,curr.node);
                }
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
        }}
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
                //   1
                //  / \
                // 2   3
                //  \
                //   4
                //    \
                //     5
                //      \
                //       6
        node root=new node(1);
        root.left=new node(2);
        root.right=new node(3);
        root.left.right=new node(4);
        root.left.right.right=new node(5);
        root.left.right.right.right=new node(6);
        tree.TopView(root);
    }
    
}
