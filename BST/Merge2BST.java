//merging 2 BST and forming balanced  BST.Time-O(N+M)
package BST;

import java.util.ArrayList;

public class Merge2BST {
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
    public static void sortArr1(node root1,ArrayList <Integer> sort1){
          if(root1==null){
             return;
          }
          sortArr1(root1.left,sort1);
          sort1.add(root1.data);
          sortArr1(root1.right,sort1);
    }
     public static void sortArr2(node root2,ArrayList <Integer> sort2){
          if(root2==null){
             return;
          }
          sortArr2(root2.left,sort2);
          sort2.add(root2.data);
          sortArr2(root2.right,sort2);
    }
    public static node insert(ArrayList <Integer> sortArr,int start,int end){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2; 
        node root=new node(sortArr.get(mid));
        root.left= insert(sortArr,start,mid-1);
        root.right=insert(sortArr,mid+1,end);
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
            //      2        9
            //     / \      / \
            //    1   4    3   12
            node root1=new node(2);
            root1.left=new node(1);
            root1.right=new node(4);
            node root2=new node(9);
            root2.left=new node(3);
            root2.right=new node(12);
            ArrayList <Integer> sort1=new ArrayList<>();
            ArrayList <Integer> sort2=new ArrayList<>();
            ArrayList <Integer> sortArr=new ArrayList<>();
            sortArr1(root1, sort1);
            sortArr2(root2, sort2);
            int i=0,j=0;
            while(i<sort1.size() && j<sort2.size()){
            if(sort1.get(i)<sort2.get(j)){
                sortArr.add(sort1.get(i));
                i++;
                
            }
            else{
                 sortArr.add(sort2.get(j));
                 j++;
                 
            }
        }
            while(i<sort1.size()){
                  sortArr.add(sort1.get(i));
                  i++;
            }
            while(j<sort2.size()){
                  sortArr.add(sort2.get(j));
                  j++;
            }
            node root=insert(sortArr,0,sortArr.size()-1);
            Inorder(root);
            System.out.println();
    }
    
}
