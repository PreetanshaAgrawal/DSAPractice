public class TotalOnes {
    static int solve(int n) {
        if (n == 0 || n == 1)
            return n;
            
        int cnt = 0;
        if (n >= 10) {
            int temp = n;
            while (temp > 0) {
                int one = temp % 10;
                if (one == 1)
                    cnt++;

                temp = temp / 10;
            }

            return cnt;
        }

        int ans = cnt;
        return ans += solve(n-1);
    }

    public static void main(String[] args) {
        int n= 13;

        System.out.println(solve(n));
    }
}
