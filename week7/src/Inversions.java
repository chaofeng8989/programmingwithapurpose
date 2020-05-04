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
    // 20
    // 9  ---9
    // 9 8 --- 17
    // 9 8
    public static int[] generate(int n, long k) {
        int[] re = new int[n];
        int startIndex = 0, endIndex = n-1, start = 0, end = n-1;
        while (startIndex < endIndex) {
            if (k == 0) {
                while (startIndex <= endIndex) {
                    re[startIndex++] = start++;
                }
            } else if (k >= end) {
                re[startIndex] = end;
                k-= end;
                startIndex++;
                end--;
            } else {
                re[endIndex] = end;
                endIndex--;
                end--;
            }

        }

        return re;
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