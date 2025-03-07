public class FindDuplicates {
    public static void main(String[] args) {
        int max=0;
        int arr[]={1,2,3,6,3,6,1};
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
        }
        int count[]=new int[max+1];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        for(int i=0;i<count.length;i++){
            if(count[i]>1){
                System.out.print(i+" ");
            }
        }
    }
    
}
