//generating binary tree with String and bracket representation.
package BinaryTrees;
public class BTWithStrAndBr {
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
    public static node  buildT(String str){
        if(str==null||str.length()==0){
            return  null;
        }
        int i=0;
        while(i<str.length()&&(Character.isDigit(str.charAt(i)) ||str.charAt(i)=='-')){
            i++;
        }
        int rootValue=Integer.parseInt(str.substring(0, i));
        node root=new node(rootValue);
        if (i >= str.length()) {
            return root;
        }
        int start=i;
        //left part
        if(str.charAt(i)=='('){
            int end=findMatch(str,start);
            root.left=buildT(str.substring(start+1, end));
            if(end+1<str.length()&&str.charAt(end+1)=='('){
                int end2=findMatch(str,end+1);
                root.right=buildT(str.substring(end+2,end2));
            }
        }
        return root;
    }
    public static int findMatch(String str,int start){
        int count=0;
        for (int i = start; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else if (str.charAt(i) == ')') {
                count--;
            }
            if (count == 0) {
                return i;
            }
        }
        return -1; 
    }
    public static void preorder(node root){
         if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        String str= "4(2(3)(1))(6(5))";
        node root=buildT(str);
        //print preorder
        preorder(root);
    }
    
}
