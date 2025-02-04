//removing duplicates from string O(n).
public class dupliString {
    public static void check(StringBuilder sb,int i,boolean map[],String s) {
        if(i==s.length()){
            System.out.println(sb);
            return;
        }
        char ch=s.charAt(i);
        if(!map[ch-'a']){
            map[ch-'a']=true;
            sb.append(ch);
        }
        check(sb, i+1, map, s);
    }
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder("");
        String s="appnaacollege";
        boolean map[]= new boolean[26];
        check(sb, 0, map,s);
    
    }
    
}

