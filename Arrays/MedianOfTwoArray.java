import java.util.*;
public class MedianOfTwoArray {
    public static void main(String[] args) {
    ArrayList <Integer> arr=new ArrayList<>();
    arr.add(-5);
    arr.add(3);
    arr.add(6);
    arr.add(12);
    arr.add(15);
    ArrayList <Integer> arr1=new ArrayList<>();
    arr1.add(-12);
    arr1.add(-10);
    arr1.add(-6);
    arr1.add(-3);
    arr1.add(4);
    arr1.add(10);
    for(int i=0;i<arr1.size();i++){
        arr.add(arr1.get(i));

    }
    Collections.sort(arr);
    if(arr.size()%2==0){
        int median=arr.get(arr.size()/2)+arr.get((arr.size()/2)-1);
        System.out.println("median for odd array:"+median); 
    }
    else{
        int median=arr.get(arr.size()/2);
        System.out.println("median for odd array:"+median);
    }
    
}
}