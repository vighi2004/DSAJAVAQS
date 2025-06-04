//counting maximum balanced substring.
package Greedy_Algo;
public class MaxBalancedSub {
    public static void main(String[] args) {
        String str="LRRRRLLRLLRL";
        StringBuilder str1=new StringBuilder();
        int LC=0,RC=0;
        int count=0;
        int i=0;
        while(i<str.length()){
            str1.append(str.charAt(i));
            if(str.charAt(i)=='L'){
                LC++;
            }
            else{
                RC++;
            }
             if(LC==RC && LC!=0 && RC!=0){
                count++;
                System.out.println(str1);
                //reset counts.
                str1.setLength(0);
                LC=0;
                RC=0;
            }
            i++;
        
        }
        System.out.println("Max possible balanced substrings are: "+count);

        
    }

}
