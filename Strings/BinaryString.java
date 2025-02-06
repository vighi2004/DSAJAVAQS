//printing Binary string 
public class BinaryString{
    public static void check(int n,int lastPlace,String str) {
        if(n==0){
            System.out.println(str);
            return;
        }
        check(n-1,0,str+"0");
        if(lastPlace==0){
            check(n-1,1,str+"1"); 
        }
    }
    public static void main(String[] args) {
        int n=3;
        check(n,0," ");
    
    }
}