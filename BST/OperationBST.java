package BST;

public class OperationBST {
    static class node{
        int data;
        node left;
        node right;

        node(int data){
            this.data=data;
            //left and right node are by default are null.
        }
    }
    //insert
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
    //sorting
    public static void Inorder(node root){
        if(root==null){
            return ;
        }
        Inorder(root.left);
        System.out.print(" "+root.data);
        Inorder(root.right);
    }
    //search
    public static boolean search(node root,int key){//time-O(H).
        if(root==null){
            return false;
        }
         if(root.data==key){
            return true;
        }
        if(root.data>key){
            return search(root.left, key);
        }
        else{
            return search(root.right, key);
        }
        
    }
    //delete
    public static node Delete(node root,int target){
           if(root.data>target){
             root.left=Delete(root.left, target);
           }
           else if(root.data<target){
            root.right=Delete(root.right, target);
           }
           else{
                //case1
                if(root.left==null&&root.right==null){
                    return null;
                }
                //case 2-one child
                if(root.left==null){
                    return root.right;
                }
                else if(root.right==null){
                     return root.left;
                }
                //case 3-two child
                node IS=findInorderSuccessor(root.right);
                root.data=IS.data;//replace root data
                root.right=Delete(root.right, IS.data);//delete it    
           }
           return root;
    }
    public static node findInorderSuccessor(node root){
        if(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static void main(String[] args) {
        int values[]={5,1,3,4,2,7};
        node root=null;
        for(int i=0;i<values.length;i++){
            root=insert(root,values[i]);
        }
        Inorder(root);
        System.out.println();
        Delete(root, 1);
        int key=1;
        System.out.println(search(root,key));
        System.out.println();
    }
}

