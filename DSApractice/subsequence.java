import java.util.Vector;

public class subsequence {
    static void solve(int ind, String str, StringBuilder output, Vector<String> res){
        // Base case
        if(ind >= str.length()){
            res.add(output.toString());
            return;
        }

        // include
        output.append(str.charAt(ind));
        solve(ind+1, str, output, res);
        // backTrack
        output.deleteCharAt(output.length() -1);

        // exclude
        solve(ind+1, str, output, res);

    }


    public static void main(String[] args) {
        String str = "abcd";
        StringBuilder output = new StringBuilder();
        Vector<String> res = new Vector<String>();
        solve(0, str, output, res);

        System.out.println(res);
        System.out.println(res.size());
    }
}
