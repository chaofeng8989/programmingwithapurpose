public class
TrinomialBrute {
    public static long trinomial(int n, int k) {

        if (n == 0 && k == 0) return 1;
        if (k < -n || k > n) return 0;
        k = Math.abs(k);
        long re = trinomial(n-1, k-1) + trinomial(n-1, k) + trinomial(n-1, k+1);
        //System.out.println("("+n + ", " + k + ")" + re);
        return re;
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        System.out.println(trinomial(n,k));
    }
}
