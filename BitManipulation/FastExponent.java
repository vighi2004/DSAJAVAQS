package BitManipulation;

public class FastExponent {
    public static void main(String[] args) {
        
    
    int a=5;
    int power=3;
    int ans=1;
    while(power>0){
        if((a&1)!=0){
        ans=ans*a;
        }
        a=a*a;
        power=power>>1;
    }
    System.out.println(ans);
}
    
}
