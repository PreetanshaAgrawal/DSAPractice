import java.util.Vector;

public class phoneKeyPad {

    static void solve(String digit, StringBuilder output, String[] mapping, Vector<String> ans, int index){

        // Base case

        if(index >= digit.length()){
            ans.add(output.toString());
            return;
        }

        int num = digit.charAt(index) - '0';

        String value = mapping[num];

        for (int i = 0; i < value.length(); i++) {
            output.append(value.charAt(i));
            solve(digit, output, mapping, ans, index+1);

            // backtrack the last character
            output.deleteCharAt(output.length()-1);
        }
    } 

    public static void main(String[] args) {
        String digit = "234";
        StringBuilder output = new StringBuilder();

        Vector<String> ans = new Vector<String>();

        if(digit.length() == 0){
            System.out.println(ans);
            return;
        }
        String mapping[] = {
            "", "", "abc",
            "def", "ghi", "jkl",
            "mno", "pqrs", "tuv",
            "wxyz"
        };

        solve(digit, output, mapping, ans, 0);
        System.out.println(ans);
    }
}
