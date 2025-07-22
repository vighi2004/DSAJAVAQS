//Build Bt using preoerder and inorder.
package BinaryTrees;

import java.util.HashMap;

public class BuildBT {
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
    public static int preorderIdx=0;
    public static HashMap<Integer,Integer> Inhm=new HashMap<>();
    public static node buildTree(int preorder[],int inorder[]){
        for(int i=0;i<inorder.length;i++){
            Inhm.put(inorder[i],i);
        }
        return build(preorder,0,inorder.length-1);
    }
    public static node build(int preorder[],int left,int right){
        //base
        if(left>right){
            return null;
        }
        int root=preorder[preorderIdx++];
        node newnode=new node(root);
        int inorderIdx=Inhm.get(root);
        newnode.left=build(preorder, left, inorderIdx-1);
        newnode.right=build(preorder, inorderIdx+1, right);
        return newnode;
        
    }
    public static void main(String[] args) {
        int preorder[]={3,9,20,15,7};
        int inorder[]={9,3,15,20,7};
        node root=buildTree(preorder,inorder);
        System.out.println(root.data);
    }
    
}
