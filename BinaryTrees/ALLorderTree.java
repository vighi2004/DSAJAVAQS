package BinaryTrees;
public class ALLorderTree {
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
        static int idx=-1;
       public static node BuildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            node newNode=new node(nodes[idx]);
            newNode.left=BuildTree(nodes);
            newNode.right=BuildTree(nodes);
            return newNode;
    }
    //preorder O(n)
    public static void preorder(node root){
        if(root==null){
            System.out.print(" "+"-1"+" ");
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    //Inorder tree O(n).
    public static void Inorder(node root){
        if(root==null){
            return;
        }
        Inorder(root.left);
        System.out.print(root.data);
        Inorder(root.right);
    }
    //post order
    public static void postorder(node root){
     if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data);
    }
}
    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree=new BinaryTree();
        node root=tree.BuildTree(nodes);
        //System.out.println(root.data);
        System.out.println("PRE-ORDER");
        tree.preorder(root);
        System.out.println();
        System.out.println("IN-ORDER");
        tree.Inorder(root);
        System.out.println();
        System.out.println("POST-ORDER");
        tree.postorder(root);
    }
}
