//calculating height of tree using recursion O(n).
package BinaryTrees;
public class HeightTree {
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
        //height of tree
        static int height=0;
        public static int HeightOfTree(node root){
            if(root==null){
                return 0;
            }
            int LN=HeightOfTree(root.left);//left node
            int RN=HeightOfTree(root.right);//right node
            height=Math.max(LN,RN)+1;
            return height;

        }
        //counting of nodes
        static int nodeC=0;
        public static int CountNode(node root){
           if(root==null){
            return 0;
           }
            nodeC=CountNode(root.left)+CountNode(root.right);
            return nodeC+1;

        }
        //sum of nodes.
        static int sumN=0;
        public static int SumNode(node root){
           if(root==null){
            return 0;
           }
            sumN=sumN+root.data;
            SumNode(root.left);
            SumNode(root.right);
            return sumN;

        }
    }
    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
    //        1
    //       / \
    //      2   3
    //     / \   \
    //    4   5   6
        BinaryTree tree=new BinaryTree();
        node root=tree.BuildTree(nodes);
        System.out.println("Height of Tree is: "+tree.HeightOfTree(root));
        System.out.println("Nodes of Tree is: "+tree.CountNode(root));
        System.out.println("Sum of Tree nodes is: "+tree.SumNode(root));

        
    }
    
}
