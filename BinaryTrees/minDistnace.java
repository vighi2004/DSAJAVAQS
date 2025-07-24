//finding minimum distance between two nodes
package BinaryTrees;
import java.util.*;
public class minDistnace{
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
   public static int i = -1;

    public static node buildT(int[] nodes) {
        i++;
        if (nodes[i] == -1) {
            return null;
        }
        node newnode = new node(nodes[i]);
        newnode.left = buildT(nodes);
        newnode.right = buildT(nodes);
        return newnode;
    }
    public static int minDist(node root,int a,int b){
        ArrayList <Integer> path1=new ArrayList<>();
        ArrayList <Integer> path2=new ArrayList<>();
        getPath(path1,root,a);
        getPath(path2,root,b);
        int i = 0;
        while (i < path1.size() && i < path2.size()) {
            if (!path1.get(i).equals(path2.get(i))) break;
            i++;
        }
        return (path1.size()-i)+(path2.size()-i);
    }
    public static boolean getPath(ArrayList <Integer>path,node root,int dest){
        if(root==null){
            return false;
        }
         path.add(root.data);
        if(root.data==dest){
            return true;
        }
       if (getPath(path, root.left, dest) || getPath(path, root.right, dest))
    return true;

        path.remove(path.size()-1);
        return false;
    }
    public static void main(String[] args) {
         int nodes[] = {1, 2, -1, -1, 3, -1, -1};
        int a=2;
        int b=3;
        node root=buildT(nodes);
        System.out.println(minDist(root,a,b));
    }
}