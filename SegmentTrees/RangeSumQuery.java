//calculate list of operation given i list.
package SegmentTrees;
public class RangeSumQuery {
    static int tree[];
    static int arr[];
    public static void init(int n){
        tree=new int[4*n];
        arr=new int[n];
    }
    public static String numArray(int nums[]){
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i];
        }
        return null;
    }
    public static int build(int idx,int start,int end){
          if(start==end){
            tree[idx]=arr[start];
            return tree[idx];
          }
          int mid=(start+end)/2;
          build(2*idx+1, start, mid);//left
          build(2*idx+2, mid+1, end);//right
          tree[idx]=tree[2*idx+1]+tree[2*idx+2];
          return tree[idx];
    }
    public static int sumRangeUtil(int i,int si,int sj,int idx1,int idx2){
         if((idx2<=si)||(idx1>=sj)){
            return 0;
         }
         else if(si>=idx1&&sj<=idx2){
            return tree[i];
         }
         else{
            int mid=(si+sj)/2;
            int L=sumRangeUtil(2*i+1, si, mid, idx1, idx2);
            int R=sumRangeUtil(2*i+2, mid+1, sj, idx1, idx2);
            return L+R;
         }

    }
    public static void updateUtil(int i,int si,int sj,int diff,int idx){
       if(idx>sj||idx<si){
            return;
          }
          tree[i]+=diff;
          if(si!=sj){//dont go to leaf as we change it.
             int mid=(si+sj)/2;
             updateUtil(2*i+1, si, mid, diff, idx);
             updateUtil(2*i+2, mid+1, sj, diff, idx);
    }

    }
    public static void update(int idx,int value){
        int diff=value-arr[idx];
        arr[idx]=value;
        updateUtil(0,0,arr.length-1,diff,idx);
    }
    public static int sumRange(int idx1,int idx2){
        return sumRangeUtil(0,0,arr.length-1,idx1,idx2);
    }
    public static void main(String[] args) {
        String instr[]={"numArray","sumRange","update","sumRange"};
        int inarr[][]={{1,3,5},{0,2},{1,2},{0,2}};
        for(int i=0;i<inarr.length;i++){
            if(instr[i].equals("numArray")){
                init(inarr[i].length);
                System.out.println(numArray(inarr[i]));
                build(0, 0, inarr[i].length-1);
            }
            else if(instr[i].equals("sumRange")){
                System.out.println(sumRange(inarr[i][0],inarr[i][1]));
            }
            else{
                update(inarr[i][0],inarr[i][1]);
                System.out.println("null");
            }

        }
    }
    
}
