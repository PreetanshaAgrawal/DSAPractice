import java.util.Arrays;

public class minCoinsDP {

    // Recursion
    static int minCoinsRec(int nums[], int target) {
        if (target == 0)
            return 0;
        if (target < 0)
            return Integer.MAX_VALUE;

        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int ans = minCoinsRec(nums, target - nums[i]);

            if (ans != Integer.MAX_VALUE) {
                mini = Math.min(ans + 1, mini);
            }
        }

        return mini;
    }

    // top down DP
    static int minCoinsDPMem(int nums[], int target, int dp[]) {
        if (target == 0)
            return 0;
        if (target < 0)
            return Integer.MAX_VALUE;

        if (dp[target] != -1)
            return dp[target];

        dp[target] = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int ans = minCoinsDPMem(nums, target - nums[i], dp);

            if (ans != Integer.MAX_VALUE) {
                dp[target] = Math.min(ans + 1, dp[target]);
            }
        }

        return dp[target];
    }

    // bottom up DP
    static int minCoinsDPTab(int nums[], int target, int dp[]) {

        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0 && dp[i-nums[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1+ dp[i - nums[j]]);
                }
            }
        }

        if(dp[target] == Integer.MAX_VALUE) return -1;
        
        return dp[target];
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5};
        int target = 5;
        int dp[] = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // System.out.println(minCoinsRec(nums, target));
        // System.out.println(minCoinsDPMem(nums, target, dp));
        System.out.println(minCoinsDPTab(nums, target, dp));
    }
}
