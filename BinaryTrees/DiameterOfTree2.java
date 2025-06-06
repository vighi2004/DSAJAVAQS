//finding diameter of tree using by approach2 O(n).here we will make helper  class info so in one function we caluclate both diameter and height at a time.
package BinaryTrees;
public class DiameterOfTree2{
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
        static class Info{
            int diam;
            int height;

            public Info(int diam,int height){
                this.diam=diam;
                this.height=height;
            }

        }
      
        //Diameter of tree and height of tree.
        public static Info DiameterOfTree(node root){
            if(root==null){
                return new Info(0, 0);
            }
            Info Leftinfo=DiameterOfTree(root.left);//left diameter
            Info Rightinfo=DiameterOfTree(root.right);//right diameter
            int selfD=Leftinfo.height+Rightinfo.height+1;
            int DIA=Math.max(selfD, Math.max(Leftinfo.diam,Rightinfo.diam));
            int HT=Math.max(Leftinfo.height,Rightinfo.height)+1;
            return new Info(DIA,HT);

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
        System.out.println("Diamter of Tree is: "+tree.DiameterOfTree(root).diam);
        System.out.println("Height of Tree is: "+tree.DiameterOfTree(root).height);
    }
    
}

