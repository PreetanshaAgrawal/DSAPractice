import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class powerSet {

    static Vector<Vector<Integer>> subsets(int[] nums) {
        Vector<Vector<Integer>> power = new Vector<Vector<Integer>>();
        Vector<Integer> ans = new Vector<Integer>();
        solve(nums, 0, ans, power);

        return power;
    }

    static void solve(int arr[], int ind, Vector<Integer> ans, Vector<Vector<Integer>> power){

        if(ind >= arr.length){
            power.add(new Vector<>(ans));
            return;
        }

        int ele = arr[ind];
        ans.add(ele);
        solve(arr, ind+1, ans, power);
        ans.remove(ans.size() - 1);
        
        solve(arr, ind+1, ans, power); 

    }

    static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<Integer>());
    
        for (int num : nums) {
          List<List<Integer>> newSubsets = new ArrayList<>();
          for (List<Integer> curr : output) {
            newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
          }
          for (List<Integer> curr : newSubsets) {
            output.add(curr);
          }
        }
        return output;
      }

    public static void main(String[] args) {
        int arr[] = {1,2,3};
        Vector<Vector<Integer>> sub = subsets(arr);
        System.out.println(sub);
    } 
}
