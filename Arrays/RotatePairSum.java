import java.util.Scanner;
public class RotatePairSum {
    public static int[] RotateArray(int[] arr,int[] RotateArray,int pivot) {
    int j=0;   
    for(int i=pivot+1;i<arr.length;i++){
        RotateArray[j]=arr[i];
        j++;
    }
    for(int k=0;k<=pivot;k++){
        RotateArray[j]=arr[k];
        j++;
    }
    return RotateArray;     
    }
    public static void pair(int[] RotateArray,int Pairsum) {
    for(int i=0;i<RotateArray.length;i++){
        for(int j=i+1;j<RotateArray.length;j++){
           if(RotateArray[i]+RotateArray[j]==Pairsum){
            System.out.println("There is pair in RotateArray  ("+RotateArray[i]+","+RotateArray[j]+")  which is equal to Pairsum:"+Pairsum);
            return;
           }
        }
        System.out.println("No any pair found");
    }
        
    }
    public static void main(String[] args) {
     int arr[]={0,1,2,3,4,5,6,7};
     int Pairsum=9;
     int RotateArray[]=new int[arr.length];
     Scanner sc=new Scanner(System.in);
     System.out.println("Enter pivot number to rotate from:-");
     int pivot=sc.nextInt();
     System.out.println("Printing rotating array");
     int[] result=RotateArray(arr,RotateArray,pivot);
     for(int i=0;i<result.length;i++){
        System.out.print(" "+result[i]);
     }
     System.out.println();
     System.out.println();
     System.out.println("Finding Pair sum....");
     pair(RotateArray,Pairsum);   
    }
}
