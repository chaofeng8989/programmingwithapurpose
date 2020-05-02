public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        n = Math.abs(n);
        k = Math.abs(k);
        long[][] dp = new long[n+1][n+k+2];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i-1][Math.abs(j-1)] + dp[i-1][j] + dp[i-1][j+1];
            }
        }

//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j <= k; j++) System.out.print(dp[i][j] + " ");
//            System.out.println();
//        }
//        if (n == 0 && k == 0) return 1;
//        if (k < -n || k > n) return 0;
//        if (dp[n][k] == 0) dp[n][k] = trinomial(n-1, k-1) + trinomial(n-1, k) + trinomial(n-1, k+1);
        return dp[n][k];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);


        System.out.println(trinomial(n, k));


    }
}