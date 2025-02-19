//converting senetence to mobile number;
package Strings;
public class charTomobile {
    public static void main(String args[]){
        String str[]
			= { "2", "22", "222", "3", "33", "333",
				"4", "44", "444", "5", "55", "555",
				"6", "66", "666", "7", "77", "777",
				"7777", "8", "88", "888", "9", "99",
				"999", "9999" };

		String input = "GEEKSFORGEEKS";
        String output=" ";
        for(int i=0;i<input.length();i++){
            char c=input.charAt(i);
            output=output+str[c-'A'];
        }
        System.out.println(output);
    }

    
}