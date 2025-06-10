//Building BST of sorted array.
package BST;
public class SortArrBST {
    static class node{
        int data;
        node left;
        node right;

        node(int data){
            this.data=data;
        }
    }
    public static node insert(int val[],int start,int end){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2; 
        node root=new node(val[mid]);
        root.left= insert(val,start,mid-1);
        root.right=insert(val,mid+1,end);
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
    public static void main(String[] args) {
        int values[]={3,5,6,8,10,11,12};
        node root=insert(values,0,values.length-1);
        Inorder(root);
        System.out.println();
    }
    
}
