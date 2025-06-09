//finding all paths from root to leaf using arraylist data structure.
package BST;
import java.util.ArrayList;
public class Root2Leaf {
    static class node{
        int data;
        node right;
        node left;

        node(int data){
            this.data=data;
    
        }
    }
     public static void Inorder(node root){
        if(root==null){
            return ;
        }
        Inorder(root.left);
        System.out.print(" "+root.data);
        Inorder(root.right);
    }
     public static node insert(node root,int val){
        if(root==null){
            root=new node(val);
            return root;
        }
        if(root.data>val){
           root.left=insert(root.left, val);
        }
        else{
            root.right=insert(root.right, val);
        }
        return root;
    }
    public static void path(node root,ArrayList <Integer> arr){
           if(root==null){
             return;
           }
           arr.add(root.data);
           //at leaf node
           if(root.left==null&&root.right==null){
            System.out.print("path");
             for(int i=0;i<arr.size();i++){
                System.out.print("->"+arr.get(i));
            }
            System.out.println();
           }
            path(root.left,arr);
            path(root.right,arr);
            arr.remove(arr.size()-1);
        

    }
    public static void main(String[] args) {
         int values[]={8,5,3,6,10,11,14};
        node root=null;
        for(int i=0;i<values.length;i++){
            root=insert(root,values[i]);
        }
        //Inorder(root);
        ArrayList <Integer> arr=new ArrayList<>();
        path(root,arr);
    }
    
}
