public class CountingSort {
    public static void main(String[] args) {
        int arr[]={1,3,34 ,1,2,2};
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
        }
        int count[]=new int[max+1];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        int j=0;
        for(int i=0;i<count.length;i++){
            while (count[i]>0) {
                arr[j]=i;
                j++;
                count[i]--;
                
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
          
        }
    }
}
