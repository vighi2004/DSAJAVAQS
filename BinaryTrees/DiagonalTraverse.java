//print diagonal traversal of tree.
package BinaryTrees;
import java.util.*;
public class DiagonalTraverse {
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
    public static HashMap<Integer,List<Integer>> hm=new HashMap<>();
    public static void  digonalT(node root,int level){
        if(root==null){
            return;
        }
        List<Integer> currentDiagonalList = hm.computeIfAbsent(level, k -> new ArrayList<>());
        currentDiagonalList.add(root.data);
        digonalT(root.left,level+1);
        digonalT(root.right,level);
    }
    public static void main(String[] args) {
        int level=0;
        String nodes[]={"8","3","10","1","6","N","14","N","N","4","7","13","N"};
        node root=buildTree(nodes);
        digonalT(root, level);
         for (Map.Entry<Integer, List<Integer>> entry : hm.entrySet()) {
            System.out.println("Diagonal " + entry.getKey() + ": " + entry.getValue()); 
        } 
        
    }
}
