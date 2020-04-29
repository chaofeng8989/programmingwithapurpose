public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    static long[][] dp;
    public static long trinomial(int n, int k) {
        if (k < 0 || k > 2*n) return 0;

        if (n == 0 && k == 0) return 1;

        if (n == 1) {
            if (k <= 2) return 1;
            else return 0;
        }
        if (dp[n][k] == 0) dp[n][k] = trinomial(n-1, k) + trinomial(n-1, k-1) + trinomial(n-1, k-2);
        //System.out.println("("+n + ", " + k + ")" + dp[n][k]);
        return dp[n][k];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        if (n * (n+k) < 0) {
            System.out.println("0");
            return;
        }
        n = Math.abs(n);
        k = Math.abs(k);
        dp = new long[n+1][2*(k+n)+1];
        System.out.println(trinomial(n, k+n));
    }
}