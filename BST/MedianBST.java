//finding median of BST.
package BST;
public class MedianBST {
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
    public static void countN(node root){
        node curr=root;
        int count=0;
        while(curr!=null){
            if(curr.left==null){
                count++;
                curr=curr.right;
            }
            else{
                node pred=findP(curr.left,curr);
                if(pred.right==null){
                    pred.right=curr;
                    curr=curr.left;
                }
                else{
                    pred.right=null;
                    count++;
                    curr=curr.right;
                }
            }
        }
        median(root,count);

    }
    public static node findP(node root,node curr){
        while(root.right!=null&&root.right!=curr){
            root=root.right;
        }
        return root;
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
    public static void median(node root,int nodes){
        if(nodes%2==0){
            int n1=findEle(root,nodes/2);
            int n2=findEle(root,((nodes/2)+1));
            System.out.print("Nodes are Even so median are:-"+n1+" "+n2);
        }
        else{
            int n1=findEle(root,nodes/2);
             System.out.print("Nodes are odd so median is:- "+n1);
        }
    }
    public static int  findEle(node root,int k){
        int data=0;
        node curr=root;
        int count=0;
        while(curr!=null){
            if(curr.left==null){
                if(count==k){
                      data=curr.data;
                    }
                count++;
                curr=curr.right;
            }
            else{
                node pred=findP(curr.left,curr);
                if(pred.right==null){
                    pred.right=curr;
                    curr=curr.left;
                }
                else{
                    pred.right=null;
                    if(count==k){
                      data=curr.data;
                    }
                    count++;
                    curr=curr.right;
                }
            }
        }
        return data;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,6,7,8,9};
        node root=builT(arr, 0, arr.length-1);
        countN(root);
    }
    
}
