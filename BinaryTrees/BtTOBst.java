//number of swap required to convert BT to BST.
package BinaryTrees;
public class BtTOBst {
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
    public static int idx=-1;
    public static node buildT(int arr[]) {
        idx++;
        if(arr[idx]==-1){
            return null;
        }
        node newnode=new node(arr[idx]);
        newnode.left=buildT(arr);
        newnode.right=buildT(arr);
        return newnode;
    }
    public static int checkSwap(int arr[],int arr1[]){
        int swap=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==arr1[i]){
                continue;
            }
            else{
                swap++;
                for(int j=i+1;j<arr1.length;j++){
                    if(arr[j]==arr[i]){
                          int temp=arr[i];
                          arr1[j]=arr1[i];
                          arr1[i]=temp;
                    }
                }
            }
        }
        return swap;
    }
    public static int index=0;
    public static void inorder(node root,int arr1[]){
        if(root==null){
            return ;
        }
        inorder(root.left,arr1);
        arr1[index++]=root.data;
        inorder(root.right,arr1);
    }
    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 8, 9, 10, 11};
        node root=buildT(arr);
        int arr1[]=new int[arr.length];
        inorder(root,arr1);
        System.out.println("no. of swaps required:-"+checkSwap(arr,arr1));
    }
    
}
