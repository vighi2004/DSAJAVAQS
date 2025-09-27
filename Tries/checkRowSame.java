//printing Unique rows from the matrix using tries.
package Tries;
import java.util.*;
public class checkRowSame {
    static class node{
        node children[]=new node[2];
        boolean endOfWord;
        public node(){
               for(int i=0;i<2;i++){
                    children[i]=null;
                }
                endOfWord=false;
        }
    }
    public static node root=new node();
    public static void insert(int arr[]){
        node curr=root;
        boolean flag=false;
        for(int i=0;i<arr.length;i++){
         if(curr.children[arr[i]]==null){
            curr.children[arr[i]]=new node();
            flag=true;
         }
         if(i==arr.length-1){
             curr.children[arr[i]].endOfWord=true;
         }
         curr=curr.children[arr[i]];
        }
        if(flag){
            System.out.print("$");
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[j]+" ");
            }
            System.out.print("$");
        }
    } 

    public static void main(String[] args) {   
     int arr[][]={{1,1,0,1},{1,0,0,1},{1,1,0,1}};
     for(int i=0;i<arr.length;i++){
        insert(arr[i]);
     }  
    }
}
