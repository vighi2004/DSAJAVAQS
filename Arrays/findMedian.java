//storing each element range median in result array ,time taken is O(n^2.logn).
import java.util.*;
public class findMedian {
    public static void main(String[] args) {
        ArrayList <Integer> medarr=new ArrayList<>();
        medarr.add(5);
        medarr.add(15);
        medarr.add(1);
        medarr.add(3);
        medarr.add(2);
        medarr.add(8);
        ArrayList <Integer> res=new ArrayList<>();

        for(int i=0;i<medarr.size();i++){
            List<Integer> submed=new ArrayList<>(medarr.subList(0, i+1));
            Collections.sort(submed);
            if(submed.size()==1){
                   res.add(submed.get(i));
                   submed.clear();
            }
            else{
                if(submed.size()%2==0){
                    if(submed.size()==2){
                        int median=(submed.get(i-1)+submed.get(i))/2;
                        res.add(median);
                    }
                    else{
                        int x1=submed.size();
                        int median=(submed.get(x1/2)+submed.get((x1/2)-1))/2;
                        res.add(median);
                    }
                    submed.clear();
                }
                else{
                    int x1=submed.size();
                    int median=submed.get((submed.size())/2);
                    res.add(median);
                    submed.clear();


                }
            }
        }
        System.out.println(res);

    }
    
    
}
