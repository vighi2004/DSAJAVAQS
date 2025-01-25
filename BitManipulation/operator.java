package BitManipulation;

public class operator {
    public static void main(String[] args) {
        System.out.println(6&1);
        System.out.println(5|6);
        System.out.println(6^0);
        System.out.println(~6);
        System.out.println(5<<2);
        System.out.println(6>>1);
        int i=1;
        int b=15>>i;
        System.out.println(b&1);
        //setting ith bit
        System.out.println(5|(1<<i));
        //clear ith bit
        int c=~(1<<i);
        System.out.println(10&c);

    }

    
}
