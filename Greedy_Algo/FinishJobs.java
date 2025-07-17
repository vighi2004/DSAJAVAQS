//finding minimum time required to finish jobs.
package Greedy_Algo;
public class FinishJobs {
    public static boolean ispossible(int jobs[],int k,int mid){
        int ct=1;
        int time=0;
        for(int i=0;i<jobs.length;i++){
            if(jobs[i]>mid){
               return false;
            }
            else if(time+jobs[i]<=mid){
                  time=time+jobs[i];
            }
            else{
                ct++;
                time=jobs[i];
            }
        }
        if(ct<=k){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
    int jobs[]={3,2,3};
    int t=5;
    int k=3;
    int sum=0;
    for(int i=0;i<jobs.length;i++){
        sum+=jobs[i];
    }
    int start=0;
    int end=sum;
    int ans=Integer.MAX_VALUE;
    while(start<=end){
        int mid=(start+end)/2;
        if(ispossible(jobs,k,mid)){
            ans=Math.min(ans, mid);
            end=mid-1;
        }
        else{
            start=mid+1;
        }
    }
    System.out.println("minimum time required: "+ans*t);
}}
