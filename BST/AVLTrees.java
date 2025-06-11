//self balncing tree.
package BST;
public class AVLTrees{
    static class node{
        int data,height;
        node left,right;

        public node(int data){
            this.data=data;
            height=1;
        }
    }
    public static node root;
    //height calculation function
    public static int height(node root){
        if(root==null){
            return 0;
        }
        return root.height;
    }
    //balanced factor function
    public static int balancedFactor(node root){
        if(root==null){
            return 0;
        }
        return height(root.left)-height(root.right);
    }
    //max height function
    public static int max(int a,int b){
            return (a>b) ? a : b;
    }
    //left rotation function
    public static node leftRotate(node x){
        node y=x.right;
        node T=y.left;
        //rotation
        y.left=x;
        x.right=T;
        //update heights
        x.height=max(height(x.left),height(x.right))+1;
        y.height=max(height(y.left),height(y.right))+1;

        return y;//new root
    }
     //right rotation
     public static node rightRotate(node y){
        node x=y.left;
        node T=x.right;
        //rotation
        x.right=y;
        y.left=T;
        //update heights
        y.height=max(height(y.left),height(y.right))+1;
        x.height=max(height(x.left),height(x.right))+1;

        return x;//new root
    }
    public static node insert(node root,int key){
        if(root==null){
            return new node(key);
        }
        if(key<root.data){
            root.left=insert(root.left,key);
        }
        else if(key>root.data){
            root.right=insert(root.right, key);
        }
        else{
            return root;//no duplicate key
        }
        //update root height
        root.height=Math.max(height(root.left),height(root.right))+1;
        //get balance factor
        int bf=balancedFactor(root);
        
        //LL CASE
        if(bf>1&&key<root.left.data){
            return rightRotate(root);
        }
        //RR CASE
        if(bf<-1&&key>root.right.data){
            return leftRotate(root);
        }
        //LR CASE
        if(bf>1&&key>root.left.data){
            root.left=leftRotate(root.left);
            return rightRotate(root);
        }
        //RL CASE
        if(bf<-1&&key<root.right.data){
            root.right=rightRotate(root.right);
            return leftRotate(root);
        }
        return root;

    }
    public static void preoder(node root){
        if(root==null){
            return;
        }
        System.out.print(" "+root.data);
        preoder(root.left);
        preoder(root.right);
    }
    public static void main(String[] args) {
        root=insert(root,10);
        root=insert(root,20);
        root=insert(root,30);
        root=insert(root,40);
        root=insert(root,50);
        root=insert(root,25);
         //Expected AVL TREE
            //       30
            //      /  \
            //     20   40
            //    / \    \
            //   10  25    5 
        preoder(root);
        System.out.println(root.data);


    }
}