package BitManipulation;

public class power {
    public static void main(String[] args) {
        
    
    int a=6;
    int i=a/2;
    int shift=1<<i;
    if((a^shift)==0){
        System.out.println("this number is of power 2");
    }
    else{
        System.out.println("not power of 2");
    }
    
}
}
