import java.nio.file.WatchEvent;

public class LongestPath {
    static int solve(int i, int j, int n, int mat[][], int dp[][]) {

        if (i < 0 || j < 0 || j >= n || i >= n)
            return 0;
        
        if(dp[i][j] != -1) return dp[i][j];

        int x = Integer.MIN_VALUE, y = Integer.MIN_VALUE, z = Integer.MIN_VALUE, w = Integer.MIN_VALUE;

        if (i < n-1 && (mat[i + 1][j] - mat[i][j] == 1)) {
            x = 1 + solve(i + 1, j, n, mat, dp);
            dp[i][j] = x;
        }
        if (i>0 && (mat[i - 1][j] - mat[i][j] == 1)) {


            y = 1 + solve(i - 1, j, n, mat, dp);
            dp[i][j] = y;
        }
        if (j < n-1 && (mat[i][j+1] - mat[i][j] == 1)) {

            z = 1 + solve(i, j+1, n, mat, dp);
            dp[i][j] = z;
        }
        if (j > 0 && (mat[i][j-1] - mat[i][j] == 1)) {

            w = 1 + solve(i , j-1, n, mat, dp);
            dp[i][j] = w;
        }
        return dp[i][j] = Math.max(x, Math.max(y, Math.max(z, Math.max(w,1))));
    }


    static int solveAll( int n, int mat[][]){
        int res = 1;

        int dp[][] = new int[n][n];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                if(dp[i][j] == -1)
                    solve(i, j, n, mat, dp);
                    res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int mat[][] = {
                { 1, 2, 9 },
                { 5, 3, 8 },
                { 4, 6, 7 }
        };

        System.out.println(solveAll(3, mat));
    }
}
