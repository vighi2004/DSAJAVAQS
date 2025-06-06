//finding diameter of tree using by approach1 O(n2).
package BinaryTrees;
public class DiameterOfTree1{
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
        public static int HeightOfTree(node root){
            if(root==null){
                return 0;
            }
            int LN=HeightOfTree(root.left);//left node
            int RN=HeightOfTree(root.right);//right node
            return Math.max(LN,RN)+1;
            

        }
        //Diameter of tree
        public static int DiameterOfTree(node root){
            if(root==null){
                return 0;
            }
            int LeftDiam=DiameterOfTree(root.left);//left diameter
            int LeftH=HeightOfTree(root.left);//left height
            int RightDiam=DiameterOfTree(root.right);//right diameter
            int RightH=HeightOfTree(root.right);//right height
            int selfD=LeftH+RightH+1;
            return Math.max(selfD, Math.max(RightDiam,LeftDiam));

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
        System.out.println("Diamter of Tree is: "+tree.DiameterOfTree(root));
    }
    
}

