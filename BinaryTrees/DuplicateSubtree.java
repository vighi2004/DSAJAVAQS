//find dupliactes subtree using hashmap.
package BinaryTrees;
import java.util.HashMap;
public class DuplicateSubtree {
    static class node{
        int data;
        node left;
        node right;

        node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree{
        public static void DuplicateTravese(node root){
            HashMap<String, Integer> map = new HashMap<>();
            serialize(root, map);
            for(String key: map.keySet()){
               if(map.get(key)>=2){ 
               System.out.println("Duplicates nodes are: "+key+": "+map.get(key)+" times");
               }
            }

        }
        public static String serialize(node root,HashMap<String,Integer> map){
             if (root == null) return "#";
             //#=null;
            String left = serialize(root.left, map);
            String right = serialize(root.right, map);
            String key = root.data + "," + left + "," + right;
            map.put(key, map.getOrDefault(key, 0) + 1);
            return key;
 


        }
    }
    public static void main(String[] args) {
         BinaryTree tree=new BinaryTree();
            //        1
            //      /    \
            //     4      3
            //    /      / \
            //   3      4  3
            //         /
            //        3
        node root=new node(1);
        root.left=new node(4);
        root.right=new node(3);
        root.left.left=new node(3);
        root.right.left=new node(4);
        root.right.right=new node(3);
        root.right.left.left=new node(3);
        tree.DuplicateTravese(root);
        
    }
    
}
