//conversion of uppecase to lowercase characters using bits.
package BitManipulation;

public class charConvert {
    public static void main(String[] args) {
    char a='Z'; 
    int asciiValue = (int) a;
    int b=asciiValue|32;
    char c=(char)b;
    System.out.println("lower conversion of char is: "+c);
    }


    
}
