public class minOperations {
    static int solve(int k){
        if(k == 1) return 1;
        if(k <= 0) return 0;

        // when k is even
        int count = solve(k-1) +1;
        if(k%2 == 0){
            count = Math.min (count, solve(k/2) +1); 
        }

        return count;
    }

    // tabulation method
    static int solveTab(int k){
        int dp[] = new int[k+1];

        for (int i = 1; i <= k; i++) {
            dp[i] = dp[i-1] +1;
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2] +1);
            }
        }
        return dp[k];
    }
    public static void main(String[] args) {
        int k = 12;

        // System.out.println(solve(k));
        System.out.println(solveTab(k));
    }
}
