//finding largest size of BST from Binary Tree.
package BST;
public class LargestSizeOfBST {
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
    public static int maxSize=0;
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        int sum;

        public Info(boolean isBST,int size,int min,int max,int sum){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
            this.sum=sum;
        }
    }
    static int Usum=0;
    public static Info LargestBST(node root){
        if(root==null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE,0);
        }
        Info leftinfo=LargestBST(root.left);
        Info rightInfo=LargestBST(root.right);
        //size
        int size=leftinfo.size+rightInfo.size+1;
        //sum
        int sum=leftinfo.sum+rightInfo.sum+root.data;
        //min
        int min=Math.min(root.data,Math.min(leftinfo.min,rightInfo.min));
        //max
        int max=Math.max(root.data,Math.max(leftinfo.max,rightInfo.max));
        //isBST valid logic
        if(root.data<=leftinfo.max||root.data>=rightInfo.min){
            return new Info(false,size,min,max,sum);
        }
        if(leftinfo.isBST&&rightInfo.isBST){
            Usum=Math.max(Usum,sum);
            maxSize=Math.max(maxSize,size);
            return new Info(true, size, min, max,sum);
        }
        return new Info(false, size, min, max,sum);

    }
    public static void main(String[] args){
                //       50
                //     /    \
                //    30 |   60     |
                //   / \ |  /   \   |
                //   5 20|45   70   |//this is BST.Expected output 5 nodes.
                //       |     / \  |
                //       |    65 80 |
                node root=new node(50);
                root.left=new node(30);
                root.right=new node(60);
                root.left.left=new node(5);
                root.left.right=new node(20);
                root.right.left=new node(45);
                root.right.right=new node(70);
                root.right.right.left=new node(65);
                root.right.right.right=new node(80);
                LargestBST(root);
                System.out.println("Max size of BST is: "+maxSize);
                System.out.println(Usum);
                

     }
    
}
