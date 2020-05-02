public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long c = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] > a[j]) c ++;
            }
        }
        return c;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] re = new int[n];
        for (int i = 0; i < n; i++) {
            re[i] = i;
        }
        int left = 0;
        while (k != 0) {
            int right = n - 1;
            if (k - (right - left) >= 0) {
                exch(re, left, right);
                k -= right - left;
                left++;
            } else {
                exch(re, (int)(right - k), right);
                break;
            }
        }
        return re;
    }
    private static void exch(int[] array, int start, int end) {
        int tmp = array[end];
        for (int i = end; i > start; i--) {
            array[i] = array[i-1];
        }
        array[start] = tmp;
    }
    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] re = generate(n, k);
        for (int r : re) System.out.print(r + " ");
    }
}