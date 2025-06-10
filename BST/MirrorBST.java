//Making BST tree in mirror formed.
package BST;
public class MirrorBST {
    static class node{
          int data;
          node left;
          node right;

          node(int data){
            this.data=data;
          }
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
     public static void Inorder(node root){
        if(root==null){
            return ;
        }
        Inorder(root.left);
        System.out.print(" "+root.data);
        Inorder(root.right);
    }
    public static void MirrorBST(node root){
        if(root==null){
            return;
        }
        node temp=root.left;
        root.left=root.right;
        root.right=temp;
        MirrorBST(root.left);
        MirrorBST(root.right);
    }
    public static void main(String[] args) {
        int values[]={8,5,3,6,10,11};
        node root=null;
        for(int i=0;i<values.length;i++){
            root=insert(root,values[i]);
        }
        Inorder(root);
        System.out.println();
        System.out.println("Mirroring BST tree");
        MirrorBST(root);
        System.out.println();
        Inorder(root);

    }
    
}
