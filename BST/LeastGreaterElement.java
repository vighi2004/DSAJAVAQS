//Replace every element with the least greater element on its right.
package BST;
import java.util.ArrayList;
public class LeastGreaterElement {
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
    public static node insert(node root,int data){
        if(root==null){
            return new node(data);
        }
        if(root.data>data){
            root.left=insert(root.left, data);
        }
        if(root.data<data){
            root.right=insert(root.right, data);
        }
        return root;
    }
    public static void succesor(node root,ArrayList<Integer> res,int data){
       node succ=null;
       node current=root;
       while(current!=null){
        if(current.data>data){
            succ=current;
            current=current.left;
        }
        else{
            current=current.right;
        }
       }
       if(succ!=null){
         res.add(succ.data);
       }
       else{
        res.add(-1);
       }
    }
    public static void main(String[] args) {
        int arr[]={8, 58, 71, 18, 31, 32, 63, 92,43, 3, 91, 93, 25, 80, 28};
        ArrayList <Integer> res=new ArrayList<>();
        node root=null;
        for(int i=arr.length-1;i>=0;i--){
           root=insert(root,arr[i]);
           succesor(root,res,arr[i]);
        }
         for(int i=res.size()-1;i>=0;i--){
            System.out.print(" "+res.get(i)); 
        }

    }
    
}
