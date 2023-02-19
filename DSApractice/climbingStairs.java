import java.util.Arrays;

public class climbingStairs {
    static int solve(int n){
        // if(n==1 || n==2) return n;

        int dp[] = new int[n+1];

        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;

        // if(dp[n] != -1) return dp[n];

        // gives TLE in Recursion
        // int num = solve(n-1) + solve(n-2);


        for (int i = 2; i <=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    static int minCost(int nums[], int dp[], int n){
        
        if(n == 1 || n == 0 ) return nums[n];
        
        if(dp[n] != -1) return dp[n];

        return dp[n] = Math.min(minCost(nums, dp, n-1), minCost(nums, dp, n-2)) + nums[n];
    }
    public static void main(String[] args) {
        // int n = 4;
        // System.out.println(solve(n));

        int nums [] = {1,100, 1, 1,1, 100, 1,1, 100, 1};
        int n = nums.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        
        int ans = Math.min(minCost(nums, dp, n-1), minCost(nums, dp, n-2));

        System.out.println(ans);
    }
}
