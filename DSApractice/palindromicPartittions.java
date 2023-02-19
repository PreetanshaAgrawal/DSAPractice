import java.util.ArrayList;
import java.util.List;

public class palindromicPartittions {
    static void solve(String str, int ind, int n, List<List<String>> res, List<String> ans) {

        if (ind >= n) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = ind; i < n; i++) {

            if (isPalindrome(str, ind, i)) {
                ans.add(str.substring(ind, i+1));
                solve(str, ind + 1, n, res, ans);
                ans.remove(ans.size()-1);
            }
        }
    }

    static boolean isPalindrome(String str, int ind, int n) {

        while (ind < n) {
            if (str.charAt(ind++) != str.charAt(n--)) {

                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();

        String str = "nitin";
        int n = str.length();
        solve(str, 0, n, res, ans);
        System.out.println(res);
    }
}