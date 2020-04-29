public class TrinomialBrute {
    public static long trinomial(int n, int k) {
        if (k < 0 || k > 2*n) return 0;

        if (n == 0 && k == 0) return 1;

        if (n == 1) {
            if (k <= 2) return 1;
            else return 0;
        }
        long re = trinomial(n-1, k) + trinomial(n-1, k-1) + trinomial(n-1, k-2);
        //System.out.println("("+n + ", " + k + ")" + re);
        return re;
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        if (n * (n+k) < 0) {
            System.out.println("0");
            return;
        }
        n = Math.abs(n);
        k = Math.abs(k);
        System.out.println(trinomial(n,n+ k));
    }
}
