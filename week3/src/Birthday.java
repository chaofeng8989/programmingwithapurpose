public class Birthday {
    public static void main(String[] args) {
        int day = Integer.parseInt(args[0]);
        int trails = Integer.parseInt(args[1]);
        int[] all = new int[day+1];
        for (int i = 0; i < trails; i++) {
            boolean[] birthday = new boolean[day];
            int d = 0;
            while (true) {
                int choose = (int) Math.floor(Math.random() * day);
                if (birthday[choose]) break;
                birthday[choose] = true;
                d ++;
            }
            all[d] ++;
        }
        int sum = 0;
        for (int i = 0; i <= day; i++) {
            if (i != 0) sum += all[i];
            double fraction = 1.0 * sum / trails;
            System.out.printf("%-8d%-10d%1.6f\n", i+1, all[i], fraction);
            if (fraction >= 0.5) break;
        }

    }
}
