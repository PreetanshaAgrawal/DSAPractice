public class single_element_sorted_array {

    // linear method
    static int solveLinear(int nums[], int n) {
        // count 2 for every element appearing twice in the array
        int count = 2;
        int curr = nums[0];

        for (int i = 1; i < n; i++) {
            if (count == 1) {
                break;
            } else if (curr == nums[i]) {
                curr = nums[i + 1];
                i = i + 1;
            }

            else {
                count--;
            }
        }

        return curr;
    }

    static int solveBitMani(int nums[]) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {

            ans = ans ^ nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 8 };
        int n = nums.length;

        System.out.println(solveLinear(nums, n));
        System.out.println(solveBitMani(nums));
    }
}
