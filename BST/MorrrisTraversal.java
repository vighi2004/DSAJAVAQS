//performing morris inoder traversal time-O(n)an spsace O(1).
package BST;
public class MorrrisTraversal {
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
    public static node builT(int arr[],int start,int end){
          if(start>end){
            return null;
          }
          int mid=(start+end)/2;
          node newnode=new node(arr[mid]);
          newnode.left=builT(arr, start, mid-1);
          newnode.right=builT(arr, mid+1, end);
          return newnode;
    }
    //morris traversal
    public static void morrisT(node root){
        node curr=root;
        while(curr!=null){
            if(curr.left==null){
                System.out.print(" "+curr.data);
                curr=curr.right;
            }
            else{
                node pred=findpred(curr.left,curr);
                if(pred.right==null){
                    pred.right=curr;
                    curr=curr.left;
                }
                else{
                    pred.right=null;//delete
                    System.out.print(" "+curr.data);
                    curr=curr.right;
                }
            }
        }
    }
    public static node findpred(node root,node curr){
        while(root.right!=null&&root.right!=curr){
            root=root.right;
        }
        return root;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        node root=builT(arr,0,arr.length-1);
        morrisT(root);
    }
}
