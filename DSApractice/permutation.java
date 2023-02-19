import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class permutation {
    // static void solve(int ind, String input, String output, List<String> res){

    // }
    static void solve(int ind, List<Integer> arr, List<List<Integer>> res) {
        // base case
        if (ind == arr.size()) {
            res.add(new ArrayList<>(arr));
            return;
        }

        for (int i = ind; i < arr.size(); i++) {
            Collections.swap(arr, ind, i);
            solve(ind + 1, arr, res);
            // backtrack
            Collections.swap(arr, ind, i);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        int arr[] = { 1, 2, 3 };
        if (arr.length != 0) {
            List<Integer> sub = new ArrayList<>();
            for (int num : arr)
                sub.add(num);
            solve(0, sub, res);
        }
        // solve(0, arr, res);
        System.out.println(res);

    }
}