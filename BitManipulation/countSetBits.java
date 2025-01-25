package BitManipulation;

public class countSetBits {
    public static void main(String[] args) {
        int count=0;
        int a=3;
        for(int i=0;i<8;i++){
            if((a&(1<<i))!=0){
                count++;
            }
        }
        if(count>0){
            System.out.println("Set bits in "+a+" our "+count);
        }
        else{
            System.out.println("There are no set bits");
        }
    }
    
}
