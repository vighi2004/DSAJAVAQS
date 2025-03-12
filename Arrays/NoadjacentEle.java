//print array elements which are not adacent and there before and after should not be present. 
import java.util.*;
public class NoadjacentEle {
    public static void main(String[] args) {
        ArrayList <Integer> list=new ArrayList<>();
        list.add(10);
        list.add(6);
        list.add(5);
        list.add(8);
        Collections.sort(list);
        ArrayList <Integer> list1=new ArrayList<>();
        for(int i=0;i<=list.size()-1;i++){
            if(i==0){
                if((list.get(i)+1)!=list.get(i+1)&&list.get(i)!=list.get(i+1)){
                    list1.add(list.get(i));
                }
            }
            else if(i==list.size()-1){
                if((list.get(i)-1)!=list.get(i-1)){
                    list1.add(list.get(i));
                }
            }
            else{
                if((list.get(i)+1)!=list.get(i+1)&&list.get(i)!=list.get(i+1)&&(list.get(i)-1)!=list.get(i-1)){
                    list1.add(list.get(i));
            }

        }

    }
    System.out.println(list1);
    
}
}
