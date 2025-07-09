//creating max-min segment tree to find max in subarray.
package SegmentTrees;
public class MaxMinST {
    static int tree[];
    public static void init(int n){
        tree=new int[4*n];
    }
    //creating MaxST
    public static void BuildMaxST(int arr[],int si,int sj,int idx){
           if(si==sj){
             tree[idx]=arr[si];
             return;
           }
           int mid=(si+sj)/2;
           BuildMaxST(arr, si, mid, 2*idx+1);
           BuildMaxST(arr,mid+1,sj,2*idx+2);
           tree[idx]=Math.max(tree[2*idx+1],tree[2*idx+2]);
    }
     //helper function to calculate max.
    public static int getMaxUtil(int idx,int si,int sj,int qi,int qj){
         if((qj<=si)||(qi>=sj)){
            return Integer.MIN_VALUE;
         }
         else if(si>=qi&&sj<=qj){
            return tree[idx];
         }
         else{
            int mid=(si+sj)/2;
            int L=getMaxUtil(2*idx+1, si, mid, qi, qj);
            int R=getMaxUtil(2*idx+2, mid+1, sj, qi, qj);
            return Math.max(L, R);
         }
    }
     //to get range max.O(logn)
    public static int getMax(int arr[],int qi,int qj){
        int n=arr.length;
        return getMaxUtil(0,0,n-1, qi, qj);
    }
    public static void update(int arr[],int idx,int value){
        arr[idx]=value;
        int n=arr.length;
        updateUtil(idx,0,0,n-1,value);
    }
    public static void updateUtil(int idx,int i,int si,int sj,int value){
        if(idx<si||idx>sj){
            return;
        }
        tree[i]=Math.max(tree[i],value);
        if(si!=sj){
        int mid=(si+sj)/2;
        updateUtil(idx,2*i+1,si, mid,value);
        updateUtil(idx, 2*i+2, mid+1, sj, value);
    }}
    
    public static void main(String[] args) {
        int arr[]={6,8,-1,2,17,1,3,2,4};
        int n=arr.length;
         init(n);
         BuildMaxST(arr, 0, n-1, 0);
         for(int i=0;i<tree.length;i++){
            System.out.print(" "+tree[i]);
        }
        System.out.println();
        System.out.println("geting max of particular range:-");
        System.out.println(getMax(arr, 2, 4));
        System.out.println("updating ST");
        update(arr,2,20);//arr,index,newvalue.
          for(int i=0;i<tree.length;i++){
            System.out.print(" "+tree[i]);
        }
        
    }
}

