public class HanoiTower {
    public static void check(int n,String A,String B,String C) {
        if(n>0){
            check(n-1,A,C,B);// from A to B using C(middle).Moving two disk from A to B.
            System.out.println("move disc from"+A+"to"+C);
            check(n-1,B,A,C);//from B to C using A.Moving two disk from B to C.
        }
        
    }
    public static void main(String[] args) {
        check(3,"A","B","C");

    }
    
}
