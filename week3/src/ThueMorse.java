public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = 1;
        while (m < n) {
            m *= 2;
        }
        boolean[] t = new boolean[m];
        for (int i = 1; i < m; i*=2) {
            for (int j = 0; j < i; j++) {
                t[j+i] = !t[j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (t[i] ^ t[j]) {
                    System.out.print("-  ");
                } else {
                    System.out.print("+  ");
                }
            }
            System.out.println();
        }
    }
}
