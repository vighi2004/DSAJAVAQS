//counting subarrays who's starting index and ending index is same.
public class CountSubarray {
    public static void main(String[] args) {
        String str = "abcab";
        int n = str.length();
        int p = 0;
        int f = (n * (n + 1)) / 2;
        String arr[] = new String[f];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                arr[p] = str.substring(i, j + 1); 
                p++;
            }
        }
        int count=0;
        for(int i=0;i<arr.length;i++){
            if((arr[i].length())==1){
                count++;
            }
            else if(arr[i].charAt(0)==arr[i].charAt(arr[i].length()-1)){
                count++;
            }
        }
        System.out.println("count is"+count);
    }
}
