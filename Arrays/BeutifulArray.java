//printing Beutiful array which satisfying rules.
import java.util.ArrayList;
public class BeutifulArray {
    static boolean found = false;
     public static void permute(ArrayList <Integer> arr,ArrayList <Integer> ans) {
        //base
        if(arr.size()==0){
            for(int i=0;i<ans.size()-2;i++){
                if(2*ans.get(i+1)==ans.get(i)+ans.get(i+2)){
                    return;
                }
            }
            System.out.println(ans);
            found=true;
            return;
        }
        //recursion
        for(int i=0;i<arr.size();i++){
            if(found){
                return;
            }
            else{
            int add=arr.get(i);
            ArrayList <Integer> newadd=new ArrayList<>(arr);
            newadd.remove(i);
            ans.add(add);
            permute(newadd,ans);
            ans.remove(ans.size() - 1);
        }
    }

     }
     public static void main(String[] args) {
        ArrayList <Integer> arr=new ArrayList<>();
        ArrayList <Integer> arr1=new ArrayList<>();
        for(int i=1;i<=5;i++){
            arr.add(i);
        }
        permute(arr,arr1);

     }
    
}