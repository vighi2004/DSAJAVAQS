//contructing segment tree.
package SegmentTrees;
public class constructST {
    static int tree[];
    public static void init(int n){
        tree=new int[4*n];
    }
    public static int build(int arr[],int idx,int start,int end){
          if(start==end){
            tree[idx]=arr[start];
            return tree[idx];
          }
          int mid=(start+end)/2;
          build(arr, 2*idx+1, start, mid);//left
          build(arr, 2*idx+2, mid+1, end);//right
          tree[idx]=tree[2*idx+1]+tree[2*idx+2];
          return tree[idx];
    }
    //helper function to calculate sum.
    public static int getSumUtil(int idx,int si,int sj,int qi,int qj){
         if((qj<=si)||(qi>=sj)){
            return 0;
         }
         else if(si>=qi&&sj<=qj){
            return tree[idx];
         }
         else{
            int mid=(si+sj)/2;
            int L=getSumUtil(2*idx+1, si, mid, qi, qj);
            int R=getSumUtil(2*idx+2, mid+1, sj, qi, qj);
            return L+R;
         }
    }
    //to get range sum.O(logn)
    public static int getSum(int arr[],int qi,int qj){
        int n=arr.length;
        return getSumUtil(0,0,n-1, qi, qj);
    }
    //update function.
    public static void updateST(int arr[],int idx,int value){
        int diff=value-arr[idx];
        arr[idx]=value;
        updateSTUtil(0, 0, arr.length-1, diff,idx);
        
    }
    //updating helper function.
    public static void updateSTUtil(int i,int si,int sj,int diff,int idx){
          if(idx>sj||idx<si){
            return;
          }
          tree[i]+=diff;
          if(si!=sj){//dont go to leaf as we change it.
             int mid=(si+sj)/2;
             updateSTUtil(2*i+1, si, mid, diff, idx);
             updateSTUtil(2*i+2, mid+1, sj, diff, idx);
    }}

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8};
        int n=arr.length;
        init(n);
        build(arr, 0, 0, arr.length-1);
        System.out.println("segemeted tree is:-");
        for(int i=0;i<tree.length;i++){
            System.out.print(" "+tree[i]);
        }
        System.out.println();
        System.out.println("geting sum for particular ranges:-");
        System.out.println(getSum(arr,2,5));
        System.out.println("updating segment tree:-");
        updateST(arr,2,2);//arr,index,value
        for(int i=0;i<tree.length;i++){
            System.out.print(" "+tree[i]);
        }

    }
    
}
