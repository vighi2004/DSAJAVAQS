//checking all node are univalued or not.
package BinaryTrees;
public class UniValued {
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
            public static boolean check(node root,int data){
                if(root==null){
                    return true;
                }
                if(root.data!=data){
                    return false;
                }
                return  check(root.left, data)&& check(root.right, data);
            }
            
        }
        public static void main(String[] args) {
            BinaryTree tree=new BinaryTree();
            node root=new node(2);
            root.right=new node(2);
            root.left=new node(2);
            root.left.right=new node(2);
            root.left.left=new node(5);
            int data=root.data;
            if(tree.check(root,data)){
                System.out.println("Tree is univalued: TRUE");
            }
            else{
                System.out.println("Tree is not univalued: FALSE");
            }
        }
    
}
