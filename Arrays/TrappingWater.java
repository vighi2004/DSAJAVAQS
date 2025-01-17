//TRaping water problem O(n^2);
public class TrappingWater {
        public static void left(int arr[],int leftarray[]){
    
            for(int i=0;i<arr.length;i++){
                int maxleft=0;
                for(int j=i;j>=0;j--){
                    if(arr[j]>maxleft){
                        maxleft=arr[j];
                    }
                }
                leftarray[i]=maxleft;
            }

        }

        public static void right(int arr[],int rightarray[]){
            
            for(int i=0;i<arr.length;i++){
                int maxright=0;
                for(int j=i;j<arr.length;j++){
                    if(arr[j]>maxright){
                        maxright=arr[j];
                    }
                }
                rightarray[i]=maxright;
            }
        }

        public static void main(String[] args) {
            int arr[]={4,2,0,6,3,2,5};
            int water_trap;
            int sum=0;
            int leftarray[]=new int[arr.length];
            int rightarray[]=new int[arr.length];
            left(arr,leftarray);
            for(int i=0;i<arr.length;i++){
                System.out.println("left array is:"+leftarray[i]);
            }
            right(arr,rightarray);
            for(int i=0;i<arr.length;i++){
                System.out.println("right array is:"+rightarray[i]);
            }

            for(int k=0;k<arr.length;k++){
                if(leftarray[k]>rightarray[k]){
                    water_trap=rightarray[k];
                    sum=(water_trap-arr[k])+sum;
                }
                else{
                    water_trap=leftarray[k];
                    sum=(water_trap-arr[k])+sum;
                }
            }
            System.out.println("rainwater Tap Total sum is:"+sum);

        }

    
}
