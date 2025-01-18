//check if array is distinct retur true if present and false if not;
public class DistinctArray {
    public static void distinct(int arr[]){
        int n=arr.length;
        int formula=n*(n-1)/2;
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]!=arr[j]){
                    count++;
                }
            
            }


        
        }
        if(count==formula){
            System.out.println("False");
        }
        else{
            System.out.println("True");
        }
       
    }
    
    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        distinct(arr);
        

    }
    

}
