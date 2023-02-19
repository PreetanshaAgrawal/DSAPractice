import java.util.Arrays;

public class nthCatalan {
    static int solve(int n, int dp[]){
        // Base Case
        if(n<=1) return dp[n] = 1;

        if(dp[n] != 0) return dp[n];
        // solve for one
        int res =0;
        for (int i = 0; i < n; i++) {
            res += solve(i, dp) * solve(n-i-1, dp);
            System.out.println(dp[i]);
        }
        return dp[n] = res;
    }
    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int [n+1];
        Arrays.fill(dp, 0);
        System.out.println(solve(n, dp));
    }
}
