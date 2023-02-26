import java.util.Arrays;
import java.util.Stack;

public class next_greater_ele_Two {
    static int[] next_greater_ele(int nums[]){
        int n = nums.length;
        int ans [] = new int[n];

        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<Integer>();


        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                ans[stack.pop()] = nums[i];
            }

            stack.push(i);
        }   

        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                ans[stack.pop()] = nums[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,1};
        int res[] = next_greater_ele(nums);

        for (int r : res) {
            System.out.println(r);
        }
    }
}
