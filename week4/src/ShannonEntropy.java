
public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] count = new int[m];
        int all = 0;
        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            count[x-1]++;
            all ++;
        }
        double h = 0;
        for (int c : count) {
            if (c == 0) continue;
            double f = 1.0 * c / all;
            h -= f * Math.log(f) / Math.log(2);
        }
        System.out.printf("%.4f\f", h);
    }
}
