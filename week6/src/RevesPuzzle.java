public class RevesPuzzle {
    private static void hanoi(int n, int k, String[] slots) {
        int[] now = new int[n-k+1];
        for (int i = 0; i < n-k+1; i++) {
            now[i] = 1;
        }

        System.out.println(hanoi(n, k, false, slots, now) );
    }
    private static String hanoi(int n, int k, boolean left, String[] slots, int[] now) {

        if (n == k) return " ";
        String move;
        int current = 0, next = 0;
        if (left) {
            current = now[n-k];
            next = (now[n-k]-1 + slots.length) % slots.length;
            now[n-k] = next;
        }
        else {
            current = now[n-k];
            next = (now[n-k] + 1)  % slots.length;
            now[n-k] = next;
        }
        move = "Move disc " + n + " from " + slots[current] + " to " + slots[next] + "\n";

        return hanoi(n-1, k, !left, slots, now) + move + hanoi(n-1, k, !left, slots, now);
    }
    private static void reves(int n, int m, String[] slots) {

    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = (int) Math.round(n+1 - Math.sqrt(n+n+1));
        System.out.println("n = " + n + ", k = " + k);
        String[] slots = {"C", "A", "B"};
        hanoi(k, 0, slots);
        slots = new String[]{"C", "A", "D"};
        hanoi(n, k, slots);
        slots = new String[]{"C", "B", "D"};
        hanoi(k, 0, slots);


    }
}
